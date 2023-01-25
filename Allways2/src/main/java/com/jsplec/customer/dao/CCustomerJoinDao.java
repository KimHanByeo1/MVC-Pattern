package com.jsplec.customer.dao;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;


public class CCustomerJoinDao {

	// F
	DataSource dataSource;
	
	// C
	public CCustomerJoinDao() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// M
	public boolean idCheck(String customerId) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from customer where customerId = '" + customerId + "' and customerDeletedate is null";
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(count==1) {
			return true;			
		}else {
			return false;
		}
		
	} // idCheck
	
	public void insertAction(String customerId, String customerPw, String customerName, String customerGender, String customerPhone, String customerEmail, String customerBirthday, String customerPostcode, String customerAddress, String customerAddressDetail) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();

			String query = "insert into customer (customerId, customerPw, customerName, customerGender, customerPhone, customerEmail, customerBirthday, customerPostcode, customerAddress, customerAddressDetail, customerInitdate) ";
			String query1 = "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
			ps = connection.prepareStatement(query + query1);
			
			ps.setString(1, customerId);
			ps.setString(2, customerPw);
			ps.setString(3, customerName);
			ps.setString(4, customerGender);
			ps.setString(5, customerPhone);
			ps.setString(6, customerEmail);
			ps.setString(7, customerBirthday);
			ps.setString(8, customerPostcode);
			ps.setString(9, customerAddress);
			ps.setString(10, customerAddressDetail);
			
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
	
	public void updateAction(String customerId, String customerPw, String customerName, String customerGender, String customerPhone, String customerEmail, String customerBirthday, String customerPostcode, String customerAddress, String customerAddressDetail) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();

			String query = "update customer set customerPw=?, customerName=?, customerGender=?, customerPhone=?, customerEmail=?, customerBirthday=?, customerPostcode=?, customerAddress=?, customerAddressDetail=?, customerUpdatedate=now() where customerId=?";
			ps = connection.prepareStatement(query);
			
			ps.setString(1, customerPw);
			ps.setString(2, customerName);
			ps.setString(3, customerGender);
			ps.setString(4, customerPhone);
			ps.setString(5, customerEmail);
			ps.setString(6, customerBirthday);
			ps.setString(7, customerPostcode);
			ps.setString(8, customerAddress);
			ps.setString(9, customerAddressDetail);
			ps.setString(10, customerId);
			
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
	
	public void deleteAction(String customerId) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();

			String query = "update customer set customerDeletedate=now() where customerId=?";
			ps = connection.prepareStatement(query);
			
			ps.setString(1, customerId);
			
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
