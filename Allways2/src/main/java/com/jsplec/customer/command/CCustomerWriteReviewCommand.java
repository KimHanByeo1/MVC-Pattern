package com.jsplec.customer.command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.dao.CCustomerWriteReviewDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CCustomerWriteReviewCommand implements CCustomerCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		
		int maxSize = 1024 * 1024 * 1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, context.getRealPath("/Customer/reviewImageFile/"), maxSize, "utf-8", new DefaultFileRenamePolicy());
			
			String customerId = (String)session.getAttribute("ID");
			int ordersId = Integer.parseInt(multi.getParameter("ordersId"));
			int o_cakeId = Integer.parseInt(multi.getParameter("o_cakeId"));
			String oreviewStarRating = multi.getParameter("oreviewStarRating");
			String oreviewContent = multi.getParameter("oreviewContent");
			String uploadFile = multi.getFilesystemName("cakeviews");
			
			CCustomerWriteReviewDao dao = new CCustomerWriteReviewDao();
			
			dao.writeReview(customerId, ordersId, oreviewStarRating, oreviewContent, uploadFile, o_cakeId);
			dao.writeReviewUpdate(ordersId);
			
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
