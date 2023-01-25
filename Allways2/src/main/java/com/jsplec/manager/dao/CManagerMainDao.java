package com.jsplec.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.manager.dto.salesDto;

public class CManagerMainDao {

	DataSource dataSource;

	public CManagerMainDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> makeXAxis() {
		ArrayList<String> dates = new ArrayList<String>();

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();

			String query = "select distinct month(ordersDate), day(ordersDate), date(ordersDate) from orders where ordersStatus='구매' and date(ordersDate)>=curdate()-5 order by date(ordersDate);";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				String orderMonth = rs.getString(1);
				String orderDay = rs.getString(2);

				dates.add(orderMonth + "/" + orderDay);
				if (dates.size()==10) {
					break;
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

		return dates;
	}

	public ArrayList<Integer> makeSalesPrice() {
		ArrayList<Integer> price = new ArrayList<Integer>();

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();

			String query = "select sum(ordersSalePrice) from orders where ordersStatus='구매' and date(ordersDate)>=curdate()-5 group by date(ordersDate) order by date(ordersDate);";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				int ordersPrice = rs.getInt(1);

				price.add(ordersPrice);
				
				if (price.size()==10) {
					break;
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

		return price;
	}

	public ArrayList<Integer> makeSalesQuantity() {
		ArrayList<Integer> quantity = new ArrayList<Integer>();

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();

			String query = "select count(*) from orders where ordersStatus='구매' and date(ordersDate)>=curdate()-5 group by date(ordersDate) order by date(ordersDate);";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				int ordersQuantity = rs.getInt(1);

				quantity.add(ordersQuantity);
				
				if (quantity.size()==10) {
					break;
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
		

		return quantity;
	}
}
