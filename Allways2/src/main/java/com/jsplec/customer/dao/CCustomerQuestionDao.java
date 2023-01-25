package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerQuestionDto;

public class CCustomerQuestionDao {

	DataSource dataSource;
	
	public CCustomerQuestionDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CCustomerQuestionDto> questionList() {
		
		ArrayList<CCustomerQuestionDto> dtos = new ArrayList<CCustomerQuestionDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from (select row_number() over(order by questionInitdate desc) as rownum, "
					+ " q_customerId, questionTitle, questionInitdate, questionId from question order by questionInitdate desc) q";
			
//			String query = "select w_customerId, writeTitle, writeContent, writeInitdate from `write` ";
			
			preparedStatement = connection.prepareStatement(query);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				int rowNum = rs.getInt(1);
				String q_customerId = rs.getString(2);
				String questionTitle = rs.getString(3);
				Date questionInitdate = rs.getDate(4);
				int questionId = rs.getInt(5);
				
				CCustomerQuestionDto dto = new CCustomerQuestionDto(rowNum, q_customerId, questionTitle, questionInitdate, questionId);
				dtos.add(dto);
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
		return dtos;
	} // reviewList1() --
	
	
}
