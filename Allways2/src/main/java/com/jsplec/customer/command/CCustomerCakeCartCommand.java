package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerCakeCartDao;
import com.jsplec.customer.dto.CCustomerCakeOptionListDto;

public class CCustomerCakeCartCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CCustomerCakeCartDao dao = new CCustomerCakeCartDao();
		
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("ID");
		
		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
		int cakePrice = Integer.parseInt(request.getParameter("cakePrice"));
		int ordersQuantity = Integer.parseInt(request.getParameter("ordersQuantity"));
		
		int shape = Integer.parseInt(request.getParameter("shape"));
		int size = Integer.parseInt(request.getParameter("size"));
		int flavor = Integer.parseInt(request.getParameter("flavor"));
		int[] option = {shape, size, flavor};
		String detailoptionLettering = request.getParameter("detailoptionLettering");
		String detailoptionPickupDate = request.getParameter("detailoptionPickupDate");
		
		dao.cartInsert(customerId, cakeId, cakePrice, ordersQuantity);
		
		ArrayList<CCustomerCakeOptionListDto> dtos = dao.selectOrdersInfo(customerId);
		
		dao.detailOptionInsert(dtos.get(0).getOrdersId(), dtos.get(0).getOrdersStatus(), option, customerId, cakeId, detailoptionLettering, detailoptionPickupDate);
		
		ArrayList<CCustomerCakeOptionListDto> dtos2 = dao.selectOptionPrice(dtos.get(0).getOrdersId());
		
		dao.salePriceUpdate(dtos.get(0).getOrdersId(), cakePrice, ordersQuantity, dtos2.get(0).getCakeoptionPrice());
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
