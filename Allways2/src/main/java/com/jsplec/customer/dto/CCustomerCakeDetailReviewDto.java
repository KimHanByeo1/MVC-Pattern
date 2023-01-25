package com.jsplec.customer.dto;

import java.sql.Date;

public class CCustomerCakeDetailReviewDto {
	
	int rowNum;
	String or_customerId;
	String oreviewContent;
	Date oreviewInitdate;
	String oreviewImage;
	int oreviewStarrating;
	int or_cakeId;
	
	public CCustomerCakeDetailReviewDto() {
		// TODO Auto-generated constructor stub
	}

	public CCustomerCakeDetailReviewDto(int rowNum, String or_customerId, String oreviewContent, Date oreviewInitdate,
			String oreviewImage, int oreviewStarrating, int or_cakeId) {
		super();
		this.rowNum = rowNum;
		this.or_customerId = or_customerId;
		this.oreviewContent = oreviewContent;
		this.oreviewInitdate = oreviewInitdate;
		this.oreviewImage = oreviewImage;
		this.oreviewStarrating = oreviewStarrating;
		this.or_cakeId = or_cakeId;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getOr_customerId() {
		return or_customerId;
	}

	public void setOr_customerId(String or_customerId) {
		this.or_customerId = or_customerId;
	}

	public String getOreviewContent() {
		return oreviewContent;
	}

	public void setOreviewContent(String oreviewContent) {
		this.oreviewContent = oreviewContent;
	}

	public Date getOreviewInitdate() {
		return oreviewInitdate;
	}

	public void setOreviewInitdate(Date oreviewInitdate) {
		this.oreviewInitdate = oreviewInitdate;
	}

	public String getOreviewImage() {
		return oreviewImage;
	}

	public void setOreviewImage(String oreviewImage) {
		this.oreviewImage = oreviewImage;
	}

	public int getOreviewStarrating() {
		return oreviewStarrating;
	}

	public void setOreviewStarrating(int oreviewStarrating) {
		this.oreviewStarrating = oreviewStarrating;
	}

	public int getOr_cakeId() {
		return or_cakeId;
	}

	public void setOr_cakeId(int or_cakeId) {
		this.or_cakeId = or_cakeId;
	}
	
	

}
