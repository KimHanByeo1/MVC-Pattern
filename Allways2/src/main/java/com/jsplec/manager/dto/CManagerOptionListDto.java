package com.jsplec.manager.dto;

public class CManagerOptionListDto {

	int cakeoptionId;
	String cakeoptionCategory;
	String cakeoptionValue;
	int cakeoptionPrice;
	String cakeoptionImage;
	
	
	
	
	
	public int getCakeoptionPrice() {
		return cakeoptionPrice;
	}
	public void setCakeoptionPrice(int cakeoptionPrice) {
		this.cakeoptionPrice = cakeoptionPrice;
	}
	public int getCakeoptionId() {
		return cakeoptionId;
	}
	public void setCakeoptionId(int cakeoptionId) {
		this.cakeoptionId = cakeoptionId;
	}
	public String getCakeoptionCategory() {
		return cakeoptionCategory;
	}
	public void setCakeoptionCategory(String cakeoptionCategory) {
		this.cakeoptionCategory = cakeoptionCategory;
	}
	public String getCakeoptionValue() {
		return cakeoptionValue;
	}
	public void setCakeoptionValue(String cakeoptionValue) {
		this.cakeoptionValue = cakeoptionValue;
	}
	public String getCakeoptionImage() {
		return cakeoptionImage;
	}
	public void setCakeoptionImage(String cakeoptionImage) {
		this.cakeoptionImage = cakeoptionImage;
	}
	
	
	public CManagerOptionListDto(int cakeoptionId, String cakeoptionCategory, String cakeoptionValue,
			int cakeoptionPrice) {
		super();
		this.cakeoptionId = cakeoptionId;
		this.cakeoptionCategory = cakeoptionCategory;
		this.cakeoptionValue = cakeoptionValue;
		this.cakeoptionPrice = cakeoptionPrice;
	}
	public CManagerOptionListDto(int cakeoptionId, String cakeoptionCategory, String cakeoptionValue, int cakeoptionPrice, String cakeoptionImage) {
		super();
		this.cakeoptionId = cakeoptionId;
		this.cakeoptionCategory = cakeoptionCategory;
		this.cakeoptionValue = cakeoptionValue;
		this.cakeoptionPrice = cakeoptionPrice;
		this.cakeoptionImage = cakeoptionImage;
	}
	
	
}
