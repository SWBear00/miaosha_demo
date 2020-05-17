package com.aaa.miaosha.dao;

import com.aaa.miaosha.entity.Goods;
import com.aaa.miaosha.entity.GoodsVo;
import com.aaa.miaosha.entity.MiaoshaGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Mapper
public interface GoodsDao {

    @Select("select g.*,mg.stock_count,mg.start_date,mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id=g.id")
    public List<GoodsVo> listGoodsVo ();

    @Select("select g.*,mg.stock_count,mg.start_date,mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id=g.id where g.id=#{goodsId}")
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    @Update("update miaosha_goods set stock_count= stock_count - 1 where goods_id = #{goodsId}")
    int reduceStock(MiaoshaGoods g);
}
