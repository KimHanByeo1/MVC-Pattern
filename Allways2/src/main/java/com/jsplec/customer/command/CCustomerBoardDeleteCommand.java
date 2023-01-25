package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerBoardDeleteDao;

public class CCustomerBoardDeleteCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int commentId = Integer.parseInt(request.getParameter("commentId"));
		System.out.println(commentId);
		CCustomerBoardDeleteDao dao = new CCustomerBoardDeleteDao();
		dao.boardDelete(commentId);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
