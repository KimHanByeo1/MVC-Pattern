<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Viewport -->
<meta name="viewport" content="width=device-width, initial-scale=1" />

<meta name="format-detection" content="telephone=no, address=no, email=no" />

<!-- XEIcon -->
<link rel="stylesheet" href="/assets/fonts/icons/xeicon/xeicon.css?ver=1.015" />

<!-- Masstige Custom Icon for Board Template -->
<link rel="stylesheet" href="/assets/fonts/icons/icomoon/masstige-icons.css?ver=1.015" />

<!-- Google Material Icons -->
<link rel="stylesheet" href="/assets/fonts/icons/material/material-icons.css?ver=1.015" />

<!-- Bootstrap Icons -->
<link rel="stylesheet" href="/assets/fonts/icons/bootstrap/bootstrap-icons.min.css?ver=1.015" />

<!-- Stylesheet -->
<link rel="stylesheet" href="/assets/css/jquery-ui.min.css?ver=1.015" />
<link rel="stylesheet" href="/assets/css/common.min.css?220214v2&ver=1.015" />

<!-- Load jQuery -->
<script src="/assets/js/lib/jquery-1.7.1.min.js"></script>
<!-- update your pre-1.9 jQuery code to jQuery 1.9 up to 3.0 -->
<script src="/assets/js/lib/jquery-migrate-1.4.1.min.js"></script>
<!-- jQuery 3.0 or higher, once you have used Migrate 1.x and upgraded to jQuery 1.9 or higher -->
<!-- <script src="/assets/js/lib/jquery-migrate-3.3.2.min.js"></script>  -->
<!-- mCustomScrollbar 사용시 아래 1.11.1 버전 사용 -->
<!-- <script src="/assets/js/lib/jquery-1.11.1.min.js"></script> -->

<script src="/assets/js/lib/jquery-ui.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@700&display=swap" rel="stylesheet">

<title>ALLWAYS FIND PW</title>
<%@include file="customerHeader.jsp" %>
</head>

	<script type="text/javascript">

	function resetAction(){
		var form = document.customerShowPw;
		var pw = document.customerShowPw.customerPw.value;
		var pwchk = document.customerShowPw.customerPwCheck.value;
		
		var regExPw=/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/; //영문 대문자와 소문자, 특수문자, 숫자 모두 포함하여 8글자 이상

		if(pw.length == 0) {
			alert("비밀번호를 입력해 주세요.");
			customerJoin.customerPw.focus();
			return;
		}
		if(!regExPw.test(pw)){
			alert("비밀번호는 영문 대소문자, 숫자, 특수문자를 모두 포함하여 8글자 이상 작성해야 합니다.");
			return;
		}
		
		if(pw != pwchk) {
			alert("비밀번호가 일치하지 않습니다.");
			customerJoin.customerPw.focus();
			return;
		}
		
		alert("변경되었습니다.");
		form.action="customerPwReset.do";
		form.submit();
	}
	
	function join(){
		var form = document.customerShowPw;
		form.action="customerJoin.jsp";
		form.submit();
	}
	
	function home(){
		var form = document.customerShowPw;
		form.action="customerAbout.do";
		form.submit();
	}
	
	</script>
	
	<style type="text/css">	
	
	#input_box{
		box-sizing: border-box;
		left: 30px;
		right: 0px;
		width: 350px;
		height: 45px;
		background: #FFFFFF;
		border: 3px solid #FCD5D5;
		padding-left: 10px;
	
	}
	
	#label_design{
		font-family: 'Baloo Tammudu 2';
		font-style: normal;
		font-weight: 600;
		font-size: 18px;
		line-height: 32px;
		display: flex;
		color: #766262;
		margin-bottom: 0px;
		height:25px;
	}	
	

	#join_button {
		width: 136.55px;
		height: 41.63px;
		background: #FCD5D5;
		border: 2px solid #FCD5D5;
		font-family: 'Baloo Tammudu 2';
		font-style: normal;
		font-weight: 700;
		font-size: 20px;
		color: #FFFDFD;
		line-height: 46px;
	}
	

</style>

	
<body>

	<form action="customerShowPw.do" name="customerShowPw" method="post" style="height: 1400px;">
		<div class="container text-center">
			<div class="row">
				<div class="col">
				</div>
				<div class="col">
					<img style="margin-top: 30px;" src="./images/Join.png" id="Join_image"><br>
					<br><h2 id="Join"></h2><br>
						
						<c:if test="${USERCHECK==false}">
							" 일치하는 회원 정보가 없습니다. " <br><br>
							
							<input id="join_button" style="margin-top: 30px" type="button" value="JOIN" onclick="join()">
							<input id="join_button" style="margin-top: 30px" type="button" value="HOME" onclick="home()">
								
						</c:if>
						
						<c:if test="${USERCHECK==true}">
							
							<h4>비밀번호 재설정</h4><br>
							
							<input id="input_box" type="hidden" name="customerId" value="${USERID}">
							
							<label id="label_design">PASSWORD</label><br>
							<input id="input_box" type="password" name="customerPw" placeholder="비밀번호 입력"><br><br>
							
							<label id="label_design">PASSWORD CHECK</label><br>
							<input id="input_box" type="password" name="customerPwCheck" placeholder="비밀번호 재입력"><br><br>
							
							<input id="join_button" style="margin-top: 30px" type="button" name="join" value="RESET" onclick="resetAction()">	
							
						</c:if>
					
				</div>
			<div class="col">
			</div>
			</div>
		</div>
	</form>
	
</body>
</html>