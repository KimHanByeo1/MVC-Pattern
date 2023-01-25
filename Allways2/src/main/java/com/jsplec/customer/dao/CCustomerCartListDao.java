package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerCartListDto;

public class CCustomerCartListDao {

	// Field

	DataSource dataSource;

	// Constructor

	public CCustomerCartListDao() {
		// TODO Auto-generated constructor stub

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method

	// cart list 출력
	public ArrayList<CCustomerCartListDto> cartList(String CUSTOMERID) {
		ArrayList<CCustomerCartListDto> dtos = new ArrayList<CCustomerCartListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "select o.ordersId, c.cakeName, o.ordersQuantity, o.ordersSalePrice from cake c, orders o ";
			String query2 = "where o.o_cakeId = c.cakeId and ordersStatus = '장바구니' and o.o_customerId = '" + CUSTOMERID
					+ "' and ordersPoint is null";

			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int ordersId = resultSet.getInt("ordersId");
				String cakeName = resultSet.getString("cakeName");
				int ordersSalePrice = resultSet.getInt("ordersSalePrice");
				int ordersQuantity = resultSet.getInt("ordersQuantity");

				CCustomerCartListDto dto = new CCustomerCartListDto(ordersId, cakeName, ordersSalePrice,
						ordersQuantity);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;

	}

	public ArrayList<CCustomerCartListDto> cartOptionList(String customerId) {
		ArrayList<CCustomerCartListDto> dtos2 = new ArrayList<CCustomerCartListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "select co.cakeoptionCategory, co.cakeoptionValue, co.cakeoptionPrice, d.detailoptionLettering from cakeoption co, detailoption d ";
			String query2 = "where d.d_cakeoptionId = co.cakeoptionId and d.d_ordersId in (select ordersId from orders where o_customerId = '" + customerId + "' and ordersPoint is null)";

			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String cakeoptionCategory = resultSet.getString("cakeoptionCategory");
				String cakeoptionValue = resultSet.getString("cakeoptionValue");
				int cakeoptionPrice = resultSet.getInt("cakeoptionPrice");
				String detailoptionLettering = resultSet.getString("detailoptionLettering");

				CCustomerCartListDto dto = new CCustomerCartListDto(cakeoptionCategory, cakeoptionValue,
						cakeoptionPrice, detailoptionLettering);
				dtos2.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos2;

	}

}
