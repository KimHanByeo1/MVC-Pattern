package com.jsplec.manager.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.manager.dao.CManagerLogin;

public class CManagerLoginCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String managerId = request.getParameter("managerId");
		String managerPw = request.getParameter("managerPw");
		HttpSession session=request.getSession();
		
		CManagerLogin dao = new CManagerLogin();
		boolean logincheck = dao.managerLogin(managerId, managerPw);
		return logincheck;
	}

}
