package com.aaa.miaosha.controller;
import com.aaa.miaosha.entity.GoodsVo;
import com.aaa.miaosha.entity.MiaoShaUser;
import com.aaa.miaosha.redis.RedisService;
import com.aaa.miaosha.service.GoodsService;
import com.aaa.miaosha.service.impl.MiaoShaServiceImpl;
import com.aaa.miaosha.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    MiaoShaServiceImpl userService;

    @Autowired
    RedisService redisService;

    /**
     * 登陆功能：获取session
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public Result<MiaoShaUser> info(Model model, MiaoShaUser user){
        return Result.success(user);
    }
}
