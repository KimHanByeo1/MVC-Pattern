package com.jsplec.customer.dto;

public class CCustomerCakeOrderDto {

	int ordersId;
	int cakeId;
	int ordersSalePrice;
	int ordersQuantity;
	String cakeName;

	String customerName;
	String customerPhone;
	String customerEmail;
	String customerPostcode;
	String customerAddress;
	String customerAddressDetail;

	public CCustomerCakeOrderDto() {
		// TODO Auto-generated constructor stub
	}

	public CCustomerCakeOrderDto(int ordersId, int cakeId, int ordersSalePrice, int ordersQuantity, String cakeName) {
		super();
		this.ordersId = ordersId;
		this.cakeId = cakeId;
		this.ordersSalePrice = ordersSalePrice;
		this.ordersQuantity = ordersQuantity;
		this.cakeName = cakeName;
	}

	public CCustomerCakeOrderDto(String customerName, String customerPhone, String customerEmail,
			String customerPostcode, String customerAddress, String customerAddressDetail) {
		super();
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerPostcode = customerPostcode;
		this.customerAddress = customerAddress;
		this.customerAddressDetail = customerAddressDetail;
	}
	
	public CCustomerCakeOrderDto(int ordersSalePrice, int ordersQuantity) {
		super();
		this.ordersSalePrice = ordersSalePrice;
		this.ordersQuantity = ordersQuantity;
	}

	public CCustomerCakeOrderDto(int ordersId) {
		super();
		this.ordersId = ordersId;
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPostcode() {
		return customerPostcode;
	}

	public void setCustomerPostcode(String customerPostcode) {
		this.customerPostcode = customerPostcode;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerAddressDetail() {
		return customerAddressDetail;
	}

	public void setCustomerAddressDetail(String customerAddressDetail) {
		this.customerAddressDetail = customerAddressDetail;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public int getCakeId() {
		return cakeId;
	}

	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}

}
