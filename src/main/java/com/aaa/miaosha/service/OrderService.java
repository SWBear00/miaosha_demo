package com.aaa.miaosha.service;

import com.aaa.miaosha.entity.GoodsVo;
import com.aaa.miaosha.entity.MiaoShaUser;
import com.aaa.miaosha.entity.MiaoshaOrder;
import com.aaa.miaosha.entity.OrderInfo;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
public interface OrderService {
    MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long id, long goodsId);

    OrderInfo createOrder(MiaoShaUser user, GoodsVo goods);
}
