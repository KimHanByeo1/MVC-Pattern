package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerCakeCartDao;
import com.jsplec.customer.dao.CCustomerCakeQuickOrderDao;
import com.jsplec.customer.dao.CCustomerCartListDao;
import com.jsplec.customer.dto.CCustomerCakeOptionListDto;
import com.jsplec.customer.dto.CCustomerCakeOrderDto;
import com.jsplec.customer.dto.CCustomerCartListDto;

public class CCustomerCakeQuickOrderCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("ID");

		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
		int cakePrice = Integer.parseInt(request.getParameter("cakePrice"));
		int ordersQuantity = Integer.parseInt(request.getParameter("ordersQuantity"));

		int shape = Integer.parseInt(request.getParameter("shape"));
		int size = Integer.parseInt(request.getParameter("size"));
		int[] option = { shape, size };
		String detailoptionLettering = request.getParameter("detailoptionLettering");
		String detailoptionPickupDate = request.getParameter("detailoptionPickupDate");

		CCustomerCakeQuickOrderDao dao = new CCustomerCakeQuickOrderDao();
		dao.quickOrder(customerId, cakeId, cakePrice, ordersQuantity);

		CCustomerCakeCartDao dao2 = new CCustomerCakeCartDao();
		ArrayList<CCustomerCakeOptionListDto> dtos = dao2.selectOrdersInfo(customerId);

		dao2.detailOptionInsert(dtos.get(0).getOrdersId(), dtos.get(0).getOrdersStatus(), option, customerId, cakeId,
				detailoptionLettering, detailoptionPickupDate);

		ArrayList<CCustomerCakeOptionListDto> dtos2 = dao2.selectOptionPrice(dtos.get(0).getOrdersId());

		dao2.salePriceUpdate(dtos.get(0).getOrdersId(), cakePrice, ordersQuantity, dtos2.get(0).getCakeoptionPrice());
		
		ArrayList<CCustomerCakeOrderDto> dtos3 = dao.orderList(customerId, dtos.get(0).getOrdersId());
		request.setAttribute("orderList", dtos3);
		
		CCustomerCartListDao dao3 = new CCustomerCartListDao();
		ArrayList<CCustomerCartListDto> dtos4 = dao3.cartOptionList(customerId);
		request.setAttribute("optionList", dtos4);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
