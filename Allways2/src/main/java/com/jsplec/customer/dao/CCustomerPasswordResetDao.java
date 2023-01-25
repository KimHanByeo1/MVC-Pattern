package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CCustomerPasswordResetDao {

	// F
	DataSource dataSource;
	
	// C
	public CCustomerPasswordResetDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc"); // 데이터베이스 연결 끝
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// M
	public boolean userChk(String customerId, String customerName, String customerBirthday , String customerPhone, String customerEmail) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from customer where customerId = '" + customerId + "' and customerName = '" + customerName + "' and customerBirthday = '" + customerBirthday + "' and customerPhone = '" + customerPhone + "' and customerEmail = '" + customerEmail + "' and customerDeletedate is null";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if(ps!=null)ps.close();
				if (connection!=null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(count == 1) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void resetPw(String customerId, String customerPw) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();

			String query = "update customer set customerPw=? where customerId=?";
			ps = connection.prepareStatement(query);
			ps.setString(1, customerPw);
			ps.setString(2, customerId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if(ps!=null)ps.close();
				if (connection!=null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	

	
	
} // End
