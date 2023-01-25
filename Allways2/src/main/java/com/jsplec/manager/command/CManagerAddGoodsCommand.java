package com.jsplec.manager.command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.manager.dao.CManagerGoodsDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CManagerAddGoodsCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		int maxSize = 1024 * 1024 * 1024;
		CManagerGoodsDao dao=new CManagerGoodsDao();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, context.getRealPath("/"), maxSize, "utf-8", new DefaultFileRenamePolicy());
			String goodsName=multi.getParameter("goodsName");
			String goodsCategory=multi.getParameter("goodsCategory");
			int goodsPrice=Integer.parseInt(multi.getParameter("goodsPrice"));
			String goodsDetail=multi.getParameter("goodsDetail");
			String goodsImage=multi.getFilesystemName("goodsImage");
			dao.addGoods(goodsName, goodsCategory, goodsPrice, goodsDetail, goodsImage);
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
