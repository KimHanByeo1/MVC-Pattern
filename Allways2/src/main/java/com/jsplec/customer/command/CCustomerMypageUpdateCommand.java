package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerJoinDao;
import com.jsplec.customer.dao.CCustomerLoginDao;
import com.jsplec.customer.dto.CCustomerUserinfoDto;

public class CCustomerMypageUpdateCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		String customerId = (String) session.getAttribute("ID");
		CCustomerLoginDao dao = new CCustomerLoginDao();
		CCustomerUserinfoDto dto = dao.showInfo(customerId);
		CCustomerUserinfoDto email = dao.emailSubstring(customerId);
		request.setAttribute("USERINFO", dto);
		request.setAttribute("USEREMAIL", email);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
