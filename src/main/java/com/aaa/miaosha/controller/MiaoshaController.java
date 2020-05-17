package com.aaa.miaosha.controller;

import com.aaa.miaosha.entity.GoodsVo;
import com.aaa.miaosha.entity.MiaoShaUser;
import com.aaa.miaosha.entity.MiaoshaOrder;
import com.aaa.miaosha.entity.OrderInfo;
import com.aaa.miaosha.redis.RedisService;
import com.aaa.miaosha.service.GoodsService;
import com.aaa.miaosha.service.MiaoService;
import com.aaa.miaosha.service.MiaoShaService;
import com.aaa.miaosha.service.OrderService;
import com.aaa.miaosha.util.CodeMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    RedisService redisService;


    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoService miaoshaService;

    @RequestMapping("/do_miaosha")
    public String list(Model model, MiaoShaUser user,
                       @RequestParam("goodsId")long goodsId){
        model.addAttribute("user", user);
        if (user==null){
            return "login";
        }

        //判断库存
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if (stock <= 0){
            model.addAttribute("errmsg", CodeMsg.MIAO_SHA_OVER.getMsg());
            return "miaosha_fail";
        }

        //判断是否秒杀到
        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(),goodsId);
        if (order != null){
            model.addAttribute("errmsg", CodeMsg.REPEATE_MIAOSHA.getMsg());
            return "miaosha_fail";
        }

        //减库存 下订单 写入秒杀订单
       OrderInfo orderInfo =miaoshaService.miaosha(user,goods);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goods);
        return "order_detail";
    }

}
