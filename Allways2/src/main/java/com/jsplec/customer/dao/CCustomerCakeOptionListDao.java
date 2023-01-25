package com.jsplec.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.customer.dto.CCustomerCakeOptionListDto;

public class CCustomerCakeOptionListDao {

	DataSource dataSource;

	public CCustomerCakeOptionListDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CCustomerCakeOptionListDto> shapeList() {
		ArrayList<CCustomerCakeOptionListDto> dtos = new ArrayList<CCustomerCakeOptionListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			String query1 = "select cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice from cakeoption ";
			String query2 = "where cakeoptionCategory = 'shape' and cakeoptionDeletedate is null";

			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				int cakeoptionId = resultSet.getInt("cakeoptionId");
				String cakeoptionCategory = resultSet.getString("cakeoptionCategory");
				String cakeoptionValue = resultSet.getString("cakeoptionValue");
				int cakeoptionPrice = resultSet.getInt("cakeoptionPrice");

				CCustomerCakeOptionListDto dto = new CCustomerCakeOptionListDto(cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice);
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
	
	public ArrayList<CCustomerCakeOptionListDto> sizeList() {
		ArrayList<CCustomerCakeOptionListDto> dtos = new ArrayList<CCustomerCakeOptionListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice from cakeoption ";
			String query2 = "where cakeoptionCategory = 'size' and cakeoptionDeletedate is null";
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				int cakeoptionId = resultSet.getInt("cakeoptionId");
				String cakeoptionCategory = resultSet.getString("cakeoptionCategory");
				String cakeoptionValue = resultSet.getString("cakeoptionValue");
				int cakeoptionPrice = resultSet.getInt("cakeoptionPrice");
				
				CCustomerCakeOptionListDto dto = new CCustomerCakeOptionListDto(cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice);
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
	
	public ArrayList<CCustomerCakeOptionListDto> flavorList() {
		ArrayList<CCustomerCakeOptionListDto> dtos = new ArrayList<CCustomerCakeOptionListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice from cakeoption ";
			String query2 = "where cakeoptionCategory = 'Flavor' and cakeoptionDeletedate is null";
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				int cakeoptionId = resultSet.getInt("cakeoptionId");
				String cakeoptionCategory = resultSet.getString("cakeoptionCategory");
				String cakeoptionValue = resultSet.getString("cakeoptionValue");
				int cakeoptionPrice = resultSet.getInt("cakeoptionPrice");
				
				CCustomerCakeOptionListDto dto = new CCustomerCakeOptionListDto(cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice);
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
	
	public ArrayList<CCustomerCakeOptionListDto> icingColorList() {
		ArrayList<CCustomerCakeOptionListDto> dtos = new ArrayList<CCustomerCakeOptionListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice from cakeoption ";
			String query2 = "where cakeoptionCategory = 'Icing Color' and cakeoptionDeletedate is null";
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				int cakeoptionId = resultSet.getInt("cakeoptionId");
				String cakeoptionCategory = resultSet.getString("cakeoptionCategory");
				String cakeoptionValue = resultSet.getString("cakeoptionValue");
				int cakeoptionPrice = resultSet.getInt("cakeoptionPrice");
				
				CCustomerCakeOptionListDto dto = new CCustomerCakeOptionListDto(cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice);
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
	
	public ArrayList<CCustomerCakeOptionListDto> borderColorList() {
		ArrayList<CCustomerCakeOptionListDto> dtos = new ArrayList<CCustomerCakeOptionListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice from cakeoption ";
			String query2 = "where cakeoptionCategory = 'Border Color' and cakeoptionDeletedate is null";
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				int cakeoptionId = resultSet.getInt("cakeoptionId");
				String cakeoptionCategory = resultSet.getString("cakeoptionCategory");
				String cakeoptionValue = resultSet.getString("cakeoptionValue");
				int cakeoptionPrice = resultSet.getInt("cakeoptionPrice");
				
				CCustomerCakeOptionListDto dto = new CCustomerCakeOptionListDto(cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice);
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
	
	public ArrayList<CCustomerCakeOptionListDto> messageColorList() {
		ArrayList<CCustomerCakeOptionListDto> dtos = new ArrayList<CCustomerCakeOptionListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query1 = "select cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice from cakeoption ";
			String query2 = "where cakeoptionCategory = 'Message Color' and cakeoptionDeletedate is null";
			
			preparedStatement = connection.prepareStatement(query1 + query2);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				int cakeoptionId = resultSet.getInt("cakeoptionId");
				String cakeoptionCategory = resultSet.getString("cakeoptionCategory");
				String cakeoptionValue = resultSet.getString("cakeoptionValue");
				int cakeoptionPrice = resultSet.getInt("cakeoptionPrice");
				
				CCustomerCakeOptionListDto dto = new CCustomerCakeOptionListDto(cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice);
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
