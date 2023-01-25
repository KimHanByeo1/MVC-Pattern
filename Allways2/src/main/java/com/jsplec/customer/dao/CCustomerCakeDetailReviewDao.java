package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerCakeDetailReviewDto;

public class CCustomerCakeDetailReviewDao {

	DataSource dataSource;

	public CCustomerCakeDetailReviewDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CCustomerCakeDetailReviewDto> detailReview(int CAKEID) {
		
		ArrayList<CCustomerCakeDetailReviewDto> dtos = new ArrayList<CCustomerCakeDetailReviewDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select * from (select row_number() over(order by oreviewId) as rownum, "
					+ "or_customerId, oreviewContent, oreviewInitdate, oreviewImage, oreviewStarrating, or_cakeId from ordersreview  order by oreviewId desc) o "
					+ "where o.or_cakeId = " + CAKEID + " order by o.oreviewInitdate desc";
			
			preparedStatement = connection.prepareStatement(query1);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {

				int ROWNUM = rs.getInt(1);
				String or_customerId = rs.getString(2);
				String oreviewContent = rs.getString(3);
				Date oreviewInitdate = rs.getDate(4);
				String oreviewImage = rs.getString(5);
				int oreviewStarrating = rs.getInt(6);
				int or_cakeId = rs.getInt(7);
				
				CCustomerCakeDetailReviewDto dto = new CCustomerCakeDetailReviewDto(ROWNUM, or_customerId, oreviewContent, oreviewInitdate, oreviewImage, oreviewStarrating, or_cakeId);
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
