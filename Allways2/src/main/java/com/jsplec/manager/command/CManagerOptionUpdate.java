package com.jsplec.manager.command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.manager.dao.CManagerOrderListDao;
import com.jsplec.manager.dao.ManagerCakeDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CManagerOptionUpdate implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		int maxSize = 1024 * 1024 * 1024;
		CManagerOrderListDao dao = new CManagerOrderListDao();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, context.getRealPath("/"), maxSize, "utf-8", new DefaultFileRenamePolicy());
			String cakeoptionCategory = multi.getParameter("option");
			int cakeoptionId = Integer.parseInt(multi.getParameter("optionId"));
			String cakeoptionValue = multi.getParameter("optionName");
			int cakeoptionPrice = Integer.parseInt(multi.getParameter("optionPrice"));
			String cakeoptionImage = multi.getFilesystemName("cakeoptionImage");
			dao.contentUpdate(cakeoptionCategory, cakeoptionValue, cakeoptionPrice, cakeoptionImage, cakeoptionId);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
