package com.aaa.miaosha.entity;

import java.util.Date;
/**
 * table name:  miaosha_order
 * author name: Mr Bai
 * create time: 2019-11-16 14:49:28
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class MiaoshaOrder{

	private long id;
	private long userId;
	private long orderId;
	private long goodsId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
}

