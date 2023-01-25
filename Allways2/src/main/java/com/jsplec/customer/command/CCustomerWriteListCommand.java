package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerWriteListDao;
import com.jsplec.customer.dto.CCustomerWriteListDto;

public class CCustomerWriteListCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String combo = request.getParameter("combo");
		String searchContent = request.getParameter("searchContent");
		
		if(combo == null) {
			combo = "w_customerId";
		}
		if(searchContent == null) {
			searchContent = "";
		}
		
		CCustomerWriteListDao dao = new CCustomerWriteListDao();
		ArrayList<CCustomerWriteListDto> dtos = dao.writeList(combo, searchContent);
		
		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??
		
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);

		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		request.setAttribute("CUSTOMERID", session.getAttribute("ID"));
		request.setAttribute("writeList", dtos);
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
