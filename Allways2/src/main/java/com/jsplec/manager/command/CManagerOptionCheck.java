package com.jsplec.manager.command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.manager.dao.CManagerOrderListDao;
import com.mysql.cj.Session;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CManagerOptionCheck implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		int maxSize = 1024 * 1024 * 1024;
		CManagerOrderListDao dao=new CManagerOrderListDao();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, context.getRealPath("/"), maxSize, "utf-8", new DefaultFileRenamePolicy());
			
			String optionId = multi.getParameter("optionId");
			String optionName = multi.getParameter("optionName");
			String option = multi.getParameter("option");
			String optionPrice = multi.getParameter("optionPrice");
			String cakeoptionImage = multi.getParameter("cakeoptionImage");
			boolean check = dao.CheckOption(optionName, option, optionPrice,optionId,cakeoptionImage);
			request.setAttribute("check", check);
			request.setAttribute("optionName", optionName);
			request.setAttribute("option", option);
			request.setAttribute("optionPrice", optionPrice);
			request.setAttribute("optionId", optionId);
			request.setAttribute("cakeoptionImage", cakeoptionImage);
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

		
		

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		return false;
	}

}
