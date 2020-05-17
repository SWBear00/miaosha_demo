package com.aaa.miaosha.controller;
import com.aaa.miaosha.entity.GoodsDetailVo;
import com.aaa.miaosha.entity.GoodsVo;
import com.aaa.miaosha.entity.MiaoShaUser;
import com.aaa.miaosha.redis.GoodsKey;
import com.aaa.miaosha.redis.RedisService;
import com.aaa.miaosha.service.GoodsService;
import com.aaa.miaosha.service.impl.MiaoShaServiceImpl;

import com.aaa.miaosha.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;

import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    MiaoShaServiceImpl userService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    @Autowired
    ApplicationContext applicationContext;

    /**
     * 登陆功能：获取session
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/to_list",produces = "text/html")
    @ResponseBody
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model, MiaoShaUser user){
        model.addAttribute("user", user);
        //查询商品列表
        List<GoodsVo> goodsVo = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsVo);
        //return "goods_list";
        String html = redisService.get(GoodsKey.getGoodsList,"",String.class);
        if (!StringUtils.isEmpty(html)){
            System.out.println("获取goodskey"+GoodsKey.getGoodsList);
            return html;
        }
        WebContext context = new WebContext(request,response,request.getServletContext(),request.getLocale(),model.asMap());
    //手动渲染
        html = thymeleafViewResolver.getTemplateEngine().process("goods_list",context);
        if (StringUtils.isEmpty(html)){
            redisService.set(GoodsKey.getGoodsList,"",html);
            System.out.println(GoodsKey.getGoodsList);
        }
        return html;
    }

    /**
     * 商品详情页
     */
    @RequestMapping(value = "/to_detail1/{goodsId}",produces ="text/html")
    @ResponseBody
    public String to_detail1(HttpServletRequest request, HttpServletResponse response,Model model, MiaoShaUser user,
                            @PathVariable("goodsId")long goodsId){
        String html = redisService.get(GoodsKey.getGoodsDetail,""+goodsId,String.class);
        if (!StringUtils.isEmpty(html)){
            System.out.println("获取goodskey"+GoodsKey.getGoodsDetail);
            return html;
        }
        model.addAttribute("user", user);
       GoodsVo goodsVo=goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goodsVo);

        //获取秒杀的开始、结束时间
        long startAt= goodsVo.getStartDate().getTime();
        long endAt = goodsVo.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int miaoshaStatus = 0;//秒杀开始状态
        int  remainSeconds = 0;//秒杀还有多长时间；

        if (now<startAt){//秒杀还没开始
            miaoshaStatus=0;
            remainSeconds= (int) ((startAt - now)/1000);
        }else if(now>endAt){// 秒杀已经结束
            miaoshaStatus=2;
            remainSeconds=-1;
        }else{//秒杀进行中
            miaoshaStatus=1;
            remainSeconds=0;
        }

        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds",remainSeconds);

        WebContext context = new WebContext(request,response,request.getServletContext(),request.getLocale(),model.asMap());
        //手动渲染
        html = thymeleafViewResolver.getTemplateEngine().process("goods_detail",context);
        if (StringUtils.isEmpty(html)){
            redisService.set(GoodsKey.getGoodsDetail,""+goodsId,html);
            System.out.println(GoodsKey.getGoodsDetail);
        }
        return html;
    }

    /**
     * 商品详情页:模拟前后端分离：只传输数据
     */
    @RequestMapping(value = "/detail/{goodsId}")
    @ResponseBody
    public Result<GoodsDetailVo> to_detail(HttpServletRequest request, HttpServletResponse response, Model model, MiaoShaUser user,
                                           @PathVariable("goodsId")long goodsId){

        System.out.println("进入detail。。");
        GoodsVo goodsVo=goodsService.getGoodsVoByGoodsId(goodsId);
        //获取秒杀的开始、结束时间
        long startAt= goodsVo.getStartDate().getTime();
        long endAt = goodsVo.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int miaoshaStatus = 0;//秒杀开始状态
        int  remainSeconds = 0;//秒杀还有多长时间；

        if (now<startAt){//秒杀还没开始
            miaoshaStatus=0;
            remainSeconds= (int) ((startAt - now)/1000);
        }else if(now>endAt){// 秒杀已经结束
            miaoshaStatus=2;
            remainSeconds=-1;
        }else{//秒杀进行中
            miaoshaStatus=1;
            remainSeconds=0;
        }

        //修改后后台传输的数据
        GoodsDetailVo vo = new GoodsDetailVo();
        vo.setGoods(goodsVo);
        vo.setUser(user);
        vo.setMiaoshaStatus(miaoshaStatus);
        vo.setRemainSeconds(remainSeconds);
        return Result.success(vo);
    }


}
