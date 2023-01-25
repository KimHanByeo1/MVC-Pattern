package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerLoginDao;

public class CCustomerLoginCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String customerId = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		
		HttpSession session = request.getSession();
		
		CCustomerLoginDao dao = new CCustomerLoginDao();
		boolean check = dao.userCheck(customerId, customerPw);
		String username = dao.userName(customerId, customerPw);
		
		session.setAttribute("ID", customerId);
		session.setAttribute("NAME", username);
		return check;
	}

}
