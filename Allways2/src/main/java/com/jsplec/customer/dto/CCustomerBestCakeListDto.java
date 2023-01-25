package com.jsplec.customer.dto;

public class CCustomerBestCakeListDto {
	
	int cakeId;
	String cakeName;
	int cakePrice;
	String cakeImage;
	
	public CCustomerBestCakeListDto() {
		// TODO Auto-generated constructor stub
	}

	public CCustomerBestCakeListDto(int cakeId, String cakeName, int cakePrice, String cakeImage) {
		super();
		this.cakeId = cakeId;
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
		this.cakeImage = cakeImage;
	}

	public int getCakeId() {
		return cakeId;
	}

	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
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

	public String getCakeImage() {
		return cakeImage;
	}

	public void setCakeImage(String cakeImage) {
		this.cakeImage = cakeImage;
	}
	
	

}
