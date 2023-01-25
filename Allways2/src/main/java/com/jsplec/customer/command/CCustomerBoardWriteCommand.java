package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerBoardWriteDao;

public class CCustomerBoardWriteCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("ID");
		String writeTitle = request.getParameter("writeTitle");
		String writeContent = request.getParameter("writeContent");
		
		CCustomerBoardWriteDao dao = new CCustomerBoardWriteDao();
		int writeId = dao.selectWriteId();
		
		dao.boardWrite(writeId, customerId, writeTitle, writeContent);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
