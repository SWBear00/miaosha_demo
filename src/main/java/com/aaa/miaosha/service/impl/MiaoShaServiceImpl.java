package com.aaa.miaosha.service.impl;

import com.aaa.miaosha.dao.MiaoShaDao;
import com.aaa.miaosha.entity.LoginEntity;
import com.aaa.miaosha.entity.MiaoShaUser;
import com.aaa.miaosha.exception.GlobalException;
import com.aaa.miaosha.redis.MiaoshaUserKey;
import com.aaa.miaosha.redis.RedisService;
import com.aaa.miaosha.service.MiaoShaService;
import com.aaa.miaosha.util.CodeMsg;
import com.aaa.miaosha.util.MD5Util;
import com.aaa.miaosha.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Service
public class MiaoShaServiceImpl implements MiaoShaService {

    public static final String COOKI_NAME_TOKEN = "token";

    @Autowired
    private MiaoShaDao miaoShaDao;

    @Autowired
    private RedisService redisService;

    /**
     * 对象缓存
     * @param id
     * @return
     */
    public MiaoShaUser getById(Long id){
        MiaoShaUser user = redisService.get(MiaoshaUserKey.getById,""+id,MiaoShaUser.class);
        if (user!=null){
            return user;
        }
        //从数据库中获取缓存
        user=miaoShaDao.getById(id);
        //将数据库中的缓存添加到redis中
        redisService.set(MiaoshaUserKey.getById,""+id,user);
        return user;
    }

    //修改密码
    public boolean updatePassword(String token,long id,String newPassword){
        MiaoShaUser user = getById(id);
        if (user==null){
            throw  new GlobalException(CodeMsg.USER_NOT_EXIST);
        }
        //更新数据库
        //获取新的对象,更新哪个写哪个，更有效率
        MiaoShaUser toBeUpdate = new MiaoShaUser();
        toBeUpdate.setId(id);
        toBeUpdate.setPassword(MD5Util.formPassToDBPass(newPassword,user.getSalt()));
        miaoShaDao.updatePassword(toBeUpdate);

        //处理缓存：id和token的缓存都需要更新掉
        redisService.delete(MiaoshaUserKey.getById,""+id);
        redisService.set(MiaoshaUserKey.token,token,user);
        return true;

    }

    /**
     *实现登陆功能
     * @param login
     * @return
     */
    @Override
    public boolean login(HttpServletResponse response,LoginEntity login) {
        if(login == null){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = login.getMobile();
        String password = login.getPassword();
        //判断手机号是否存在
        MiaoShaUser user = getById(Long.parseLong(mobile));
        if (user ==null){
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbpass = user.getPassword();
        String dbsalt = user.getSalt();
        String calpass = MD5Util.formPassToDBPass(password, dbsalt);
        if (!calpass.equals(dbpass)){
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成token
        String token = UUIDUtil.uuid();
        addCookie(response,token, user);
        return true;
    }

    /**
     * 生成cookie
     * @param response
     * @param user
     */
    private void addCookie(HttpServletResponse response,String token ,MiaoShaUser user){
        redisService.set(MiaoshaUserKey.token,token,user);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN,token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());//设置cookie的有效期
        cookie.setPath("/");
        response.addCookie(cookie);

    }
    /**
     * 获取存入redis的user
     * @param token
     * @return
     */
    public MiaoShaUser getByToken(HttpServletResponse response,String token) {
        if (StringUtils.isEmpty(token)){
            return null;
        }
        MiaoShaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoShaUser.class);
        //延长有效期
        if (user!=null){
            addCookie(response,token,user);
        }
        return user;
    }
}
