package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class customerWriteCommandDao {

	DataSource dataSource;

	public customerWriteCommandDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void writeComment(String CUSTOMERID, int writeId, String writeContent) {
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "insert into `write` (w_customerId, distinguish, commentId, recommentId, writeContent, writeInitdate) "
						 + "values (?, ?, ?, ?, ?, now())";
			
			ps = connection.prepareStatement(query);
			
			ps.setString(1, CUSTOMERID);
			ps.setInt(2, 1);
			ps.setInt(3, writeId);
			ps.setInt(4, 0);
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
	}
	
	
	
}
