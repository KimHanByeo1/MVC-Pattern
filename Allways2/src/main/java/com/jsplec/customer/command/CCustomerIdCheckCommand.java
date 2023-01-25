package com.jsplec.customer.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerJoinDao;


public class CCustomerIdCheckCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String customerId = request.getParameter("customerId");
		String customerName = request.getParameter("customerName");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("email1");
		String customerBirth = request.getParameter("customerBirth");
		
		CCustomerJoinDao dao = new CCustomerJoinDao();
		
		if(customerId.length() > 0) {
			boolean chk = dao.idCheck(customerId);
			request.setAttribute("CHECK", chk);
			request.setAttribute("CHECKID", customerId);
			request.setAttribute("NAME", customerName);
			request.setAttribute("PHONE", customerPhone);
			request.setAttribute("EMAIL", customerEmail);
			request.setAttribute("BIRTH", customerBirth);
		}else {
			request.setAttribute("CHECK", null);
		}
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		return false;
		
	}

}
