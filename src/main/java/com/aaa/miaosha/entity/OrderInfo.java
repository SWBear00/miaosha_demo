package com.aaa.miaosha.entity;

import java.util.Date;
/**
 * table name:  order_info
 * author name: Mr Bai
 * create time: 2019-11-16 14:49:28
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class OrderInfo{

	private long id;
	private long userId;
	private long goodsId;
	private long deliveryAddrId;
	private String goodsName;
	private int goodsCount;
	private double goodsPrice;
	private int orderChannel;
	private int status;
	private java.util.Date createDate;
	private java.util.Date payDate;

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

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public long getDeliveryAddrId() {
		return deliveryAddrId;
	}

	public void setDeliveryAddrId(long deliveryAddrId) {
		this.deliveryAddrId = deliveryAddrId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getOrderChannel() {
		return orderChannel;
	}

	public void setOrderChannel(int orderChannel) {
		this.orderChannel = orderChannel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
}

