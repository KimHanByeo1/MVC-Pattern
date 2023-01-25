package com.jsplec.customer.dto;

import java.sql.Timestamp;

public class CCustomerUserinfoDto {

	// F
	String customerId;
	String customerPw;
	String customerName;
	String customerGender;
	String customerPhone;
	String customerEmail;
	String customerBirthday;
	String customerPostcode;
	String customerAddress;
	String customerAddressDetail;
	Timestamp customerInitdate;
	Timestamp customerUpdatedate;
	Timestamp customerDeletedate;
	
	String customerEmailId;
	String customerEmailDomain;
	
	
	// C
	public CCustomerUserinfoDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CCustomerUserinfoDto(String customerPw, String customerName, String customerGender,
			String customerPhone, String customerBirthday, String customerPostcode,
			String customerAddress, String customerAddressDetail) {
		super();
		this.customerPw = customerPw;
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.customerPhone = customerPhone;
		this.customerBirthday = customerBirthday;
		this.customerPostcode = customerPostcode;
		this.customerAddress = customerAddress;
		this.customerAddressDetail = customerAddressDetail;
	}

	


	public CCustomerUserinfoDto(String customerEmailId, String customerEmailDomain) {
		super();
		this.customerEmailId = customerEmailId;
		this.customerEmailDomain = customerEmailDomain;
	}



	// M
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
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

	public String getCustomerBirthday() {
		return customerBirthday;
	}

	public void setCustomerBirthday(String customerBirthday) {
		this.customerBirthday = customerBirthday;
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

	public Timestamp getCustomerInitdate() {
		return customerInitdate;
	}

	public void setCustomerInitdate(Timestamp customerInitdate) {
		this.customerInitdate = customerInitdate;
	}

	public Timestamp getCustomerUpdatedate() {
		return customerUpdatedate;
	}

	public void setCustomerUpdatedate(Timestamp customerUpdatedate) {
		this.customerUpdatedate = customerUpdatedate;
	}

	public Timestamp getCustomerDeletedate() {
		return customerDeletedate;
	}

	public void setCustomerDeletedate(Timestamp customerDeletedate) {
		this.customerDeletedate = customerDeletedate;
	}



	public String getCustomerEmailId() {
		return customerEmailId;
	}



	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}



	public String getCustomerEmailDomain() {
		return customerEmailDomain;
	}



	public void setCustomerEmailDomain(String customerEmailDomain) {
		this.customerEmailDomain = customerEmailDomain;
	}
	
	
	
	
	
}// End
