package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerCakeListDao;
import com.jsplec.customer.dao.CCustomerCakeOptionListDao;
import com.jsplec.customer.dto.CCustomerCakeListDto;
import com.jsplec.customer.dto.CCustomerCakeOptionListDto;

public class CCustomerCakeOptionListCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CCustomerCakeOptionListDao dao = new CCustomerCakeOptionListDao();
		ArrayList<CCustomerCakeOptionListDto> dtos = dao.shapeList();
		request.setAttribute("shapeList", dtos);
		
		CCustomerCakeOptionListDao dao2 = new CCustomerCakeOptionListDao();
		ArrayList<CCustomerCakeOptionListDto> dtos2 = dao2.sizeList();
		request.setAttribute("sizeList", dtos2);

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
