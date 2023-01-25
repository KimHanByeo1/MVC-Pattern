package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerPasswordResetDao;

public class CCustomerPasswordResetCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String customerId = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		
		CCustomerPasswordResetDao dao = new CCustomerPasswordResetDao();
		dao.resetPw(customerId, customerPw);
		
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}
}
