package com.aaa.miaosha.service;

import com.aaa.miaosha.entity.GoodsVo;
import com.aaa.miaosha.entity.MiaoShaUser;
import com.aaa.miaosha.entity.OrderInfo;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
public interface MiaoService {
    OrderInfo miaosha(MiaoShaUser user, GoodsVo goods);
}
