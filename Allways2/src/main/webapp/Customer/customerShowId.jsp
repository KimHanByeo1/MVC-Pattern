<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="customerHeader.jsp" %>
</head>

	<script type="text/javascript">

	function login(){
		var form = document.customerShowId;
		form.action="customerLoginPage.do";
		form.submit();
	}
	
	function join(){
		var form = document.customerShowId;
		form.action="customerJoin.jsp";
		form.submit();
	}
	
	function home(){
		var form = document.customerShowId;
		form.action="customerAbout.do";
		form.submit();
	}
	
	</script>
	
	<style>
	
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

	<form action="customerShowId.do" name="customerShowId" method="post" style="height: 1400px;">
		<div class="container text-center">
			<div class="row">
				<div class="col">
				</div>
				<div class="col">
					<img style="margin-top: 30px;" src="./images/Join.png" id="Join_image"><br>
					<br><h2 id="Join"></h2><br>
						
						<c:if test="${CUSTOMERID==null}">
							" ID를 찾을 수 없습니다. " <br><br>
							
							<input id="join_button" style="margin-top: 30px" type="button" value="JOIN" onclick="join()">
							<input id="join_button" style="margin-top: 30px" type="button" value="HOME" onclick="home()">
								
						</c:if>
						
						<c:if test="${CUSTOMERID!=null }">
							
							<h3>환영합니다</h3><br><br>
						
							${CUSTOMERNAME}님께서 가입하신 아이디는 <br><br>
								"${CUSTOMERID}"<br><br>
								입니다.<br><br>
							<input id="join_button" style="margin-top: 30px" type="button" name="join" value="LOGIN" onclick="login()">	
							
						</c:if>
						
						
						<br><br>					
					
				</div>
			<div class="col">
			</div>
			</div>
		</div>
	</form>
	
</body>
</html>