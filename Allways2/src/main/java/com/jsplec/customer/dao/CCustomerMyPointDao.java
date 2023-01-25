package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerMyPointDto;


public class CCustomerMyPointDao {

	DataSource dataSource;

	public CCustomerMyPointDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<CCustomerMyPointDto> selectPoint(String customerId) {
		
		ArrayList<CCustomerMyPointDto> dtos = new ArrayList<CCustomerMyPointDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select c.cakeName, o.ordersSalePrice, o.ordersQuantity, o.ordersPoint from orders o, cake c "
					+ "where o.o_cakeId = c.cakeId and o.o_customerId = '" + customerId + "' and o.ordersPoint > 0";
			
			preparedStatement = connection.prepareStatement(query1);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {

				String cakeName = rs.getString(1);
				int ordersSalePrice = rs.getInt(2);
				int ordersQuantity = rs.getInt(3);
				int ordersPoint = rs.getInt(4);
				
				CCustomerMyPointDto dto = new CCustomerMyPointDto(cakeName, ordersSalePrice, ordersQuantity ,ordersPoint);
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
	} //



	
}
