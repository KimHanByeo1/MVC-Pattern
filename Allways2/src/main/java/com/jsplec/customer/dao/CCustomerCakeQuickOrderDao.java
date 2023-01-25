package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerCakeOrderDto;

public class CCustomerCakeQuickOrderDao {

	DataSource dataSource;

	public CCustomerCakeQuickOrderDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void quickOrder(String CUSTOMERID, int CAKEID, int CAKEPRICE, int ORDERSQUANTITY) {

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

	public ArrayList<CCustomerCakeOrderDto> orderList(String CUSTOMERID, int ORDERSID) {
		ArrayList<CCustomerCakeOrderDto> dtos = new ArrayList<CCustomerCakeOrderDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "select o.ordersId, o.o_cakeId, o.ordersQuantity, o.ordersSalePrice, c.cakeName from cake c, orders o ";
			String query2 = "where o.o_cakeId = c.cakeId and ordersStatus = '장바구니' and o.o_customerId = '" + CUSTOMERID
					+ "' and ordersId = '" + ORDERSID + "'";

			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int ordersId = resultSet.getInt(1);
				int cakeId = resultSet.getInt(2);
				int ordersQuantity = resultSet.getInt(3);
				int ordersSalePrice = resultSet.getInt(4);
				String cakeName = resultSet.getString(5);

				CCustomerCakeOrderDto dto = new CCustomerCakeOrderDto(ordersId, cakeId, ordersSalePrice, ordersQuantity,
						cakeName);
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

}