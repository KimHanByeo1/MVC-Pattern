package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerReviewDeleteDao;

public class CCusotmerReviewDeleteCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int oreviewId = Integer.parseInt(request.getParameter("oreviewId"));
		
		CCustomerReviewDeleteDao dao = new CCustomerReviewDeleteDao();
		dao.reviewDelete(oreviewId);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
