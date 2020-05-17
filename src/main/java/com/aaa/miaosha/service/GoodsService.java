package com.aaa.miaosha.service;

import com.aaa.miaosha.entity.GoodsVo;

import java.util.List;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
public interface GoodsService {
    List<GoodsVo> listGoodsVo();

    GoodsVo getGoodsVoByGoodsId(long goodsId);

    void reduceStock(GoodsVo goods);
}
