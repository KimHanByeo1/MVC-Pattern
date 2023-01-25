package com.jsplec.manager.dto;

import java.sql.Timestamp;

public class salesDto {
	
	int ordersquantity;
	int orderssaleprice;
	Timestamp ordersdate;
	
	public salesDto(int ordersquantity, int orderssaleprice, Timestamp ordersdate) {
		super();
		this.ordersquantity = ordersquantity;
		this.orderssaleprice = orderssaleprice;
		this.ordersdate = ordersdate;
	}

	public int getOrdersquantity() {
		return ordersquantity;
	}

	public void setOrdersquantity(int ordersquantity) {
		this.ordersquantity = ordersquantity;
	}

	public int getOrderssaleprice() {
		return orderssaleprice;
	}

	public void setOrderssaleprice(int orderssaleprice) {
		this.orderssaleprice = orderssaleprice;
	}

	public Timestamp getOrdersdate() {
		return ordersdate;
	}

	public void setOrdersdate(Timestamp ordersdate) {
		this.ordersdate = ordersdate;
	}
	
	
}
