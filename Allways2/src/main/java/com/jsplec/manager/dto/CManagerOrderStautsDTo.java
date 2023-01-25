package com.jsplec.manager.dto;

public class CManagerOrderStautsDTo {
	int ordersId;
	String ordersStatus;
	String o_customerId;
	int o_cakeId;
	String cakeName;
	int o_goodsId;
	String goodsName;
	int ordersSalePrice;
	int ordersQuantity;
	int ordersPoint;
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public String getOrdersStatus() {
		return ordersStatus;
	}
	public void setOrdersStatus(String ordersStatus) {
		this.ordersStatus = ordersStatus;
	}
	public String getO_customerId() {
		return o_customerId;
	}
	public void setO_customerId(String o_customerId) {
		this.o_customerId = o_customerId;
	}
	public int getO_cakeId() {
		return o_cakeId;
	}
	public void setO_cakeId(int o_cakeId) {
		this.o_cakeId = o_cakeId;
	}
	public String getCakeName() {
		return cakeName;
	}
	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}
	public int getO_goodsId() {
		return o_goodsId;
	}
	public void setO_goodsId(int o_goodsId) {
		this.o_goodsId = o_goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getOrdersSalePrice() {
		return ordersSalePrice;
	}
	public void setOrdersSalePrice(int ordersSalePrice) {
		this.ordersSalePrice = ordersSalePrice;
	}
	public int getOrdersQuantity() {
		return ordersQuantity;
	}
	public void setOrdersQuantity(int ordersQuantity) {
		this.ordersQuantity = ordersQuantity;
	}
	public int getOrdersPoint() {
		return ordersPoint;
	}
	public void setOrdersPoint(int ordersPoint) {
		this.ordersPoint = ordersPoint;
	}
	public CManagerOrderStautsDTo(int ordersId, String ordersStatus, String o_customerId, int o_cakeId, String cakeName,
			int o_goodsId, String goodsName, int ordersSalePrice, int ordersQuantity, int ordersPoint) {
		super();
		this.ordersId = ordersId;
		this.ordersStatus = ordersStatus;
		this.o_customerId = o_customerId;
		this.o_cakeId = o_cakeId;
		this.cakeName = cakeName;
		this.o_goodsId = o_goodsId;
		this.goodsName = goodsName;
		this.ordersSalePrice = ordersSalePrice;
		this.ordersQuantity = ordersQuantity;
		this.ordersPoint = ordersPoint;
	}
	

	
	

}
