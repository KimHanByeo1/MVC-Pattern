package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerWriteListDto;

public class CCustomerWriteListDao {

	DataSource dataSource;
	
	public CCustomerWriteListDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CCustomerWriteListDto> writeList(String combo, String searchContent) {
		
		ArrayList<CCustomerWriteListDto> dtos = new ArrayList<CCustomerWriteListDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from ( "
					+ "	select row_number() over(order by commentId) as rownum, "
					+ " writeTitle, writeContent, w_customerId, writeInitdate, distinguish, writeId, writeDeletedate, commentId "
					+ "	from `write` where " + combo + " like '%" + searchContent + "%' "
					+ " order by commentId desc, writeInitdate asc) w";
			
			preparedStatement = connection.prepareStatement(query);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				int rowNum = rs.getInt(1);
				String writeTitle = rs.getString(2);
				String writeContent = rs.getString(3);
				String w_customerId = rs.getString(4);
				Date writeInitdate = rs.getDate(5);
				int distinguish = rs.getInt(6);
				int writeId = rs.getInt(7);
				Date writeDeletedate = rs.getDate(8);
				int commentId = rs.getInt(9);
				
				CCustomerWriteListDto dto = new CCustomerWriteListDto(rowNum, writeTitle, writeContent, w_customerId, 
																writeInitdate, distinguish, writeId, writeDeletedate, commentId);
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
	} // writeList() --
	
	
	public CCustomerWriteListDto boardDetail(int WRITEID) {
		CCustomerWriteListDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select w.writeId, c.customerName, w.writeTitle, w.writeContent, w.writeInitdate "
					+ "from `write` w, customer c "
					+ "where w.w_customerId = c.customerId and w.writeId = " + WRITEID;
			
			preparedStatement = connection.prepareStatement(query);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				int writeId = rs.getInt(1);
				String customerName = rs.getString(2);
				String writeTitle = rs.getString(3);
				String writeContent = rs.getString(4);
				Date writeInitdate = rs.getDate(5);
				
				dto = new CCustomerWriteListDto(writeId, customerName, writeTitle, writeContent, writeInitdate);
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
	} // boardDetail() --
	
	
	public ArrayList<CCustomerWriteListDto> boardComment(int WRITEID) {
		
		ArrayList<CCustomerWriteListDto> dtos = new ArrayList<CCustomerWriteListDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from ( "
					+ "	select row_number() over(order by commentId) as rownum, c.customerName, w.writeContent, w.writeInitdate, w.w_customerId, distinguish, recommentId, writeDeletedate, writeId "
					+ "	from `write` w, customer c "
					+ "    where commentId = " + WRITEID + " and distinguish > 0 and w.w_customerId = c.customerId "
					+ "    order by recommentId) w";
			
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				String customerName = rs.getString(2);
				String writeContent = rs.getString(3);
				Date writeInitdate = rs.getDate(4);
				String w_customerId = rs.getString(5);
				int distinguish = rs.getInt(6);
				int recommentId = rs.getInt(7);
				Date writeDeletedate = rs.getDate(8);
				int writeId = rs.getInt(9);
				
				CCustomerWriteListDto dto = new CCustomerWriteListDto(customerName, writeContent, writeInitdate, w_customerId,
																	distinguish, recommentId, writeDeletedate, writeId);
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
	} // boardComment() --
	
	
}
