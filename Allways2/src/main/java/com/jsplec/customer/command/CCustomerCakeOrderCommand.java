package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerCakeOrderDao;
import com.jsplec.customer.dao.CCustomerCartListDao;
import com.jsplec.customer.dto.CCustomerCakeOrderDto;
import com.jsplec.customer.dto.CCustomerCartListDto;

public class CCustomerCakeOrderCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String customerId = (String) session.getAttribute("ID");
		String[] ordersId = request.getParameterValues("ordersId");

		CCustomerCakeOrderDao dao = new CCustomerCakeOrderDao();

		ArrayList<CCustomerCakeOrderDto> dtos = dao.orderList(customerId, ordersId);
		request.setAttribute("orderList", dtos);

		CCustomerCartListDao dao2 = new CCustomerCartListDao();
		ArrayList<CCustomerCartListDto> dtos2 = dao2.cartOptionList(customerId);
		request.setAttribute("optionList", dtos2);

		ArrayList<CCustomerCakeOrderDto> dtos3 = dao.customerInfo(customerId);

		request.setAttribute("customerInfo", dtos3);
		

//		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
//		int cakePrice = Integer.parseInt(request.getParameter("cakePrice"));
//		int ordersQuantity = Integer.parseInt(request.getParameter("ordersQuantity"));
//		
//		dao.orderInsert(customerId, cakeId, cakePrice, ordersQuantity, ordersId);

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
