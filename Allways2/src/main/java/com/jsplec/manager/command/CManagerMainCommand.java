package com.jsplec.manager.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.manager.dao.CManagerMainDao;
import com.jsplec.manager.dao.CManagerOrderStausDao;
import com.jsplec.manager.dao.CManagerOrdersReviewDao;
import com.jsplec.manager.dto.CManagerOrderStautsDTo;
import com.jsplec.manager.dto.ordersReviewDto;
import com.jsplec.manager.dto.salesDto;

public class CManagerMainCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		CManagerMainDao dao = new CManagerMainDao();
		CManagerOrderStausDao ordersdao = new CManagerOrderStausDao();
		ArrayList<ordersReviewDto> dtos2 = new ArrayList<ordersReviewDto>();
		CManagerOrdersReviewDao dao2 = new CManagerOrdersReviewDao();
		
		ArrayList<String> dates = dao.makeXAxis();
		
		ArrayList<Integer> price = dao.makeSalesPrice();
		
		ArrayList<Integer> quantity = dao.makeSalesQuantity();
		ArrayList<CManagerOrderStautsDTo> ordersdtos = ordersdao.orderStautsList();
		String strDates = "";
		String strPrice = "";
		String strQuantity = "";

		if (dates.size() != 0 && price.size() != 0 && quantity.size() != 0) {
			for (int i = 0; i < dates.size(); i++) {
				strDates += dates.get(i);
				strPrice += price.get(i);
				strQuantity += quantity.get(i);
				if (i != dates.size() - 1) {
					strDates += ",";
					strPrice += ",";
					strQuantity += ",";
				}
			}
		}
		
		dtos2 = dao2.showOrdersReviewOnMain();
		request.setAttribute("REVIEWDTO", dtos2);
		request.setAttribute("XAXIS", strDates);
		request.setAttribute("SALESPRICE", strPrice);
		request.setAttribute("SALESQUANTITY", strQuantity);
		request.setAttribute("ORDERS", ordersdtos);

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
