package com.jsplec.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.jsplec.manager.dto.CManagerOptionListDto;
import com.jsplec.manager.dto.CManagerOrderStautsDTo;
import com.mysql.cj.Session;

public class CManagerOrderListDao {


	DataSource dataSource;

public CManagerOrderListDao() {
	// TODO Auto-generated constructor stub
	try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
	}catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
}

	public boolean CheckOption(String optionName, String option, String optionPrice, String optionId, String cakeoptionImage){
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	int checked =0;
	
			
			String query = "select count(cakeoptionValue) from cakeoption where cakeoptionValue = '" + optionName + "' and cakeoptionCategory = '" + option + "' and cakeoptionDeletedate is null ";
			
			
			try {connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) { // true값일때만 가져온다
					checked = resultSet.getInt(1);
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(checked == 1) {
				return true;
			}else{
				return false;
			}
		}

	public ArrayList<CManagerOptionListDto> OptionList(){
		ArrayList<CManagerOptionListDto> dtos = new ArrayList<CManagerOptionListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try { 
			connection = dataSource.getConnection();
			
			String query = "select cakeoptionId, cakeoptionCategory,cakeoptionValue,cakeoptionPrice from cakeoption where cakeoptionDeletedate is null order by cakeoptionCategory DESC";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int cakeoptionId = resultSet.getInt("cakeoptionId");
				String cakeoptionCategory = resultSet.getString("cakeoptionCategory");
				String cakeoptionValue = resultSet.getString("cakeoptionValue");
				int cakeoptionPrice = resultSet.getInt("cakeoptionPrice");
				
				CManagerOptionListDto dto = new CManagerOptionListDto(cakeoptionId,cakeoptionCategory,cakeoptionValue,cakeoptionPrice);
				dtos.add(dto);
				}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
		
}//option list
	public void Addoption(String cakeoptionCategory, String cakeoptionValue, String cakeoptionprice, String cakeoptionImage) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into cakeoption (cakeoptionCategory, cakeoptionValue,cakeoptionprice,cakeoptionImage,cakeoptionInitdate) values (?, ?, ?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cakeoptionCategory);
			preparedStatement.setString(2, cakeoptionValue);
			preparedStatement.setInt(3, Integer.parseInt(cakeoptionprice));
			preparedStatement.setString(4, cakeoptionImage);

			preparedStatement.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // add() --
	

	public ArrayList<CManagerOptionListDto> selectList(String option,String Query ){
		ArrayList<CManagerOptionListDto> dtos = new ArrayList<CManagerOptionListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try { 
			connection = dataSource.getConnection();
			
			
			String query = "select cakeoptionId, cakeoptionCategory,cakeoptionValue,cakeoptionPrice from cakeoption where " + option + "  Like '%" + Query+ "%' and cakeoptionDeletedate is null order by cakeoptionCategory DESC";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int cakeoptionId = resultSet.getInt("cakeoptionId");
				String cakeoptionCategory = resultSet.getString("cakeoptionCategory");
				String cakeoptionValue = resultSet.getString("cakeoptionValue");
				int cakeoptionPrice = resultSet.getInt("cakeoptionPrice");
				
				CManagerOptionListDto dto = new CManagerOptionListDto(cakeoptionId,cakeoptionCategory,cakeoptionValue,cakeoptionPrice);
				dtos.add(dto);
				}
		} catch (Exception e) {
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	
	public CManagerOptionListDto optionView(String cakeoptionIdd) {
		CManagerOptionListDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from cakeoption where cakeoptionId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(cakeoptionIdd));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int cakeoptionId = resultSet.getInt("cakeoptionId");
				String cakeoptionCategory = resultSet.getString("cakeoptionCategory");
				String cakeoptionValue = resultSet.getString("cakeoptionValue");
				int cakeoptionPrice = resultSet.getInt("cakeoptionPrice");
				String cakeoptionImage = resultSet.getString("cakeoptionImage");
			
			
				
				dto = new CManagerOptionListDto(cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice, cakeoptionImage);
						
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
		
		
	}// content_view
	public void contentUpdate(String cakeoptionCategory,String cakeoptionValue, int cakeoptionPrice, String cakeoptionImage, int cakeoptionId) {
		//write
				Connection connection = null;
				PreparedStatement preparedStatement = null;
			
				
				try {
					connection = dataSource.getConnection();
					
					String query = "update cakeoption set cakeoptionCategory = ?, cakeoptionValue = ? , cakeoptionPrice= ?,cakeoptionImage =? , cakeoptionUpdatedate = now() where cakeoptionId = ?";
					preparedStatement = connection.prepareStatement(query);
					
					preparedStatement.setString(1, cakeoptionCategory);
					preparedStatement.setString(2, cakeoptionValue);
					preparedStatement.setInt(3, cakeoptionPrice);
					preparedStatement.setString(4, cakeoptionImage);
					preparedStatement.setInt(5, cakeoptionId);
					
					preparedStatement.executeUpdate();
				
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			
				
			}//update
	public void contentDelete(String cakeoptionId) {
		//write
				Connection connection = null;
				PreparedStatement preparedStatement = null;
			
				
				try {
					connection = dataSource.getConnection();
					
					String query = "update cakeoption set cakeoptionDeletedate = now() where cakeoptionId = ?";
					preparedStatement = connection.prepareStatement(query);
					
				
					preparedStatement.setInt(1, Integer.parseInt(cakeoptionId));
					
					preparedStatement.executeUpdate();
				
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			
				
			}//delete update
	
	public CManagerOrderStautsDTo addStatus(String ordersIdd) {
		CManagerOrderStautsDTo dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select ordersId,ordersStatus,o_customerId,o_cakeId,cakeName,o_goodsId,goodsName,ordersSalePrice,ordersQuantity,ordersPoint from orders as o, goods as g, cake as c where o.o_cakeId = c.cakeId and g.goodsId = o.o_goodsId and ordersId=?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(ordersIdd));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int ordersId = resultSet.getInt("ordersId");
				String ordersStatus = resultSet.getString("ordersStatus");
				String o_customerId = resultSet.getString("o_customerId");
				int o_cakeId = resultSet.getInt("o_cakeId");
				String cakeName = resultSet.getString("cakeName");
				int o_goodsId = resultSet.getInt("o_goodsId");
				String goodsName = resultSet.getString("goodsName");
				int ordersSalePrice = resultSet.getInt("ordersSalePrice");
				int ordersQuantity = resultSet.getInt("ordersQuantity");
				int ordersPoint = resultSet.getInt("ordersPoint");
			
				
				dto = new CManagerOrderStautsDTo(ordersId, ordersStatus, o_customerId, o_cakeId,cakeName, o_goodsId,goodsName, ordersSalePrice, ordersQuantity,ordersPoint);
						
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
		
	}
	public void Addstatus(String ordersId, String ordersStatus,String o_customerId,String o_cakeId,String o_goodsId, String ordersSalePrice ,String ordersQuantity,String ordersPoint) {
		
		Connection connection = null;
		Connection connection2 = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		try {
			connection = dataSource.getConnection();
			connection2 = dataSource.getConnection();
			
			String query = "insert into orders (ordersId, ordersStatus,o_customerId,o_cakeId,o_goodsId,ordersSalePrice,ordersQuantity,ordersPoint) values (?,?,?,?,?,?,?,?) ";
			String query2 = "update orders set ordersMakedate = now() where ordersId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement2 = connection2.prepareStatement(query2);

			preparedStatement.setInt(1, Integer.parseInt(ordersId));
			preparedStatement.setString(2, ordersStatus);
			preparedStatement.setString(3, o_customerId);
			preparedStatement.setInt(4, Integer.parseInt(o_cakeId));
			preparedStatement.setInt(5, Integer.parseInt(o_goodsId));
			preparedStatement.setInt(6, Integer.parseInt(ordersSalePrice));
			preparedStatement.setInt(7, Integer.parseInt(ordersQuantity));
			preparedStatement.setInt(8, Integer.parseInt(ordersPoint));
			preparedStatement2.setInt(1, Integer.parseInt(ordersId));
			
			preparedStatement.executeUpdate();
			preparedStatement2.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(preparedStatement2 != null) preparedStatement2.close();
				if(connection != null) connection.close();
				if(connection2 != null) connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // orderstatusAdd;
	
	public void Addstatus2(String ordersId, String ordersStatus,String o_customerId,String o_cakeId,String o_goodsId, String ordersSalePrice ,String ordersQuantity, String ordersPoint) {
			Connection connection = null;
			Connection connection2 = null;
			PreparedStatement preparedStatement = null;
			PreparedStatement preparedStatement2 = null;
			try {
				connection = dataSource.getConnection();
				connection2 = dataSource.getConnection();
				
				String query = "insert into orders (ordersId, ordersStatus,o_customerId,o_cakeId,o_goodsId,ordersSalePrice,ordersQuantity,ordersPoint) values (?,?,?,?,?,?,?,?) ";
				String query2 = "update orders set orderSoldOutdate = now() where ordersId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement2 = connection2.prepareStatement(query2);
	
				preparedStatement.setInt(1, Integer.parseInt(ordersId));
				preparedStatement.setString(2, ordersStatus);
				preparedStatement.setString(3, o_customerId);
				preparedStatement.setInt(4, Integer.parseInt(o_cakeId));
				preparedStatement.setInt(5, Integer.parseInt(o_goodsId));
				preparedStatement.setInt(6, Integer.parseInt(ordersSalePrice));
				preparedStatement.setInt(7, Integer.parseInt(ordersQuantity));
				preparedStatement.setInt(8, Integer.parseInt(ordersPoint));
				preparedStatement2.setInt(1, Integer.parseInt(ordersId));
				
				preparedStatement.executeUpdate();
				preparedStatement2.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(preparedStatement2 != null) preparedStatement2.close();
					if(connection != null) connection.close();
					if(connection2 != null) connection.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} // orderstatusAdd;
	
	
}
