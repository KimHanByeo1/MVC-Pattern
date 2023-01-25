package com.jsplec.manager.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.manager.dao.CManagerOrderListDao;
import com.jsplec.manager.dao.CManagerOrderStausDao;

public class CManagerOrderDeleteCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String ordersId=request.getParameter("ordersId");
		CManagerOrderStausDao dao=new CManagerOrderStausDao();
		dao.OrderDelete(ordersId);

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
