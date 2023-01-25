package com.jsplec.customer.dto;

import java.sql.Date;

public class CCustomerAnswerDto {

	String a_managerId;
	String answerContent;
	Date answerInitdate;
	
	public CCustomerAnswerDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public CCustomerAnswerDto(String a_managerId, String answerContent, Date answerInitdate) {
		super();
		this.a_managerId = a_managerId;
		this.answerContent = answerContent;
		this.answerInitdate = answerInitdate;
	}



	public String getA_managerId() {
		return a_managerId;
	}

	public void setA_managerId(String a_managerId) {
		this.a_managerId = a_managerId;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Date getAnswerInitdate() {
		return answerInitdate;
	}

	public void setAnswerInitdate(Date answerInitdate) {
		this.answerInitdate = answerInitdate;
	}
	
	
	
}
