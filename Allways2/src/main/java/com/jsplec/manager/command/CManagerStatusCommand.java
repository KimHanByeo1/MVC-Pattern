package com.jsplec.manager.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.manager.dao.CManagerOrderListDao;
import com.jsplec.manager.dto.CManagerOptionListDto;
import com.jsplec.manager.dto.CManagerOrderStautsDTo;

public class CManagerStatusCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String ordersIdd = request.getParameter("ordersId");
		CManagerOrderListDao dao = new CManagerOrderListDao();
		dao.addStatus(ordersIdd);
		CManagerOrderStautsDTo dtos = dao.addStatus(ordersIdd);
		request.setAttribute("add_Order", dtos);

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
