package com.jsplec.manager.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.manager.dao.CManagerOrderListDao;
import com.jsplec.manager.dao.CManagerOrderStausDao;
import com.jsplec.manager.dto.CManagerOptionListDto;
import com.jsplec.manager.dto.CManagerOrderStautsDTo;

public class CManagerOrderStatusCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CManagerOrderStausDao dao = new CManagerOrderStausDao();
		ArrayList<CManagerOrderStautsDTo> dtos = dao.orderStautsList();
		request.setAttribute("OrdersList", dtos);
		ArrayList<CManagerOrderStautsDTo> dtos2 = dao.orderStautsList2();
		request.setAttribute("OrdersList2", dtos2);
		ArrayList<CManagerOrderStautsDTo> dtos3 = dao.orderStautsList3();
		request.setAttribute("OrdersList3", dtos3);
		
		int index=1;
		int rowcount=7;
		int pagecount=5;
		int pagepage=0;
		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index%pagecount==0) {
			pagepage=index/pagecount-1;
		} else {
			pagepage=index/pagecount;
		}
		request.setAttribute("OrdersList3", dtos3);
		request.setAttribute("Size", dtos3.size());
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
