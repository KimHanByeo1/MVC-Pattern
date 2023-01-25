package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerBestCakeListDao;
import com.jsplec.customer.dto.CCustomerBestCakeListDto;

public class CCustomerBestCakeListCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CCustomerBestCakeListDao dao = new CCustomerBestCakeListDao();
		ArrayList<CCustomerBestCakeListDto> dtos = dao.bestCakeList();
		request.setAttribute("bestCakeList", dtos);

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
