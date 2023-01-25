package com.jsplec.manager.command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.manager.dao.ManagerCakeDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CManagerAddCakeCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		int maxSize = 1024 * 1024 * 1024;
		ManagerCakeDao dao=new ManagerCakeDao();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, context.getRealPath("/"), maxSize, "utf-8", new DefaultFileRenamePolicy());
			String cakeName=multi.getParameter("cakeName");
			int cakePrice=Integer.parseInt(multi.getParameter("cakePrice"));
			String cakeDetail=multi.getParameter("cakeDetail");
			String cakeImage = multi.getFilesystemName("cakeImage");
			dao.addCake(cakeName, cakePrice, cakeImage, cakeDetail);
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
