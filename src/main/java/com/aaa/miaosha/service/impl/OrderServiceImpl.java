package com.aaa.miaosha.service.impl;

import com.aaa.miaosha.dao.GoodsDao;
import com.aaa.miaosha.dao.OrderDao;
import com.aaa.miaosha.entity.GoodsVo;
import com.aaa.miaosha.entity.MiaoShaUser;
import com.aaa.miaosha.entity.MiaoshaOrder;
import com.aaa.miaosha.entity.OrderInfo;
import com.aaa.miaosha.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;



    @Override
    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId) {

        return orderDao.getMiaoshaOrderByUserIdGoodsId(userId,goodsId);
    }


    /**
     * 添加秒杀商品到秒杀表
     * @param user
     * @param goods
     * @return
     */
    @Override
    public OrderInfo createOrder(MiaoShaUser user, GoodsVo goods) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsPrice(goods.getGoodsPrice());
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);
        orderInfo.setUserId(user.getId());
        long orderId = orderDao.insertOrder(orderInfo);
        MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
        miaoshaOrder.setGoodsId(goods.getId());
        miaoshaOrder.setOrderId(orderId);
        miaoshaOrder.setUserId(user.getId());
        orderDao.insertMiaoshaOrder(miaoshaOrder);
        return orderInfo;
    }
}
