package com.aaa.miaosha.redis;

public class GoodsKey extends BasePrefix {
    public GoodsKey(int expireSeconds,String prefix) {
        super(expireSeconds,prefix);
    }
    public static GoodsKey getGoodsList = new GoodsKey(6000,"gl");
    public static GoodsKey getGoodsDetail = new GoodsKey(6000,"gd");
}
