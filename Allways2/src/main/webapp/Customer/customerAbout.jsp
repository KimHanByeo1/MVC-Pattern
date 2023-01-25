<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@700&display=swap" rel="stylesheet">


<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/hanna.css);

	#Story {
		font-family: 'Hanna', sans-serif;
		font-style: normal;
		font-weight: 400;
		font-size: 33px;
		line-height: 48px;
		text-align: center;
		color: #4E4D4D;
	}
	
	/* “ALLWAYS”는 ALL과 WAYS의 합성어이자 ALWAYS의 동음이의어로, 사랑하는 사람들과 행복한 순간에 항상 함께하고 싶은 모든 마음을 ALLWAYS에서 정성스럽게 전달해드리겠다는 의미를 담았습니다. */
#font{
	position: absolute;
	width: 1428px;
	height: 460px;
	font-family: 'EF_Diary';
	font-style: normal;
	font-weight: 400;
	font-size: 26px;
	line-height: 48px;
	text-align: center;
	color: #4E4D4D;
}
	
</style>
</head>
<body style="background: #FFF1F1">
<%@include file="customerHeader.jsp" %>
	<form action="customerAbout2.do" name="customerAbout" method="post">
		<div class="container text-center">
			<div class="row">
				<div class="col">
				</div>
				<div class="col1" style="padding-top: 100px; padding-right: 200px;">
					<img src="./images/Title1.png" /><br>
				</div>
				<div class="col2" style="padding-left: 220px; padding-top: 7px;">
					<img src="./images/Title2.png" /><br>
				</div>
				<div class="col2" style="padding-left: 220px; padding-top: 50px; padding-right: 90px;">
					<img src="./images/About.png" /><br>
				</div>
	
				<div class="col2" id="font" style="padding-left: 210px; padding-top: 1000px; padding-right: 430px; padding-bottom: 700px">
					“ALLWAYS”는 <br><br>
	
					ALL과 WAYS의 합성어이자 ALWAYS의 동음이의어로,<br><br>
	 
					사랑하는 사람들과 행복한 순간에 항상 함께하고 싶은 모든 마음을<br><br>
	
					ALLWAYS에서 <br><br>
	
					정성스럽게 전달해드리겠다는 의미를 담았습니다.  <br><br>
				</div>
				
			<div class="col">
			</div>
			</div>
		</div>
	</form>

</body>
</html>