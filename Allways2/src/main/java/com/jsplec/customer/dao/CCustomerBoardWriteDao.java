package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class CCustomerBoardWriteDao {

	DataSource dataSource;
	
	public CCustomerBoardWriteDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int selectWriteId() {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int writeId = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select max(writeId) from `write`";
			
			preparedStatement = connection.prepareStatement(query);
			
			rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				
				writeId = rs.getInt(1);
				
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
		return writeId;
	} // selectWriteId() --
	
	
	public void boardWrite(int writeId, String customerId, String writeTitle, String writeContent) {
		//write
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into `write` (w_customerId, commentId, distinguish, writeTitle, writeContent, writeInitdate) values (?, ?, ?, ?, ?, now())";
			ps = connection.prepareStatement(query);
			
			ps.setString(1, customerId);
			ps.setInt(2, writeId + 1);
			ps.setInt(3, 0);
			ps.setString(4, writeTitle);
			ps.setString(5, writeContent);
			
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		
	}//write
	
}
