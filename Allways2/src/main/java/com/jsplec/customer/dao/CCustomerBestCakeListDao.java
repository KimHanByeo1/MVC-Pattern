package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerBestCakeListDto;

public class CCustomerBestCakeListDao {

	DataSource dataSource;

	public CCustomerBestCakeListDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<CCustomerBestCakeListDto> bestCakeList() {
		ArrayList<CCustomerBestCakeListDto> dtos = new ArrayList<CCustomerBestCakeListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "select cakeId, cakeName, cakePrice, cakeImage from cake ";
			String query2 = "order by cakeLike desc limit 8";

			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int cakeId = resultSet.getInt("cakeId");
				String cakeName = resultSet.getString("cakeName");
				int cakePrice = resultSet.getInt("cakePrice");
				String cakeImage= resultSet.getString("cakeImage");

				CCustomerBestCakeListDto dto = new CCustomerBestCakeListDto(cakeId, cakeName, cakePrice, cakeImage);
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