package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerCommentListDto;

public class CCustomerCommentListDao {

	DataSource dataSource;
	
	public CCustomerCommentListDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CCustomerCommentListDto> commentList() {
		
		ArrayList<CCustomerCommentListDto> dtos = new ArrayList<CCustomerCommentListDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select writeContent, writeInitdate from `write` "
						+ "where commentId = 2 "
						+ "order by writeInitdate desc";
			
			preparedStatement = connection.prepareStatement(query);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				String writeContent = rs.getString(1);
				Date writeInitdate = rs.getDate(2);
				
				CCustomerCommentListDto dto = new CCustomerCommentListDto(writeContent, writeInitdate);
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
	} // commentList() --
	
}
