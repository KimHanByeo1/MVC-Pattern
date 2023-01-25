package com.jsplec.customer.dto;

import java.sql.Date;

public class CCustomerCommentListDto {

	String writeContent;
	Date writeInitdate;
	
	public CCustomerCommentListDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public CCustomerCommentListDto(String writeContent, Date writeInitdate) {
		super();
		this.writeContent = writeContent;
		this.writeInitdate = writeInitdate;
	}



	public String getWriteContent() {
		return writeContent;
	}

	public void setWriteContent(String writeContent) {
		this.writeContent = writeContent;
	}

	public Date getWriteInitdate() {
		return writeInitdate;
	}

	public void setWriteInitdate(Date writeInitdate) {
		this.writeInitdate = writeInitdate;
	}

	
	
}
