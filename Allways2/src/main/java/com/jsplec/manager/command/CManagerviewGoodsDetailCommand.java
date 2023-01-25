package com.jsplec.manager.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.manager.dao.CManagerGoodsDao;
import com.jsplec.manager.dto.goodsDto;

public class CManagerviewGoodsDetailCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CManagerGoodsDao dao=new CManagerGoodsDao();
		goodsDto dto=null;
		String goodsName=request.getParameter("goodsName");
		dto=dao.viewGoodsDetail(goodsName);
		
		request.setAttribute("DTO", dto);
		request.setAttribute("goodsName", dto.getGoodsName());
		request.setAttribute("goodsOriginalName", dto.getGoodsName());
		request.setAttribute("goodsCategory", dto.getGoodsCategory());
		request.setAttribute("goodsPrice", dto.getGoodsPrice());
		request.setAttribute("goodsDetail", dto.getGoodsDetail());
		request.setAttribute("goodsImage",dto.getGoodsImage());
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
