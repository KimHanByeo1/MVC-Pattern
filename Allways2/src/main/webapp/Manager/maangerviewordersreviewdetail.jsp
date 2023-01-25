<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="managerstyle.css">
<link rel="stylesheet" href="css/Table22.css">
<link rel="shortcut icon" href="./images/HeaderLogo2.png" sizes="180x180">
<style>
div{
	padding:1%;
}
</style>
<script>
	function cancelDo(){
		var form=document.actionForm;
		form.action="searchReview.do";
		form.submit();
	}
</script>
</head>
<body>
<fmt:setLocale value="ko_kr"/>
<%@include file="managerHeader.jsp"%>
<div align="center">
<form action="addCake.do" method="post" enctype="multipart/form-data" name="actionForm">
	<h1 style="margin-bottom:3%;margin-top:3%"><b>리뷰 상세</b></h1>
	<div style="display: inline-block;width:60%">
		<div align="left" style="width:20%;display:inline-block">
			제품 이름: 
		</div>
		<div align="left" style="width:74%;display:inline-block">
			<div style="width:50%;display:inline-block">
				${DTO.or_cakeName }
			</div>
			<div style="display:inline-block">
				작성자: 
			</div>
			<div style="display:inline-block">
				${DTO.or_customerId }
			</div>
		</div>
		<div align="left" style="width:20%;display:inline-block">
			작성일: 
		</div>
		<div align="left" style="width:74%;display:inline-block">
			<fmt:formatDate value="${DTO.oreviewInitdate }" type="both" dateStyle="full" timeStyle="full"/>
		</div>
		<div align="left" style="width:20%;height:20%;display:inline-block">
			리뷰내용
		</div>
		<div align="left" style="width:74%;height:20%;display:inline-block">
			<textarea style="width:100%;margin-top:20px;border-color:#fdcdcd" class="form-control" name="cakeDetail" readonly>${DTO.oreviewContent }</textarea>
		</div>
		<div align="left" style="width:20%;display:inline-block">
			별점
		</div>
		<div align="left" style="width:74%;display:inline-block">
			<c:forEach var="cnt" begin="1" end="${DTO.oreviewStarrating }">
				★
			</c:forEach>
			<c:forEach var="cnt" begin="${DTO.oreviewStarrating+1 }" end="5">
				☆
			</c:forEach>
		</div>
	</div>
	<div style="display:inline-block;width:30%;height:50%" align="center">
		<div>
			사진
		</div>
		<div>
			<img src="/Allways/Customer/reviewImageFile/${DTO.oreviewImage }" id="preview" height="200" width="200" style="display:block;margin:20px;border-radius:10px;">
		</div>
		<div>
			<input type="button" class="btn" style="background:#ffffff;border-color:#a87878;color:#a87878" value="뒤로" onclick="cancelDo()">
		</div>
	</div>
</form>
</div>
</body>
</html>