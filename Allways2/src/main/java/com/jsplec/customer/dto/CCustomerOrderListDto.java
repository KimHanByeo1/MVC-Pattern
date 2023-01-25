package com.jsplec.customer.dto;

import java.sql.Date;

public class CCustomerOrderListDto {

	int ROWNUM;
	int ordersId;
	String cakeName;
	String o_customerId;
	int ordersSalePrice;
	int ordersQuantity;
	Date ordersDate;
	int o_cakeId;
	
	public CCustomerOrderListDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CCustomerOrderListDto(int ROWNUM, int ordersId, String cakeName, String o_customerId, int ordersSalePrice,
			int ordersQuantity, Date ordersDate, int o_cakeId) {
		super();
		this.ROWNUM = ROWNUM;
		this.ordersId = ordersId;
		this.cakeName = cakeName;
		this.o_customerId = o_customerId;
		this.ordersSalePrice = ordersSalePrice;
		this.ordersQuantity = ordersQuantity;
		this.ordersDate = ordersDate;
		this.o_cakeId = o_cakeId;
	}



	
	public int getROWNUM() {
		return ROWNUM;
	}

	public void setROWNUM(int rOWNUM) {
		ROWNUM = rOWNUM;
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public String getO_customerId() {
		return o_customerId;
	}

	public void setO_customerId(String o_customerId) {
		this.o_customerId = o_customerId;
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

	public Date getOrdersDate() {
		return ordersDate;
	}

	public void setOrdersDate(Date ordersDate) {
		this.ordersDate = ordersDate;
	}

	public int getO_cakeId() {
		return o_cakeId;
	}

	public void setO_cakeId(int o_cakeId) {
		this.o_cakeId = o_cakeId;
	}

	
	
	
	
}
