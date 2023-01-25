package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerBoardDeleteDao;

public class CCustomerBoardCommentDeleteCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int writeId = Integer.parseInt(request.getParameter("WRITEID"));
		
		CCustomerBoardDeleteDao dao = new CCustomerBoardDeleteDao();
		dao.boardCommentDelete(writeId);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
