package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerCakeOptionListDto;

public class CCustomerCakeCartDao {

	DataSource dataSource;

	public CCustomerCakeCartDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cartInsert(String CUSTOMERID, int CAKEID, int CAKEPRICE, int ORDERSQUANTITY) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "insert into orders (ordersStatus, o_customerId, o_cakeId, o_goodsId, ordersSalePrice, ordersQuantity, ordersDate) ";
			String query2 = "values ('장바구니', ?, ?, 1, ?, ?, now())";
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			
			
			preparedStatement.setString(1, CUSTOMERID);
			preparedStatement.setInt(2, CAKEID);
			preparedStatement.setInt(3, CAKEPRICE * ORDERSQUANTITY);
			preparedStatement.setInt(4, ORDERSQUANTITY);
//			preparedStatement.setInt(5, (int)((CAKEPRICE * ORDERSQUANTITY) *  0.05));

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public ArrayList<CCustomerCakeOptionListDto> selectOrdersInfo(String customerId) {
		
		ArrayList<CCustomerCakeOptionListDto> dtos = new ArrayList<CCustomerCakeOptionListDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select ordersId, ordersStatus from orders "
					+ "where ordersStatus = '장바구니' and o_customerId = '" + customerId + "' "
					+ "order by ordersDate desc";
			
			preparedStatement = connection.prepareStatement(query1);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {

				int ordersId = rs.getInt(1);
				String ordersStatus = rs.getString(2);
				
				CCustomerCakeOptionListDto dto = new CCustomerCakeOptionListDto(ordersId, ordersStatus);
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
	
	
	
	public void detailOptionInsert(int ordersId, String ordersStatus, int[] cakeoptionId, String customerId, int cakeId, String detailoptionLettering, String detailoptionPickupDate) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			for(int i = 0; i < cakeoptionId.length; i++) {
				
				String query1 = "insert into detailoption (d_ordersId, d_ordersStatus, d_cakeoptionId, d_customerId, d_cakeId, d_goodsId, detailoptionLettering, detailoptionPickupDate) "
						+ "values (?, ?, ?, ?, ?, ?, ?, ?);";
				
				preparedStatement = connection.prepareStatement(query1);
				
				
				preparedStatement.setInt(1, ordersId);
				preparedStatement.setString(2, ordersStatus);
				preparedStatement.setInt(3, cakeoptionId[i]);
				preparedStatement.setString(4, customerId);
				preparedStatement.setInt(5, cakeId);
				preparedStatement.setInt(6, 1);
				preparedStatement.setString(7, detailoptionLettering);
				preparedStatement.setString(8, detailoptionPickupDate);
	
				preparedStatement.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<CCustomerCakeOptionListDto> selectOptionPrice(int ORDERSID) {
		
		ArrayList<CCustomerCakeOptionListDto> dtos2 = new ArrayList<CCustomerCakeOptionListDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select sum(co.cakeoptionPrice) from cake c, cakeoption co, orders o, detailoption d ";
			String query2 = "where cakeoptionId = d.d_cakeoptionId and c.cakeId = d.d_cakeId and d.d_ordersId = o.ordersId ";
			String query3 = "and o.ordersStatus = '장바구니' and o.ordersId = " + ORDERSID + " group by o.ordersId, c.cakePrice";
			
			preparedStatement = connection.prepareStatement(query1+query2+query3);
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {

				int cakeoptionPrice = rs.getInt(1);
				
				CCustomerCakeOptionListDto dto = new CCustomerCakeOptionListDto(cakeoptionPrice);
				dtos2.add(dto);
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
		return dtos2;
	}
	
	public void salePriceUpdate(int ORDERSID, int CAKEPRICE, int ORDERSQUANTITY, int OPTIONPRICE) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			String query = "update orders set ordersSalePrice = ? where ordersId = " + ORDERSID;
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, (CAKEPRICE + OPTIONPRICE) * ORDERSQUANTITY);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
