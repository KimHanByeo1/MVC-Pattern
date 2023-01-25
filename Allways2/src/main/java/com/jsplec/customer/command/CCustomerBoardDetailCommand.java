package com.jsplec.customer.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerWriteListDao;
import com.jsplec.customer.dto.CCustomerWriteListDto;

public class CCustomerBoardDetailCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String customerId = (String)session.getAttribute("ID");
		
		int writeId = Integer.parseInt(request.getParameter("writeId"));
		CCustomerWriteListDao dao = new CCustomerWriteListDao();
		
		CCustomerWriteListDto dto = dao.boardDetail(writeId);
		ArrayList<CCustomerWriteListDto> dtos = dao.boardComment(writeId);
		
		for(int i = 0; i < dtos.size(); i++) {
			dtos.get(i).getWriteId();
		}
		
		request.setAttribute("boardlength", dtos.size());
		request.setAttribute("CUSTOMERID", customerId);
		request.setAttribute("boardDetail", dto);
		request.setAttribute("boardComment", dtos);
		
	}

	@Override
	public boolean execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
