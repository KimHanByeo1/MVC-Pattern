package com.jsplec.customer.dto;

public class CCustomerCakeOptionListDto {

	int cakeoptionId;
	String cakeoptionCategory;
	String cakeoptionValue;
	int cakeoptionPrice;
	int ordersId;
	String ordersStatus;

	public CCustomerCakeOptionListDto() {
		// TODO Auto-generated constructor stub
	}

	public CCustomerCakeOptionListDto(int cakeoptionId, String cakeoptionCategory, String cakeoptionValue,
			int cakeoptionPrice) {
		super();
		this.cakeoptionId = cakeoptionId;
		this.cakeoptionCategory = cakeoptionCategory;
		this.cakeoptionValue = cakeoptionValue;
		this.cakeoptionPrice = cakeoptionPrice;
	}

	public CCustomerCakeOptionListDto(int ordersId, String ordersStatus) {
		super();
		this.ordersId = ordersId;
		this.ordersStatus = ordersStatus;
	}

	public CCustomerCakeOptionListDto(int cakeoptionPrice) {
		super();
		this.cakeoptionPrice = cakeoptionPrice;
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

}
