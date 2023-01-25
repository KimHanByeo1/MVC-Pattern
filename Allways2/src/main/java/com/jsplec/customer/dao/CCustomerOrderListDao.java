package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerOrderListDto;

public class CCustomerOrderListDao {

DataSource dataSource;
	
	public CCustomerOrderListDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 리뷰 작성 orderList
	public ArrayList<CCustomerOrderListDto> orderList(String CUSTOMERID) {
		
		ArrayList<CCustomerOrderListDto> dtos = new ArrayList<CCustomerOrderListDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select @rownum:=@rownum+1, o.ordersId, ANY_VALUE(c.cakeName), ANY_VALUE(o.o_customerId), ANY_VALUE(o.ordersSalePrice), "
					+ "ANY_VALUE(o.ordersQuantity), ANY_VALUE(o.ordersDate), ANY_VALUE(o_cakeId) "
					+ "from orders o, cake c "
					+ "where (@rownum:=0)=0 and o.ordersReviewstatus is null and o.o_customerId = '" + CUSTOMERID + "' and o.ordersStatus = '제작완료' and o.o_cakeId = c.cakeId "
					+ "group by o.ordersId";
			
			preparedStatement = connection.prepareStatement(query);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				int ROWNUM = rs.getInt(1);
				int ordersId = rs.getInt(2);
				String cakeName = rs.getString(3);
				String customerId = rs.getString(4);
				int ordersSalePrice = rs.getInt(5);
				int ordersQuantity = rs.getInt(6);
				Date ordersDate = rs.getDate(7);
				int o_cakeId = rs.getInt(8);
				
				CCustomerOrderListDto dto = new CCustomerOrderListDto(ROWNUM, ordersId, cakeName, customerId, ordersSalePrice, ordersQuantity, ordersDate, o_cakeId);
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
	} // orderList() --
	
	
	// 내가 주문한 전체 orderList
	public ArrayList<CCustomerOrderListDto> ordersList(String CUSTOMERID) {
		
		ArrayList<CCustomerOrderListDto> dtos = new ArrayList<CCustomerOrderListDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select @rownum:=@rownum+1, o.ordersId, ANY_VALUE(c.cakeName), ANY_VALUE(o.o_customerId), ANY_VALUE(o.ordersSalePrice), "
					+ "ANY_VALUE(o.ordersQuantity), ANY_VALUE(o.ordersDate), ANY_VALUE(o_cakeId) "
					+ "from orders o, cake c "
					+ "where (@rownum:=0)=0 and o.o_customerId = '" + CUSTOMERID + "' and o.ordersStatus = '구매' and o.o_cakeId = c.cakeId "
					+ "group by o.ordersId";
			
			preparedStatement = connection.prepareStatement(query);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				int ROWNUM = rs.getInt(1);
				int ordersId = rs.getInt(2);
				String cakeName = rs.getString(3);
				String customerId = rs.getString(4);
				int ordersSalePrice = rs.getInt(5);
				int ordersQuantity = rs.getInt(6);
				Date ordersDate = rs.getDate(7);
				int o_cakeId = rs.getInt(8);
				
				CCustomerOrderListDto dto = new CCustomerOrderListDto(ROWNUM, ordersId, cakeName, customerId, ordersSalePrice, ordersQuantity, ordersDate, o_cakeId);
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
	} // orderList() --

	
}
