package com.jsplec.manager.command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.manager.dao.ManagerCakeDao;
import com.jsplec.manager.dto.cakeDetailDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CManagerViewCakeDetailCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ManagerCakeDao dao=new ManagerCakeDao();
		cakeDetailDto dto=null;
		try {
			String cakeName=request.getParameter("cakeName");
			dto=dao.viewCakeDetail(cakeName);
//			dto.setCakeImage(context.getRealPath("/") + dto.getCakeImage());
			request.setAttribute("DTO", dto);
			request.setAttribute("cakeOriginalName", dto.getCakeName());
			request.setAttribute("cakeName", dto.getCakeName());
			request.setAttribute("cakePrice", dto.getCakePrice());
			request.setAttribute("cakeDetail", dto.getCakeDetail());
			request.setAttribute("cakeImage", dto.getCakeImage());
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
