package com.jsplec.manager.dto;

public class cakeDetailDto {

	String cakeName;
	int cakePrice;
	String cakeDetail;
	String cakeImage;
	
	public cakeDetailDto(String cakeName, int cakePrice, String cakeDetail, String cakeImage) {
		super();
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
		this.cakeDetail = cakeDetail;
		this.cakeImage = cakeImage;
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
	public String getCakeDetail() {
		return cakeDetail;
	}
	public void setCakeDetail(String cakeDetail) {
		this.cakeDetail = cakeDetail;
	}
	public String getCakeImage() {
		return cakeImage;
	}
	public void setCakeImage(String cakeImage) {
		this.cakeImage = cakeImage;
	}
	
	
}
