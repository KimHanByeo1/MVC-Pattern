package com.jsplec.manager.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.manager.dao.CManagerOrderListDao;
import com.jsplec.manager.dto.CManagerOptionListDto;
import com.mysql.cj.Session;

public class CManagerOptionSelect implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String option = request.getParameter("option");
		String Query = request.getParameter("Query");
		if(option == null) {
			option = "size";
			Query = "";
		}
		
		CManagerOrderListDao dao = new CManagerOrderListDao();
		ArrayList<CManagerOptionListDto> dtos = dao.selectList(option,Query);

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
		
		if (Query==null) {
			dtos=dao.OptionList();
		} else {
			dtos=dao.selectList(option,Query);
		}
		
		request.setAttribute("OptionList", dtos);
		request.setAttribute("Dtos", dtos);
		request.setAttribute("Size", dtos.size());
		request.setAttribute("Query", Query);
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
