package com.jsplec.manager.dto;

import java.sql.Timestamp;

public class ordersReviewDto {

	int oreviewId;
	String or_customerId;
	String or_customerName;
	String or_cakeName;
	String or_goodsName;
	String oreviewContent;
	int oreviewStarrating;
	String oreviewImage;
	
	Timestamp oreviewInitdate;
	Timestamp oreviewUpadatedate;
	
	public ordersReviewDto(int oreviewId, String or_customerId, String or_customerName, String or_cakeName,
			String or_goodsName, String oreviewContent, int oreviewStarrating, String oreviewImage,
			Timestamp oreviewInitdate, Timestamp oreviewUpadatedate) {
		super();
		this.oreviewId = oreviewId;
		this.or_customerId = or_customerId;
		this.or_customerName = or_customerName;
		this.or_cakeName = or_cakeName;
		this.or_goodsName = or_goodsName;
		this.oreviewContent = oreviewContent;
		this.oreviewStarrating = oreviewStarrating;
		this.oreviewImage = oreviewImage;
		this.oreviewInitdate = oreviewInitdate;
		this.oreviewUpadatedate = oreviewUpadatedate;
	}

	public ordersReviewDto(String or_customerId, int oreviewStarrating, Timestamp oreviewInitdate) {
		super();
		this.or_customerId = or_customerId;
		this.oreviewStarrating = oreviewStarrating;
		this.oreviewInitdate = oreviewInitdate;
	}
	
	public ordersReviewDto(int oreviewId, String or_customerId, String or_cakeName, String or_goodsName,
			int oreviewStarrating, Timestamp oreviewInitdate) {
		super();
		this.oreviewId = oreviewId;
		this.or_customerId = or_customerId;
		this.or_cakeName = or_cakeName;
		this.or_goodsName = or_goodsName;
		this.oreviewStarrating = oreviewStarrating;
		this.oreviewInitdate = oreviewInitdate;
	}

	public String getOr_goodsName() {
		return or_goodsName;
	}

	public void setOr_goodsName(String or_goodsName) {
		this.or_goodsName = or_goodsName;
	}

	public String getOreviewImage() {
		return oreviewImage;
	}

	public void setOreviewImage(String oreviewImage) {
		this.oreviewImage = oreviewImage;
	}

	public int getOreviewId() {
		return oreviewId;
	}
	public void setOreviewId(int oreviewId) {
		this.oreviewId = oreviewId;
	}
	public String getOr_customerId() {
		return or_customerId;
	}
	public void setOr_customerId(String or_customerId) {
		this.or_customerId = or_customerId;
	}
	public String getOr_customerName() {
		return or_customerName;
	}
	public void setOr_customerName(String or_customerName) {
		this.or_customerName = or_customerName;
	}
	public String getOr_cakeName() {
		return or_cakeName;
	}
	public void setOr_cakeName(String or_cakeName) {
		this.or_cakeName = or_cakeName;
	}
	public String getOreviewContent() {
		return oreviewContent;
	}
	public void setOreviewContent(String oreviewContent) {
		this.oreviewContent = oreviewContent;
	}
	public int getOreviewStarrating() {
		return oreviewStarrating;
	}
	public void setOreviewStarrating(int oreviewStarrating) {
		this.oreviewStarrating = oreviewStarrating;
	}
	public Timestamp getOreviewInitdate() {
		return oreviewInitdate;
	}
	public void setOreviewInitdate(Timestamp oreviewInitdate) {
		this.oreviewInitdate = oreviewInitdate;
	}
	public Timestamp getOreviewUpadatedate() {
		return oreviewUpadatedate;
	}
	public void setOreviewUpadatedate(Timestamp oreviewUpadatedate) {
		this.oreviewUpadatedate = oreviewUpadatedate;
	}
	
	
}
