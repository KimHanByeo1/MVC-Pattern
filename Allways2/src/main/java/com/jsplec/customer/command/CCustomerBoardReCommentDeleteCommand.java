package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerBoardDeleteDao;

public class CCustomerBoardReCommentDeleteCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int recommentId = Integer.parseInt(request.getParameter("recommentId"));
		System.out.println(recommentId);
		CCustomerBoardDeleteDao dao = new CCustomerBoardDeleteDao();
		dao.boardReCommentDelete(recommentId);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
