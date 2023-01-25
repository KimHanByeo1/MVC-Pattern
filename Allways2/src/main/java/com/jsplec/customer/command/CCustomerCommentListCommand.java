package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerCommentListDao;
import com.jsplec.customer.dto.CCustomerCommentListDto;

public class CCustomerCommentListCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		CCustomerCommentListDao dao = new CCustomerCommentListDao();
		ArrayList<CCustomerCommentListDto> dtos = dao.commentList();
		
		request.setAttribute("commentList", dtos);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
