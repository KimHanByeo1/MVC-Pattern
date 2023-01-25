package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CCustomerCartSelectDeleteDao {

	DataSource dataSource;

	public CCustomerCartSelectDeleteDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cartSelectOptionDelete(String[] ORDERSID) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			for (int i = 0; i < ORDERSID.length; i++) {

				String query = "delete from detailoption where d_ordersId = ?";

				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, ORDERSID[i]);

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

	public void cartSelectDelete(String[] ORDERSID) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();

			for (int i = 0; i < ORDERSID.length; i++) {

				String query = "delete from orders where ordersId = ?";

				preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, ORDERSID[i]);

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

}
