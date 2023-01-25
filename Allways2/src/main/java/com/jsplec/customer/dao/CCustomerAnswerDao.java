package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerAnswerDto;

public class CCustomerAnswerDao {

	DataSource dataSource;
	
	public CCustomerAnswerDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public CCustomerAnswerDto answerList(int questionId) {
		
		CCustomerAnswerDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select a_managerId, answerContent, answerInitdate from answer where a_questionId = " + questionId;
			
			preparedStatement = connection.prepareStatement(query);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				String a_managerId = rs.getString(1);
				String answerContent = rs.getString(2);
				Date answerInitdate = rs.getDate(3);
				
				dto = new CCustomerAnswerDto(a_managerId, answerContent, answerInitdate);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	} // reviewList1() --
	
}
