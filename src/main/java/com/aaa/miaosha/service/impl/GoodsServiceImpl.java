package com.aaa.miaosha.service.impl;

import com.aaa.miaosha.dao.GoodsDao;
import com.aaa.miaosha.entity.Goods;
import com.aaa.miaosha.entity.GoodsVo;
import com.aaa.miaosha.entity.MiaoshaGoods;
import com.aaa.miaosha.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsdao;

    /**
     * 获取秒杀界面信息
     * @return
     */
    public List<GoodsVo> listGoodsVo(){
        return goodsdao.listGoodsVo();
    }

    /**
     *获取商品详情页
     * @param goodsId
     * @return
     */
    @Override
    public GoodsVo getGoodsVoByGoodsId(long goodsId) {

        return goodsdao.getGoodsVoByGoodsId(goodsId);
    }

    /**
     * 减少库存
     * @param goods
     */
    @Override
    public void reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        goodsdao.reduceStock(g);
    }

}
