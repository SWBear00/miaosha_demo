package com.aaa.miaosha.service.impl;

import com.aaa.miaosha.dao.GoodsDao;
import com.aaa.miaosha.entity.Goods;
import com.aaa.miaosha.entity.GoodsVo;
import com.aaa.miaosha.entity.MiaoShaUser;
import com.aaa.miaosha.entity.OrderInfo;
import com.aaa.miaosha.service.GoodsService;
import com.aaa.miaosha.service.MiaoService;
import com.aaa.miaosha.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Service
public class MiaoServiceImpl implements MiaoService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Transactional
    public OrderInfo miaosha(MiaoShaUser user, GoodsVo goods){
    //减少库存 下订单 写入秒杀订单
        goodsService.reduceStock(goods);

        OrderInfo orderInfo = orderService.createOrder(user,goods);
        return orderInfo;



    }
}
