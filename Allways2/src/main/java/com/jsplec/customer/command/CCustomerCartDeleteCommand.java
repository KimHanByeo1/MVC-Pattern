package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerCartDeleteDao;

public class CCustomerCartDeleteCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int ordersId = Integer.parseInt(request.getParameter("ordersId"));
		
		CCustomerCartDeleteDao dao = new CCustomerCartDeleteDao();
		
		dao.cartOptionDelete(ordersId);
		
		dao.cartDelete(ordersId);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
