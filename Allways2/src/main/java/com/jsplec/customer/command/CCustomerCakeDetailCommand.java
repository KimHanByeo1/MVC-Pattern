package com.jsplec.customer.command;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerCakeDetailDao;
import com.jsplec.customer.dao.CCustomerCakeDetailReviewDao;
import com.jsplec.customer.dao.CCustomerCakeOptionListDao;
import com.jsplec.customer.dto.CCustomerCakeDetailReviewDto;
import com.jsplec.customer.dto.CCustomerCakeListDto;
import com.jsplec.customer.dto.CCustomerCakeOptionListDto;

public class CCustomerCakeDetailCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("ID");
		
		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
		
		CCustomerCakeDetailDao dao = new CCustomerCakeDetailDao();

		CCustomerCakeListDto dto = dao.cakeDetail(cakeId);
		
		request.setAttribute("cakeInfo", dto);
		
		dao.viewsUpdate(cakeId);
		
		
		
		
		
		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??
		
		
		CCustomerCakeDetailReviewDao dao2 = new CCustomerCakeDetailReviewDao();
		
		
		ArrayList<CCustomerCakeDetailReviewDto> dtos = dao2.detailReview(cakeId);
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);
		
		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		 
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		request.setAttribute("reviewList", dtos);
		request.setAttribute("listcount", dtos.size());
		
		
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("arrsize", dtos.size());
		request.setAttribute("index", index);
		request.setAttribute("rowcount", rowcount);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("pagepage", pagepage);
		
		
		CCustomerCakeOptionListDao dao3 = new CCustomerCakeOptionListDao();
		ArrayList<CCustomerCakeOptionListDto> dtos3 = dao3.shapeList();
		request.setAttribute("shapeList", dtos3);
		
		CCustomerCakeOptionListDao dao4 = new CCustomerCakeOptionListDao();
		ArrayList<CCustomerCakeOptionListDto> dtos4 = dao4.sizeList();
		request.setAttribute("sizeList", dtos4);
		
		CCustomerCakeOptionListDao dao5 = new CCustomerCakeOptionListDao();
		ArrayList<CCustomerCakeOptionListDto> dtos5 = dao5.flavorList();
		request.setAttribute("flavorList", dtos5);
		
		CCustomerCakeOptionListDao dao6 = new CCustomerCakeOptionListDao();
		ArrayList<CCustomerCakeOptionListDto> dtos6 = dao6.icingColorList();
		request.setAttribute("icingColorList", dtos6);
		
		CCustomerCakeOptionListDao dao7 = new CCustomerCakeOptionListDao();
		ArrayList<CCustomerCakeOptionListDto> dtos7 = dao7.borderColorList();
		request.setAttribute("borderColorList", dtos7);
		
		CCustomerCakeOptionListDao dao8 = new CCustomerCakeOptionListDao();
		ArrayList<CCustomerCakeOptionListDto> dtos8 = dao8.messageColorList();
		request.setAttribute("messageColorList", dtos8);
		
		
		
		
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
