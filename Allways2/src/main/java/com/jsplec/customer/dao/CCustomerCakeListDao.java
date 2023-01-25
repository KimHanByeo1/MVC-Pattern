package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerCakeListDto;

public class CCustomerCakeListDao {
	
	// Field
	
	DataSource dataSource;
	
	// Constructor
	
	public CCustomerCakeListDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	
	// 케이크 리스트 출력
	public ArrayList<CCustomerCakeListDto> cakeList(String queryName, String content, String sort1, String sort2) {
		ArrayList<CCustomerCakeListDto> dtos = new ArrayList<CCustomerCakeListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "select cakeId, cakeName, cakePrice, cakeImage, cakeLike, cakeViews from cake ";
			String query2 = "where cakeDeletedate is null and " + queryName + " like '%" + content + "%' order by " + sort1 + " " + sort2;
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int cakeId = resultSet.getInt("cakeId");
				String cakeName = resultSet.getString("cakeName");
				int cakePrice = resultSet.getInt("cakePrice");
				String cakeImage= resultSet.getString("cakeImage");
				int cakeLike = resultSet.getInt("cakeLike");
				int cakeViews = resultSet.getInt("cakeViews");

				CCustomerCakeListDto dto = new CCustomerCakeListDto(cakeId, cakeName, cakePrice, cakeImage, cakeLike, cakeViews);
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
	
	public ArrayList<CCustomerCakeListDto> cakeSortList(String queryName, String content) {
		ArrayList<CCustomerCakeListDto> dtos2 = new ArrayList<CCustomerCakeListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "select cakeId, cakeName, cakePrice, cakeImage, cakeLike, cakeViews from cake ";
			String query2 = "where cakeDeletedate is null order by " + queryName + " " + content ;
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int cakeId = resultSet.getInt("cakeId");
				String cakeName = resultSet.getString("cakeName");
				int cakePrice = resultSet.getInt("cakePrice");
				String cakeImage= resultSet.getString("cakeImage");
				int cakeLike = resultSet.getInt("cakeLike");
				int cakeViews = resultSet.getInt("cakeViews");
				
				CCustomerCakeListDto dto = new CCustomerCakeListDto(cakeId, cakeName, cakePrice, cakeImage, cakeLike, cakeViews);
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
