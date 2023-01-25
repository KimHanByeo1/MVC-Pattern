package com.jsplec.customer.dto;

public class CCustomerCakeQuickOrderDto {

	String cakeName;
	int cakePrice;

	public CCustomerCakeQuickOrderDto() {
		// TODO Auto-generated constructor stub
	}

	public CCustomerCakeQuickOrderDto(String cakeName, int cakePrice) {
		super();
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public int getCakePrice() {
		return cakePrice;
	}

	public void setCakePrice(int cakePrice) {
		this.cakePrice = cakePrice;
	}

}
