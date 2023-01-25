package com.jsplec.manager.command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.manager.dao.ManagerCakeDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CManagerDeleteCakeCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		ManagerCakeDao dao=new ManagerCakeDao();
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		int maxSize = 1024 * 1024 * 1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, context.getRealPath("/"), maxSize, "utf-8", new DefaultFileRenamePolicy());
			String cakeName=multi.getParameter("cakeOriginalName");
			dao.deleteCake(dao.findID(cakeName));
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
