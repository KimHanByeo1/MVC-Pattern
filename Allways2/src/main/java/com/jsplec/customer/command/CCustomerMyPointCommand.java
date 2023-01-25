package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerMyPointDao;
import com.jsplec.customer.dto.CCustomerMyPointDto;

public class CCustomerMyPointCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("ID");
		
		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??
		int totalPoint = 0;
		
		CCustomerMyPointDao dao = new CCustomerMyPointDao();
		ArrayList<CCustomerMyPointDto> dtos = dao.selectPoint(customerId);
	
		for(int i = 0; i < dtos.size(); i++) {
			totalPoint += dtos.get(i).getOrdersPoint();
		}
		
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);

		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}

		request.setAttribute("totalPoint", totalPoint);
		request.setAttribute("myPointList", dtos);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("arrsize", dtos.size());
		request.setAttribute("index", index);
		request.setAttribute("rowcount", rowcount);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("pagepage", pagepage);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
