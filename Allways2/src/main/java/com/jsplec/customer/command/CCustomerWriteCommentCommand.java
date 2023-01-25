package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.customerWriteCommandDao;

public class CCustomerWriteCommentCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String CUSTOMERID = (String)session.getAttribute("ID");
		String writeContent = request.getParameter("writeContent");
		int writeId = Integer.parseInt(request.getParameter("writeId"));
		
		customerWriteCommandDao dao = new customerWriteCommandDao();
		dao.writeComment(CUSTOMERID, writeId, writeContent);
	
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
