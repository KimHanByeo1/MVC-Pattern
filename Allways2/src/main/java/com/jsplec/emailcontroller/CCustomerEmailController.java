package com.jsplec.emailcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.customer.dao.CCustomerEmailDao;


	@WebServlet("/Email2")
public class CCustomerEmailController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CCustomerEmailController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String uemail = request.getParameter("email1") + "@" + request.getParameter("email2");
		System.out.println(uemail);
		CCustomerEmailDao dao = new CCustomerEmailDao();
		
		response.getWriter().write(dao.send(uemail) + "");
	}
	
}
