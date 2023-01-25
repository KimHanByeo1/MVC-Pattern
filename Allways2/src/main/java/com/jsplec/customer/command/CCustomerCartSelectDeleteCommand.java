package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerCartSelectDeleteDao;

public class CCustomerCartSelectDeleteCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String[] ordersId = request.getParameterValues("ordersId");
		
		CCustomerCartSelectDeleteDao dao = new CCustomerCartSelectDeleteDao();
		
		dao.cartSelectOptionDelete(ordersId);
		
		dao.cartSelectDelete(ordersId);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
