package com.jsplec.manager.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.manager.dao.CManagerOrdersReviewDao;
import com.jsplec.manager.dto.ordersReviewDto;

public class CManagerViewReviewsListCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<ordersReviewDto> dtos = new ArrayList<ordersReviewDto>();
		CManagerOrdersReviewDao dao = new CManagerOrdersReviewDao();
		String query = request.getParameter("query");
		String condition = request.getParameter("condition");
		int index = 1;
		int rowcount = 7;
		int pagecount = 5;
		int pagepage = 0;

		if (request.getParameter("index") != null) {
			index = (int) Float.parseFloat(request.getParameter("index"));
		}

		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}

		if (query == null || condition == null||query.equals("")||condition.equals("")) {
			dtos = dao.showOrdersReviewList();
		} else {
			dtos = dao.searchOrdersReviewByCondition(condition, query);
		}

		request.setAttribute("Dtos", dtos);
		request.setAttribute("Size", dtos.size());
		request.setAttribute("index", index);
		request.setAttribute("rowcount", rowcount);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("pagepage", pagepage);
		request.setAttribute("condition", condition);
		request.setAttribute("Query", query);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
