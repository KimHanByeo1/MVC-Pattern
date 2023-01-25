package com.jsplec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.customer.command.CCusotmerReviewDeleteCommand;
import com.jsplec.customer.command.CCustomerAnswerCommand;
import com.jsplec.customer.command.CCustomerBestCakeListCommand;
import com.jsplec.customer.command.CCustomerBoardCommentDeleteCommand;
import com.jsplec.customer.command.CCustomerBoardDeleteCommand;
import com.jsplec.customer.command.CCustomerBoardWriteCommand;
import com.jsplec.customer.command.CCustomerCakeCartCommand;
import com.jsplec.customer.command.CCustomerCakeDetailCommand;
import com.jsplec.customer.command.CCustomerCakeListCommand;
import com.jsplec.customer.command.CCustomerCakeOrderCommand;
import com.jsplec.customer.command.CCustomerCakeQuickOrderCommand;
import com.jsplec.customer.command.CCustomerCakeSortListCommand;
import com.jsplec.customer.command.CCustomerCartDeleteCommand;
import com.jsplec.customer.command.CCustomerCartListCommand;
import com.jsplec.customer.command.CCustomerCartSelectDeleteCommand;
import com.jsplec.customer.command.CCustomerCommand;
import com.jsplec.customer.command.CCustomerDeleteCommand;
import com.jsplec.customer.command.CCustomerFindIdCommand;
import com.jsplec.customer.command.CCustomerFindPwCommand;
import com.jsplec.customer.command.CCustomerIdCheckCommand;
import com.jsplec.customer.command.CCustomerJoinCommand;
import com.jsplec.customer.command.CCustomerLoginCommand;
import com.jsplec.customer.command.CCustomerMyPointCommand;
import com.jsplec.customer.command.CCustomerMypageUpdateCommand;
import com.jsplec.customer.command.CCustomerOrderListCommand;
import com.jsplec.customer.command.CCustomerOrdersListCommand;
import com.jsplec.customer.command.CCustomerPasswordResetCommand;
import com.jsplec.customer.command.CCustomerPayCommand;
import com.jsplec.customer.command.CCustomerQuestionCommand;
import com.jsplec.customer.command.CCustomerReviewListCommand;
import com.jsplec.customer.command.CCustomerUpdateCommand;
import com.jsplec.customer.command.CCustomerWriteListCommand;
import com.jsplec.customer.command.CCustomerWriteReviewCommand;
import com.jsplec.customer.command.CCustomerBoardDetailCommand;
import com.jsplec.customer.command.CCustomerBoardReCommentDeleteCommand;
import com.jsplec.customer.command.CCustomerWriteCommentCommand;
import com.jsplec.manager.command.CManagerAddCakeCommand;
import com.jsplec.manager.command.CManagerAddGoodsCommand;
import com.jsplec.manager.command.CManagerAddStatusCommand;
import com.jsplec.manager.command.CManagerCheckGoodsNameCommand;
import com.jsplec.manager.command.CManagerCheckGoodsNameCommand2;
import com.jsplec.manager.command.CManagerCheckNameCommand;
import com.jsplec.manager.command.CManagerCheckNameCommand2;
import com.jsplec.manager.command.CManagerCommand;
import com.jsplec.manager.command.CManagerDeleteCakeCommand;
import com.jsplec.manager.command.CManagerDeleteGoodsCommand;
import com.jsplec.manager.command.CManagerLoginCommand;
import com.jsplec.manager.command.CManagerMainCommand;
import com.jsplec.manager.command.CManagerOptionAdd;
import com.jsplec.manager.command.CManagerOptionCheck;
import com.jsplec.manager.command.CManagerOptionDeleteCommand;
import com.jsplec.manager.command.CManagerOptionListCommand;
import com.jsplec.manager.command.CManagerOptionSelect;
import com.jsplec.manager.command.CManagerOptionUpdate;
import com.jsplec.manager.command.CManagerOptionView;
import com.jsplec.manager.command.CManagerOrderDeleteCommand;
import com.jsplec.manager.command.CManagerOrderStatusCommand;
import com.jsplec.manager.command.CManagerSearchCakeCommand;
import com.jsplec.manager.command.CManagerSearchGoodsCommand;
import com.jsplec.manager.command.CManagerSoldoutCommand;
import com.jsplec.manager.command.CManagerStatusCommand;
import com.jsplec.manager.command.CManagerUpdateCakeCommand;
import com.jsplec.manager.command.CManagerUpdateGoodsCommand;
import com.jsplec.manager.command.CManagerViewCakeDetailCommand;
import com.jsplec.manager.command.CManagerViewOrdersReviewDetailCommand;
import com.jsplec.manager.command.CManagerViewReviewsListCommand;
import com.jsplec.manager.command.CManagerviewGoodsDetailCommand;

/**
 * Servlet implementation class controller
 */
@WebServlet("*.do")
public class CController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String viewPage = null;
		CManagerCommand managercommand = null;
		CCustomerCommand customercommand = null;
		HttpSession session = request.getSession();

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		switch (com) {

//-------------------------------- 예진 --------------------------------
		case ("/Customer/customerAbout.do"):
			session.invalidate();
			viewPage = "customerAbout.jsp";
			break;

		case ("/Customer/customerMain.do"):
			customercommand = new CCustomerBestCakeListCommand();
			customercommand.execute(request, response);
			viewPage = "customerMain.jsp";
			break;

		case ("/Customer/customerJoin.do"):
			customercommand = new CCustomerJoinCommand();
			customercommand.execute(request, response);
			viewPage = "customerLogin.jsp";
			break;

		case ("/Customer/customerLogin.do"):
			customercommand = new CCustomerLoginCommand();
			boolean check = customercommand.execute2(request, response);
			if (check == true) {
				viewPage = "customerAbout.jsp";
			} else {
				request.setAttribute("CHECK", check);
				viewPage = "customerLogin.jsp";
			}
			break;

		case ("/Customer/customerLoginPage.do"):
			viewPage = "customerLogin.jsp";
			break;

		case ("/Customer/customerLocation.do"):
			viewPage = "customerLocation.jsp";
			break;
			
		case("/Customer/idcheck.do"):
			customercommand=new CCustomerIdCheckCommand();
			customercommand.execute(request, response);
	        viewPage="customerJoin.jsp";
	        break;
	        
	    // 회원가입 페이지로 이동
		case ("/Customer/customerJoinPage.do"):
			viewPage = "customerJoin.jsp";
			break;
			
		// 아이디 찾기 
		case("/Customer/customerFindId.do"):
			customercommand=new CCustomerFindIdCommand();
			customercommand.execute(request, response);
			viewPage="customerShowId.jsp";
			break;
		
		// 비밀번호 찾기 
		case("/Customer/customerFindPw.do"):
			customercommand=new CCustomerFindPwCommand();
			customercommand.execute(request, response);
			viewPage="customerShowPw.jsp";
			break;

		// 비밀번호 재설정
		case("/Customer/customerPwReset.do"):
			customercommand=new CCustomerPasswordResetCommand();
			customercommand.execute(request, response);
			viewPage="customerLoginPage.do";
			break;
			
		// 마이페이지 이동
		case("/Customer/customerMypage.do"):
			viewPage="customerMypage.jsp";
			break;
			
		// 회원정보확인 페이지 이동
		case("/Customer/customerRevision.do"):
			customercommand = new CCustomerMypageUpdateCommand();
			customercommand.execute(request, response);
			viewPage="customerMypageRevision.jsp";
		break;
		
		// 회원정보 수정
		case("/Customer/mypageUpdate.do"):
			customercommand = new CCustomerUpdateCommand();
			customercommand.execute(request, response);
			viewPage="customerMypage.jsp";
			break;
			
		// 회원탈퇴
		case("/Customer/deleteAction.do"):
			customercommand = new CCustomerDeleteCommand();
			customercommand.execute(request, response);
			viewPage="customerLoginPage.do";
			break;
			
		case("/Customer/customerOrderList.do"):
			customercommand = new CCustomerOrdersListCommand();
			customercommand.execute(request, response);
			viewPage = "customerOrdersList.jsp";
			break;
			
			// 마이포인트 내역
		case("/Customer/customerMyPointList.do"):
			customercommand = new CCustomerMyPointCommand();
			customercommand.execute(request, response);
			viewPage = "customerMypoint.jsp";
			break;	

//-------------------------------- 한별 --------------------------------
		// 리뷰 리스트 출력
		case ("/Customer/customerOrdersReview.do"):
			customercommand = new CCustomerReviewListCommand();
			customercommand.execute(request, response);
			viewPage = "customerOrderReview.jsp";
			break;

		// 리뷰작성 버튼 클릭시 구매 리스트 출력 페이지로
		case ("/Customer/customerOrdersList.do"):
			customercommand = new CCustomerOrderListCommand();
			customercommand.execute(request, response);
			viewPage = "customerOrderList.jsp";
			break;

		// 리뷰 작성하기
		case ("/Customer/customerWriteReview.do"):
			customercommand = new CCustomerWriteReviewCommand();
			customercommand.execute(request, response);
			viewPage = "customerOrdersReview.do";
			break;
//==========================================================================
			// XXXXXXXXXXX
		// Q&A 리스트
		case ("/Customer/customerQuestionList.do"):
			customercommand = new CCustomerQuestionCommand();
			customercommand.execute(request, response);
			viewPage = "customerQuestionList.jsp";
			break;

		// Q&A 리스트
		case ("/Customer/customerAnswerList.do"):
			customercommand = new CCustomerAnswerCommand();
			customercommand.execute(request, response);
			viewPage = "customerAnswer.jsp";
			break;
			// XXXXXXXXXXX
//==========================================================================

		// 게시판 리스트 출력
		case ("/Customer/customerWriteList.do"):
			customercommand = new CCustomerWriteListCommand();
			customercommand.execute(request, response);
			viewPage = "customerWriteList.jsp";
			break;

		// 게시판 작성페이지
		case ("/Customer/customerBoardWritePage.do"):
			viewPage = "customerBoardWrite.jsp";
			break;

		// 게시판 작성
		case ("/Customer/customerBoardWrite.do"):
			customercommand = new CCustomerBoardWriteCommand();
			customercommand.execute(request, response);
			viewPage = "customerWriteList.do";
			break;
			
		// 게시판 클릭
		case ("/Customer/customerBoardDetail.do"):
			customercommand = new CCustomerBoardDetailCommand();
			customercommand.execute(request, response);
			viewPage = "customerBoardDetail.jsp";
			break;
			
		// 게시판 답글달기
		case ("/Customer/customerWriteComment.do"):
			customercommand = new CCustomerWriteCommentCommand();
			customercommand.execute(request, response);
			viewPage = "customerBoardDetail.do";
			break;
			
		// 게시판 삭제
		case ("/Customer/customerBoardDelete.do"):
			customercommand = new CCustomerBoardDeleteCommand();
			customercommand.execute(request, response);
			viewPage = "customerWriteList.do";
			break;
			
		// 게시판 답글 삭제
		case ("/Customer/customerBoardCommentDelete.do"):
			customercommand = new CCustomerBoardCommentDeleteCommand();
			customercommand.execute(request, response);
			viewPage = "customerBoardDetail.do";
			break;
		
		// 게시판 댓글 삭제
		case ("/Customer/customerBoardReCommentDelete.do"):
			customercommand = new CCustomerBoardReCommentDeleteCommand();
			customercommand.execute(request, response);
			viewPage = "customerBoardDetail.do";
			break;
		
		// 리뷰 삭제
		case ("/Customer/customerReviewDelete.do"):
			customercommand = new CCusotmerReviewDeleteCommand();
			customercommand.execute(request, response);
			viewPage = "customerOrdersReview.do";
			break;
		
//----------------------- 오수 --------------------------------
		case ("/Customer/customerCakeList.do"):
			customercommand = new CCustomerCakeListCommand();
			customercommand.execute(request, response);
			viewPage = "customerCakeList.jsp";
			break;

		case ("/Customer/customerCakeSortList.do"):
			customercommand = new CCustomerCakeSortListCommand();
			customercommand.execute(request, response);
			viewPage = "customerCakeList.jsp";
			break;
	
			
		case ("/Customer/customerCakeDetail.do"):
			customercommand = new CCustomerCakeDetailCommand();
			customercommand.execute(request, response);
			viewPage = "customerCakeDetail.jsp";
			break;

		case ("/Customer/customerCakeCart.do"):
			customercommand = new CCustomerCakeCartCommand();
			customercommand.execute(request, response);
			viewPage = "customerAbout.jsp";
			break;
			
		case ("/Customer/customerCartList.do"):
			customercommand = new CCustomerCartListCommand();
			customercommand.execute(request, response);
			viewPage = "customerCart.jsp";
			break;
			
		case ("/Customer/customerOrderPage.do"):
			customercommand = new CCustomerCakeOrderCommand();
			customercommand.execute(request, response);
			viewPage = "customerOrder.jsp";
			break;
			
		// 결제
		case ("/Customer/customerOrder.do"):
			customercommand = new CCustomerPayCommand();
			customercommand.execute(request, response);
			viewPage = "customerAbout.jsp";
			break;
			
		// 결제
		case ("/Customer/customerCakeQuickOrder.do"):
			customercommand = new CCustomerCakeQuickOrderCommand();
			customercommand.execute(request, response);
			viewPage = "customerOrder.jsp";
			break;
			
		case ("/Customer/customerCartDelete.do"):
			customercommand = new CCustomerCartDeleteCommand();
			customercommand.execute(request, response);
			viewPage = "customerCartList.do";
			break;
		
		case ("/Customer/customerCartSelectDelete.do"):
			customercommand = new CCustomerCartSelectDeleteCommand();
			customercommand.execute(request, response);
			viewPage = "customerCartList.do";
			break;
			
//-------------------------------- 유승 --------------------------------
		// 메인 화면 출력
		case ("/Manager/managerMain.do"):
			managercommand = new CManagerMainCommand();
			managercommand.execute(request, response);
			viewPage = "managermain.jsp";
			break;
			
		// 케이크 검색
		case ("/Manager/searchCake.do"):
			managercommand = new CManagerSearchCakeCommand();
			managercommand.execute(request, response);
			viewPage = "managerviewmenu.jsp";
			break;

		// 케이크 생성 시 이름 중복확인
		case ("/Manager/checkName.do"):
			managercommand = new CManagerCheckNameCommand();
			managercommand.execute(request, response);
			viewPage = "managercreatecake.jsp";
			break;

		// 케이크 추가
		case ("/Manager/addCake.do"):
			managercommand = new CManagerAddCakeCommand();
			managercommand.execute(request, response);
			viewPage = "searchCake.do";
			break;
			
		// 케이크 상세보기
		case ("/Manager/cakeDetail.do"):
			managercommand = new CManagerViewCakeDetailCommand();
			managercommand.execute(request, response);
			viewPage = "managermanagecake.jsp";
			break;

//================================================================================************
		// 케이크 수정
		case ("/Manager/updateCake.do"):
			managercommand = new CManagerUpdateCakeCommand();
			managercommand.execute(request, response);
			viewPage = "searchCake.do";
			break;
//================================================================================**********


		// 케이크 수정 시 중복확인
		case ("/Manager/checkName2.do"):
			managercommand = new CManagerCheckNameCommand2();
			managercommand.execute(request, response);
			viewPage = "managermanagecake.jsp";
			break;

		// 케이크 삭제
		case ("/Manager/deleteCake.do"):
			managercommand = new CManagerDeleteCakeCommand();
			managercommand.execute(request, response);
			viewPage = "searchCake.do";
			break;

		// 추가상품 검색
		case ("/Manager/searchGoods.do"):
			managercommand = new CManagerSearchGoodsCommand();
			managercommand.execute(request, response);
			viewPage = "managerviewgoods.jsp";
			break;

		// 추가상품 추가
		case ("/Manager/addGoods.do"):
			managercommand = new CManagerAddGoodsCommand();
			managercommand.execute(request, response);
			viewPage = "searchGoods.do";
			break;

		// 추가상품 생성 시 이름 중복확인
		case ("/Manager/checkGoodsName.do"):
			managercommand = new CManagerCheckGoodsNameCommand();
			managercommand.execute(request, response);
			viewPage = "managercreategoods.jsp";
			break;

		// 추가상품 수정 시 이름 중복확인
		case ("/Manager/checkGoodsName2.do"):
			managercommand = new CManagerCheckGoodsNameCommand2();
			managercommand.execute(request, response);
			viewPage = "managermanagegoods.jsp";
			break;

		// 추가상품 상세정보
		case ("/Manager/viewGoodsDetail.do"):
			managercommand = new CManagerviewGoodsDetailCommand();
			managercommand.execute(request, response);
			viewPage = "managermanagegoods.jsp";
			break;

		// 추가상품 삭제
		case ("/Manager/deleteGoods.do"):
			managercommand = new CManagerDeleteGoodsCommand();
			managercommand.execute(request, response);
			viewPage = "searchGoods.do";
			break;

		// 추가상품 수정
		case ("/Manager/updateGoods.do"):
			managercommand = new CManagerUpdateGoodsCommand();
			managercommand.execute(request, response);
			viewPage = "searchGoods.do";
			break;
//================================================================================

		// 리뷰 리스트 출력
		case ("/Manager/searchReview.do"):
			managercommand = new CManagerViewReviewsListCommand();
			managercommand.execute(request, response);
			viewPage = "managerviewreviews.jsp";
			break;
			
		//리뷰 상세 출력
		case ("/Manager/reviewDetail.do"):
			managercommand=new CManagerViewOrdersReviewDetailCommand();
			managercommand.execute(request, response);
			viewPage="maangerviewordersreviewdetail.jsp";
			break;

//-------------------------------- 태권 --------------------------------

		case ("/Manager/managerLoginPage.do"):
			viewPage = "managerLogin.jsp";
			break;
			
		case ("/Manager/managerLogin.do"):
			managercommand = new CManagerLoginCommand();
			boolean check2 = managercommand.execute2(request, response);
			if (check2 == false) {
				request.setAttribute("CHECK", check2);
				viewPage = "managerLogin.jsp";
			} else {
				viewPage = "managerMain.do";
			}
			break;

//================================================================================

		case ("/Manager/Mlist.do"):
			managercommand = new CManagerOptionListCommand();
			managercommand.execute(request, response);
			viewPage = "managerOptionList.jsp";
			break;

		case ("/Manager/addList.do"):
			viewPage = "ManagerOptionAdd.jsp";
			break;


		case ("/Manager/MorderStatus.do"):
			managercommand = new CManagerOrderStatusCommand();
			managercommand.execute(request, response);
			viewPage = "ManagerOrderStatus.jsp";
			break;
		case ("/Manager/Status.do"):
			managercommand = new CManagerStatusCommand();
			managercommand.execute(request, response);
			viewPage = "ManagerAddStatus.jsp";
			break;
		case ("/Manager/ADDR.do"):
			managercommand = new CManagerAddStatusCommand();
			managercommand.execute(request, response);
			viewPage = "MorderStatus.do";
			break;

		case ("/Manager/addOption.do"):
			managercommand = new CManagerOptionAdd();
			managercommand.execute(request, response);
			viewPage = "Mlist.do";
			break;
		// 케이크 옵션 추
		case ("/Manager/return.do"):
			viewPage = "Mlist.do";
			// 리스트로 돌아가기
			break;
		case ("/Manager/Mselect.do"):
			managercommand = new CManagerOptionSelect();
			managercommand.execute(request, response);
			String Query = request.getParameter("Query");
			if (Query == "") {
				viewPage = "Mlist.do";
			} else {
				viewPage = "managerOptionList.jsp";
			}
			break;
		// 옵션 검색 기능
		case ("/Manager/optionId.do"):
			managercommand = new CManagerOptionView();
			managercommand.execute(request, response);
			viewPage = "ManagerOptionUpdate.jsp";
			break;
		// 항목 하나 선택해서 수정 화면 이동
		case ("/Manager/Update.do"):
			managercommand = new CManagerOptionUpdate();
			managercommand.execute(request, response);
			viewPage = "Mlist.do";
			break;
		// 수정 버튼 누르면 반영됨

		case ("/Manager/MO_Delete.do"):
			managercommand = new CManagerOptionDeleteCommand();
			managercommand.execute(request, response);
			viewPage = "Mlist.do";
			break;

		case ("/Manager/ONameCheck.do"):
			managercommand = new CManagerOptionCheck();
			managercommand.execute(request, response);
			viewPage = "ManagerOptionAdd.jsp";
			break;

		case ("/Manager/OUpdateCheck.do"):
			managercommand = new CManagerOptionCheck();
			managercommand.execute(request, response);
			viewPage = "ManagerOptionUpdate.jsp";
			break;
			
		case("/Manager/deleteOrder.do"):
			managercommand = new CManagerOrderDeleteCommand();
			managercommand.execute(request, response);
			viewPage = "MorderStatus.do";
			break;
		case("/Manager/Sold.do"):
			managercommand = new CManagerSoldoutCommand();
			managercommand.execute(request, response);
			viewPage = "MorderStatus.do";
			break;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
