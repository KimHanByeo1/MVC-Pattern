package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerReviewListDto;

public class CCustomerReviewListDao {

	DataSource dataSource;
	
	public CCustomerReviewListDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CCustomerReviewListDto> reviewList1(String sort, String searchContent, String combo) {
		
		ArrayList<CCustomerReviewListDto> dtos = new ArrayList<CCustomerReviewListDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select @rownum:=@rownum+1, o.or_customerId, o.oreviewContent, o.oreviewInitdate from ordersreview o ";
			String query2 = "where (@rownum:=0)=0 and " + combo + " like '%" + searchContent + "%' order by " + sort + " desc";
			
//			String query1 = "select * from (select row_number() over(order by oreviewId) "
//					+ "as rownum, or_customerId, oreviewContent, oreviewInitdate from ordersreview  order by oreviewId desc) o"
//					+ "where rownum between ? and ?";
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				int ROWNUM = rs.getInt(1);
				String or_customerId = rs.getString(2);
				String oreviewContent = rs.getString(3);
				Date oreviewInitdate = rs.getDate(4);
				
				CCustomerReviewListDto dto = new CCustomerReviewListDto(ROWNUM, or_customerId, oreviewContent, oreviewInitdate);
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
	
	public ArrayList<CCustomerReviewListDto> reviewList2(String sort, String searchContent, String combo, int index, int maxPage) {
		
		ArrayList<CCustomerReviewListDto> dtos = new ArrayList<CCustomerReviewListDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select * from (select row_number() over(order by oreviewId) as rownum, "
					+ "or_customerId, oreviewContent, oreviewInitdate, oreviewImage, oreviewStarrating, oreviewId from ordersreview where oreviewDeletedate is null order by oreviewId desc) o "
					+ "where " + combo + " like '%" + searchContent + "%' order by " + sort + " desc";

			preparedStatement = connection.prepareStatement(query1);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {

				int ROWNUM = rs.getInt(1);
				String or_customerId = rs.getString(2);
				String oreviewContent = rs.getString(3);
				Date oreviewInitdate = rs.getDate(4);
				String oreviewImage = rs.getString(5);
				int oreviewStarrating = rs.getInt(6);
				int oreviewId = rs.getInt(7);
				
				CCustomerReviewListDto dto = new CCustomerReviewListDto(ROWNUM, or_customerId, oreviewContent, oreviewInitdate, 
																		oreviewImage, oreviewStarrating, oreviewId);
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
	} // reviewList2() --
	
	
}
