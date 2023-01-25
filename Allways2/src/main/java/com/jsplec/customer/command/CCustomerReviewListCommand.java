package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerReviewListDao;
import com.jsplec.customer.dto.CCustomerReviewListDto;

public class CCustomerReviewListCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();

		String customerId = (String)session.getAttribute("ID");
		String sort = request.getParameter("sort");
		String searchContent = request.getParameter("searchContent");
		String combo = request.getParameter("combo");
		String pageNum = request.getParameter("index");
		
		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??
		
		if(sort == null) {
			sort = "oreviewInitdate";
		}
		if(pageNum == null) {
			pageNum = "1";
		}
		if(combo == null) {
			combo = "or_customerId";
		}
		if(searchContent == null) {
			searchContent = "";
		}
		
		CCustomerReviewListDao dao = new CCustomerReviewListDao();
		
		ArrayList<CCustomerReviewListDto> dtos = dao.reviewList1(sort, searchContent, combo);
		
		request.setAttribute("listcount", dtos.size());
		request.setAttribute("sort", sort);
		
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);
		ArrayList<CCustomerReviewListDto> dtos2 = dao.reviewList2(sort, searchContent, combo, index, dtos.size());
		
		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		request.setAttribute("CUSTOMERID", customerId);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("reviewList", dtos2);
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
