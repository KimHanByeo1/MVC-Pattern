package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerCakeListDto;

public class CCustomerCakeDetailDao {
	
	// Field
	
	DataSource dataSource;
	
	// Constructor
	
	public CCustomerCakeDetailDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Method
	
	// product detail
	public CCustomerCakeListDto cakeDetail(int CAKEID) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		CCustomerCakeListDto dto = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "select cakeId, cakeName, cakePrice, cakeImage, cakeLike, cakeViews, cakeDetail from cake ";
			String query2 = "where cakeId = " + CAKEID;

			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {

				int cakeId = resultSet.getInt(1);
				String cakeName = resultSet.getString(2);
				int cakePrice = resultSet.getInt(3);
				String cakeImage= resultSet.getString(4);
				int cakeLike = resultSet.getInt(5);
				int cakeViews = resultSet.getInt(6);
				String cakeDetail = resultSet.getString(7);

				dto = new CCustomerCakeListDto(cakeId, cakeName, cakePrice, cakeImage, cakeLike, cakeViews, cakeDetail);
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
		return dto;

	}
	
	public void viewsUpdate(int CAKEID) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();


				String query = "update cake set cakeViews = cakeViews +1 where cakeId = " + CAKEID;

				preparedStatement = connection.prepareStatement(query);

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
