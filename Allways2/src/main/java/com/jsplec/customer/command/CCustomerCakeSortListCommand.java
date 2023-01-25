package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerCakeListDao;
import com.jsplec.customer.dto.CCustomerCakeListDto;

public class CCustomerCakeSortListCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String queryName = request.getParameter("query");
		String content = request.getParameter("content");

		if (queryName == null) {
			queryName = "";
			content = "";
		}

		CCustomerCakeListDao dao = new CCustomerCakeListDao();
		ArrayList<CCustomerCakeListDto> dtos2 = dao.cakeSortList(queryName, content);
		request.setAttribute("cakeSortList", dtos2);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}