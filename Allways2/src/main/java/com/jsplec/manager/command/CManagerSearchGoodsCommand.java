package com.jsplec.manager.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.manager.dao.CManagerGoodsDao;
import com.jsplec.manager.dto.goodsDto;

public class CManagerSearchGoodsCommand implements CManagerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String goodsName=request.getParameter("query");
		String goodsCategory=request.getParameter("goodsCategory");
		CManagerGoodsDao dao=new CManagerGoodsDao();
		ArrayList<goodsDto> dtos=new ArrayList<goodsDto>();
		int index=1;
		int rowcount=7;
		int pagecount=5;
		int pagepage=0;
		
		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index%pagecount==0) {
			pagepage=index/pagecount-1;
		} else {
			pagepage=index/pagecount;
		}
		
		if (goodsName==null) {
			if (goodsCategory==null||goodsCategory.equals("all")) {
				dtos=dao.viewGoodsList();
			} else {
				dtos=dao.viewGoodsList(goodsCategory);
			}
		} else {
			if (goodsCategory==null||goodsCategory.equals("all")) {
				dtos=dao.searchGoods(goodsName);
			} else {
				dtos=dao.searchGoods(goodsName, goodsCategory);
			}
		}
		
		request.setAttribute("Dtos", dtos);
		request.setAttribute("goodsCategory", goodsCategory);
		request.setAttribute("Size", dtos.size());
		request.setAttribute("Query", goodsName);
		request.setAttribute("index", index);
		request.setAttribute("rowcount", rowcount);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("pagepage", pagepage);
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
