package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerCakeListDao;
import com.jsplec.customer.dto.CCustomerCakeListDto;

public class CCustomerCakeListCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int index = 1; // 시작 페이지 번호
		int rowcount = 8; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??
		
		String queryName = request.getParameter("query");
		String content = request.getParameter("content");
		String sort1 = request.getParameter("sort1");
		String sort2 = request.getParameter("sort2");

		if (queryName == null) {
			queryName = "cakeId";
			content = "";
		}
		if(sort1 == null) {
			sort1 = "cakeInitdate";
			sort2 = "desc";
		}

		CCustomerCakeListDao dao = new CCustomerCakeListDao();
		ArrayList<CCustomerCakeListDto> dtos = dao.cakeList(queryName, content, sort1, sort2);
		request.setAttribute("cakeList", dtos);
		
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);

		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		request.setAttribute("sort1", sort1);
		request.setAttribute("sort2", sort2);
		request.setAttribute("cakeList", dtos);
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
