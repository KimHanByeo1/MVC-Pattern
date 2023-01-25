<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 리스트 보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="managerstyle.css">
<link rel="stylesheet" href="css/Table22.css">
<link rel="shortcut icon" href="./images/HeaderLogo2.png" sizes="180x180">
<style>
a.tablebutton{
		color:#000000;
		text-decoration:none;
		margin:10px;
	}
a.pagebutton{
		color:#000000;
		font-size:1.2em;
		text-decoration:none;
		margin:10px;
	}
table tr.header{
		background:#fdcdcd;
	}
a.pagebutton:hover{
	color:#a87878;
}
table tr.header{
	background:#fdcdcd;
}
</style>
</head>
<body>
<%@include file="managerHeader.jsp"%>
<fmt:setLocale value="ko_kr"/>
<div align="center">
	<h1 style="margin-bottom:3%;margin-top:3%"><b>리뷰 리스트</b></h1>
	<form action="searchReview.do">
		<div align="center" style="margin-bottom:10px;padding:5px;width:90%">
			<div style="width:20%;display:inline-block" align="left">
				<input type="text" size="1" class="form-control" name="query" style="border-color:#a87878" value="${Query }">
			</div>
			<div style="width:25%;display:inline-block" align="left">
				<select name="condition" style="border-color:#fdcdcd;border-radius:10px;height:90%">
					<c:if test="${condition=='or_customerId' }">
						<option selected value="or_customerId">사용자 ID로 검색</option>
					</c:if>
					<c:if test="${condition!='or_customerId' }">
						<option value="or_customerId">사용자 ID로 검색</option>
					</c:if>
					<c:if test="${condition=='cakeName' }">
						<option selected value="cakeName">케이크 이름으로 검색</option>
					</c:if>
					<c:if test="${condition!='cakeName' }">
						<option value="cakeName">케이크 이름으로 검색</option>
					</c:if>
					<c:if test="${condition=='goodsName' }">
						<option selected value="goodsName">추가상품 이름으로 검색</option>
					</c:if>
					<c:if test="${condition!='goodsName' }">
						<option value="goodsName">추가상품 이름으로 검색</option>
					</c:if>
				</select>
				<input type="submit" class="btn btn-primary" style="background:#ffffff;border-color:#a87878;color:#a87878" value="검색">
			</div>
			<div style="width:50%;display:inline-block" align="right">
				<span style="font-size:1.2em">총 ${Size}건</span>
			</div>
		</div>
	</form>
	<div class="tablediv">
		<table>
			<tr class="header">
				<th>일련번호</th>
				<th>작성자</th>
				<th>리뷰 상품명</th>
				<th>별점</th>
				<th>작성일</th>
			</tr>
			<c:if test="${Size==0 }">
				<tr>
					<td colspan="5" align="center">검색 결과가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="cnt" items="${Dtos}" begin="${(index-1)*rowcount }" end="${(index)*rowcount-1}">
				<tr>
					<td>${cnt.oreviewId}</td>
					<td>${cnt.or_customerId }
					<td><a href="reviewDetail.do?oreviewId=${cnt.oreviewId }" class="tablebutton">${cnt.or_cakeName }</a></td>
					<td>${cnt.oreviewStarrating}</td>
					<td><fmt:formatDate value="${cnt.oreviewInitdate}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="tablediv" align="center">
		<a href="searchReview.do?index=1&query=${Query}&condition=${condition}" class="pagebutton">처음으로</a>
		<c:if test="${index!=1 }">
			<a href="searchReview.do?index=${index-1 }&query=${Query}&condition=${condition}" class="pagebutton">이전</a>
		</c:if>
		<c:forEach var="cnt" begin="${pagecount*pagepage+1}" end="${pagecount*(pagepage+1) }">
			<c:if test="${cnt<=Math.ceil(Size/rowcount) }">
				<c:if test="${cnt==index }">
					<span style="display:inline">
						<a href="searchReview.do?index=${cnt }&query=${Query}&condition=${condition}" style="font-size:1.3em" class="pagebutton">${cnt }</a>
					</span>
				</c:if>
				<c:if test="${cnt!=index }">
					<a href="searchReview.do?index=${cnt }&query=${Query}&condition=${condition}" class="pagebutton">${cnt }</a>
				</c:if>
			</c:if>
		</c:forEach>
		<c:if test="${index<Math.ceil(Size/rowcount) }">
			<a href="searchReview.do?index=${index+1 }&query=${Query}&condition=${condition}" class="pagebutton">다음</a>
		</c:if>
		<a href="searchReview.do?index=${Math.ceil(Size/rowcount) }&query=${Query}&condition=${condition}" class="pagebutton">끝으로</a>
	</div>
</div>
</body>
</html>