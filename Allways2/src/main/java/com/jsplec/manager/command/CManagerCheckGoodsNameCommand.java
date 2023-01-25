package com.jsplec.manager.command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.manager.dao.CManagerGoodsDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CManagerCheckGoodsNameCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		boolean check=false;
		CManagerGoodsDao dao=new CManagerGoodsDao();
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		int maxSize = 1024 * 1024 * 1024;
		String goodsName=null;
		String goodsPrice=null;
		String goodsDetail=null;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, context.getRealPath("/"), maxSize, "utf-8", new DefaultFileRenamePolicy());
			goodsName=multi.getParameter("goodsName");
			goodsPrice=multi.getParameter("goodsPrice");
			goodsDetail=multi.getParameter("goodsDetail");
			check=dao.checkName(goodsName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.setAttribute("check", check);
		request.setAttribute("goodsName", goodsName);
		request.setAttribute("goodsPrice", goodsPrice);
		request.setAttribute("goodsDetail", goodsDetail);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
