package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerLoginDao;

public class CCustomerFindIdCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String customerName = request.getParameter("customerName");
		String customerBirthday = request.getParameter("customerBirth");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("email1") + "@" + request.getParameter("email2");

		CCustomerLoginDao dao = new CCustomerLoginDao();
		String customerId = dao.userFindId(customerName, customerBirthday, customerPhone, customerEmail);
		
		request.setAttribute("CUSTOMERNAME", customerName);
		request.setAttribute("CUSTOMERID", customerId);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
