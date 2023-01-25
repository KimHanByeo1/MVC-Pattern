package com.jsplec.customer.dto;

public class CCustomerCartListDto {

	int ordersId;
	String cakeName;
	int ordersSalePrice;
	int ordersQuantity;

	String cakeoptionCategory;
	String cakeoptionValue;
	int cakeoptionPrice;
	String detailoptionLettering;

	public CCustomerCartListDto() {
		// TODO Auto-generated constructor stub
	}

	public CCustomerCartListDto(int ordersId, String cakeName, int ordersSalePrice, int ordersQuantity) {
		super();
		this.ordersId = ordersId;
		this.cakeName = cakeName;
		this.ordersSalePrice = ordersSalePrice;
		this.ordersQuantity = ordersQuantity;
	}

	public CCustomerCartListDto(String cakeoptionCategory, String cakeoptionValue, int cakeoptionPrice,
			String detailoptionLettering) {
		super();
		this.cakeoptionCategory = cakeoptionCategory;
		this.cakeoptionValue = cakeoptionValue;
		this.cakeoptionPrice = cakeoptionPrice;
		this.detailoptionLettering = detailoptionLettering;
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

	public String getDetailoptionLettering() {
		return detailoptionLettering;
	}

	public void setDetailoptionLettering(String detailoptionLettering) {
		this.detailoptionLettering = detailoptionLettering;
	}

}
