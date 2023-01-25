package com.jsplec.manager.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.manager.dao.CManagerOrderListDao;
import com.jsplec.manager.dto.CManagerOptionListDto;

public class CManagerOptionView implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cakeoptionIdd = request.getParameter("cakeoptionId");
		CManagerOrderListDao dao = new CManagerOrderListDao();
		dao.optionView(cakeoptionIdd);
		CManagerOptionListDto dtos = dao.optionView(cakeoptionIdd);
		request.setAttribute("cake_option", dtos);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
