package com.jsplec.customer.dto;

import java.sql.Date;

public class CCustomerQuestionDto {

	int rowNum;
	String q_customerId;
	String questionTitle;
	Date questionInitdate;
	int questionId;
	
	public CCustomerQuestionDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public CCustomerQuestionDto(int rowNum, String q_customerId, String questionTitle, Date questionInitdate, int questionId) {
		super();
		this.rowNum = rowNum;
		this.q_customerId = q_customerId;
		this.questionTitle = questionTitle;
		this.questionInitdate = questionInitdate;
		this.questionId = questionId;
	}



	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getQ_customerId() {
		return q_customerId;
	}

	public void setQ_customerId(String q_customerId) {
		this.q_customerId = q_customerId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Date getQuestionInitdate() {
		return questionInitdate;
	}

	public void setQuestionInitdate(Date questionInitdate) {
		this.questionInitdate = questionInitdate;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	






	
	
	
}
