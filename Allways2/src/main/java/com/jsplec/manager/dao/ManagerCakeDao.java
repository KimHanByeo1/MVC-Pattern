package com.jsplec.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.manager.dto.cakeDetailDto;
import com.jsplec.manager.dto.cakeListDto;

public class ManagerCakeDao {

	DataSource dataSource;

	public ManagerCakeDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCake(String cakeName, int cakePrice, String cakeImage, String cakeDetail) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();

			String query = "insert into cake (cakeName, cakePrice, cakeImage, cakeDetail, cakeInitdate) values (?, ?, ?, ?, now());";
			ps = connection.prepareStatement(query);

			ps.setString(1, cakeName);
			ps.setInt(2, cakePrice);
			ps.setString(3, cakeImage);
			ps.setString(4, cakeDetail);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	

	public ArrayList<cakeListDto> viewCakeList() {

		ArrayList<cakeListDto> dtos = new ArrayList<cakeListDto>();

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String query = "select cakeId, cakeName, cakePrice, cakeViews, cakeLike from cake ";
			String query2 = "where cakeDeletedate is null";

			ps = connection.prepareStatement(query + query2);
			rs = ps.executeQuery();

			while (rs.next()) {
				int wkcakeId = rs.getInt(1);
				String wkcakeName = rs.getString(2);
				int wkcakePrice = rs.getInt(3);
				int wkcakeViews=rs.getInt(4);
				int wkcakeLike=rs.getInt(5);

				cakeListDto dto = new cakeListDto(wkcakeId, wkcakeName, wkcakePrice, wkcakeViews, wkcakeLike);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dtos;
	}

	public ArrayList<cakeListDto> searchCake(String cakeName) {
		ArrayList<cakeListDto> dtos = new ArrayList<cakeListDto>();

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String query = "select cakeId, cakeName, cakePrice, cakeViews, cakeLike from cake where cakeName like '%" + cakeName + "%' ";
			String query2 = "and cakeDeletedate is null";

			ps = connection.prepareStatement(query + query2);
			rs = ps.executeQuery();

			while (rs.next()) {
				int wkcakeId = rs.getInt(1);
				String wkcakeName = rs.getString(2);
				int wkcakePrice = rs.getInt(3);
				int wkcakeViews=rs.getInt(4);
				int wkcakeLike=rs.getInt(5);

				cakeListDto dto = new cakeListDto(wkcakeId, wkcakeName, wkcakePrice, wkcakeViews, wkcakeLike);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dtos;
	}

	public boolean checkName(String cakeName) {

		boolean check = false;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from cake where cakeName='" + cakeName + "' and cakeDeleteDate is null;";

			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				int count = rs.getInt(1);

				if (count == 0) {
					check = true;
				} else {
					check = false;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return check;
	}

	public cakeDetailDto viewCakeDetail(String cakeName) {
		cakeDetailDto dto = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String query = "select cakeName, cakePrice, cakeDetail, cakeImage from cake where cakeName='" + cakeName + "' ";
			String query2 = "and cakeDeletedate is null";

			ps = connection.prepareStatement(query + query2);
			rs = ps.executeQuery();

			while (rs.next()) {
				String wkcakeName = rs.getString(1);
				int wkcakePrice = rs.getInt(2);
				String wkcakeDetail = rs.getString(3);
				String wkcakeImage = rs.getString(4);

				dto = new cakeDetailDto(wkcakeName, wkcakePrice, wkcakeDetail, wkcakeImage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public void updateCake(int cakeId, String cakeName, int cakePrice, String cakeDetail, String cakeImage) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();

			String query = "update cake set cakeName=?, cakePrice=?, cakeDetail=?, cakeImage=?, cakeUpdatedate=now() where cakeId=?;";
			ps = connection.prepareStatement(query);

			ps.setString(1, cakeName);
			ps.setInt(2, cakePrice);
			ps.setString(3, cakeImage);
			ps.setString(4, cakeDetail);
			ps.setInt(5, cakeId);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void updateCake(int cakeId, String cakeName, int cakePrice, String cakeDetail) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();

			String query = "update cake set cakeName=?, cakePrice=?, cakeDetail=?, cakeUpdatedate=now() where cakeId=?;";
			ps = connection.prepareStatement(query);

			ps.setString(1, cakeName);
			ps.setInt(2, cakePrice);
			ps.setString(3, cakeDetail);
			ps.setInt(4, cakeId);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public int findID(String cakeName) {
		int cakeId = 0;

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String query = "select cakeId from cake where cakeName='" + cakeName + "';";

			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				cakeId = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return cakeId;
	}

	public boolean checkName(String cakeOriginalName, String cakeNewName) {

		boolean check = false;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		if (cakeOriginalName.equals(cakeNewName)) {
			return true;
		} else {

			try {
				connection = dataSource.getConnection();
				String query = "select count(*) from cake where cakeName!='" + cakeOriginalName + "' and cakeName='"
						+ cakeNewName + "';";

				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();

				while (rs.next()) {
					int count = rs.getInt(1);

					if (count == 0) {
						check = true;
					} else {
						check = false;
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (ps != null)
						ps.close();
					if (connection != null)
						connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

		return check;
	}

	public void deleteCake(int cakeId) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();

			String query = "update cake set cakeDeletedate=now() where cakeId=?;";
			ps = connection.prepareStatement(query);

			ps.setInt(1, cakeId);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
