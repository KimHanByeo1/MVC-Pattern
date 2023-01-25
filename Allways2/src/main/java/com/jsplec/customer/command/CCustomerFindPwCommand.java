package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerPasswordResetDao;

public class CCustomerFindPwCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String customerId = request.getParameter("customerId");
		String customerName = request.getParameter("customerName");
		String customerBirthday = request.getParameter("customerBirth");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("email1") + "@" + request.getParameter("email2");
		
		CCustomerPasswordResetDao dao = new CCustomerPasswordResetDao();
		boolean chk = dao.userChk(customerId, customerName, customerBirthday, customerPhone, customerEmail);
		
		request.setAttribute("USERCHECK", chk);
		request.setAttribute("USERID", customerId);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}
}
