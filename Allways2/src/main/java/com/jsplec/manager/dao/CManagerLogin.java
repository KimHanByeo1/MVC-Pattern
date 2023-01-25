package com.jsplec.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CManagerLogin {
	
	DataSource dataSource;

	public CManagerLogin() {
	// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	
		}// 

	public boolean	managerLogin(String managerId, String managerPw) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from manager where managerId=? and managerPw=? and managerDeletedate is null";
			ps = connection.prepareStatement(query);
			ps.setString(1, managerId);
			ps.setString(2, managerPw);
			rs = ps.executeQuery();

			if (rs.next()) {
				count=rs.getInt(1);
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
		
		if (count==1) {
			return true;
		} else {
			return false;
		}
	}
	
}
