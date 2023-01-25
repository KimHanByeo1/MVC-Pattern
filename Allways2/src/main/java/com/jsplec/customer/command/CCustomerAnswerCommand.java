package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerAnswerDao;
import com.jsplec.customer.dto.CCustomerAnswerDto;

public class CCustomerAnswerCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int questionId = Integer.parseInt(request.getParameter("questionId"));
		CCustomerAnswerDao dao = new CCustomerAnswerDao();
		CCustomerAnswerDto dto = dao.answerList(questionId);
		
		request.setAttribute("answerList", dto);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
