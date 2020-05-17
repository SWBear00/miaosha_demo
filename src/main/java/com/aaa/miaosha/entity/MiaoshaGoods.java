package com.aaa.miaosha.entity;

import java.util.Date;
/**
 * table name:  miaosha_goods
 * author name: Mr Bai
 * create time: 2019-11-16 14:49:28
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class MiaoshaGoods{

	private long id;
	private long goodsId;
	private double miaoshaPrice;
	private int stockCount;
	private java.util.Date startDate;
	private java.util.Date endDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public double getMiaoshaPrice() {
		return miaoshaPrice;
	}

	public void setMiaoshaPrice(double miaoshaPrice) {
		this.miaoshaPrice = miaoshaPrice;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}

