package com.jsplec.customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerCakeOrderDao;
import com.jsplec.customer.dao.CCustomerCartDeleteDao;

public class CCustomerPayCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String customerId = (String) session.getAttribute("ID");
		
		String[] ordersId = request.getParameterValues("ordersId");
		String[] cakeId = request.getParameterValues("cakeId");
		String[] ordersSalePrice = request.getParameterValues("ordersSalePrice");
		String[] ordersQuantity = request.getParameterValues("ordersQuantity");
		
		
		CCustomerCakeOrderDao dao = new CCustomerCakeOrderDao();
		dao.orderInsert(ordersId, customerId, cakeId, ordersSalePrice, ordersQuantity);
		
		dao.cartListUpdate(ordersId);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
