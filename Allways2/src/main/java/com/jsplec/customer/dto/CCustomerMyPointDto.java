package com.jsplec.customer.dto;

public class CCustomerMyPointDto {

	String cakeName;
	int ordersSalePrice;
	int ordersQuantity;
	int ordersPoint;
	
	public CCustomerMyPointDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public CCustomerMyPointDto(String cakeName, int ordersSalePrice, int ordersQuantity, int ordersPoint) {
		super();
		this.cakeName = cakeName;
		this.ordersSalePrice = ordersSalePrice;
		this.ordersQuantity = ordersQuantity;
		this.ordersPoint = ordersPoint;
	}



	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
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
	
	
	
}
