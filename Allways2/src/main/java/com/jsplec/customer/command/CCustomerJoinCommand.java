package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerJoinDao;

public class CCustomerJoinCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String customerId = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		String customerName = request.getParameter("customerName");
		String customerGender = request.getParameter("customerGender");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("email1") + "@" + request.getParameter("email2");
		String customerBirthday= request.getParameter("customerBirth");
		String customerPostcode = request.getParameter("postcode");
		String customerAddress = request.getParameter("address");
		String customerAddressDetail = request.getParameter("addressDetail");
		
		CCustomerJoinDao dao = new CCustomerJoinDao();
		boolean check = dao.idCheck(customerId);
		dao.insertAction(customerId, customerPw, customerName, customerGender, customerPhone, customerEmail, customerBirthday, customerPostcode, customerAddress, customerAddressDetail);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
