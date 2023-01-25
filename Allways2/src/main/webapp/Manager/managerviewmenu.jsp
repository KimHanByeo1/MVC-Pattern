<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>케이크 리스트 보기</title>
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
	table tr.header{
		background:#fdcdcd;
	}
	a.tablebutton:hover{
		color:#a87878;
	}
	a.pagebutton{
		color:#000000;
		font-size:1.2em;
		text-decoration:none;
		margin:10px;
	}
	a.pagebutton:hover{
		color:#a87878;
	}
	
</style>
</head>
<body>
<%@include file="managerHeader.jsp"%>
<fmt:setLocale value="ko_kr"/>
<div align="center">
	<h1 style="margin-bottom:3%;margin-top:3%"><b>케이크 리스트</b></h1>
	<form action="searchCake.do">
		<div align="center" style="margin-bottom:10px;padding:5px;width:90%">
			<div style="width:20%;display:inline-block" align="left">
				<input type="text" size="1" class="form-control" name="query" style="border-color:#a87878" value="${Query }">
			</div>
			<div style="width:25%;display:inline-block" align="left">
				<input type="submit" class="btn btn-primary" style="background:#ffffff;border-color:#a87878;color:#a87878" value="검색">
			</div>
			<div style="width:50%;display:inline-block" align="right">
				<span style="font-size:1.6em">총 ${Size}건</span>
			</div>
		</div>
	</form>
	<div class="tablediv">
		<table>
			<tr class="header">
				<th>메뉴번호</th>
				<th>이름</th>
				<th>가격</th>
				<th>조회수</th>
				<th>좋아요</th>
			</tr>
			<c:if test="${Size==0 }">
				<tr>
					<td colspan="5" align="center">검색 결과가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="cnt" items="${Dtos}" begin="${(index-1)*rowcount }" end="${(index)*rowcount-1}">
				<tr>
					<td>${cnt.cakeId}</td>
					<td><a href="cakeDetail.do?cakeName=${cnt.cakeName}" class="tablebutton">${cnt.cakeName}</a></td>
					<td><fmt:formatNumber value="${cnt.cakePrice}" type="currency"/></td>
					<td><fmt:formatNumber value="${cnt.cakeViews}" groupingUsed="true"/></td>
					<td><fmt:formatNumber value="${cnt.cakeLike }" groupingUsed="true"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="tablediv" align="right">
		<a href="managercreatecake.jsp" style="color:#a87878;text-decoration:none">추가</a>
	</div>
	
	<c:if test="${true }">
	<div class="tablediv" align="center">
		<a href="searchCake.do?index=1&query=${Query}" class="pagebutton">처음으로</a>
		<c:if test="${index!=1 }">
			<a href="searchCake.do?index=${index-1 }&query=${Query}" class="pagebutton">이전</a>
		</c:if>
		<c:forEach var="cnt" begin="${pagecount*pagepage+1}" end="${pagecount*(pagepage+1) }">
			<c:if test="${cnt<=Math.ceil(Size/rowcount) }">
				<c:if test="${cnt==index }">
					<span style="display:inline">
						<a href="searchCake.do?index=${cnt }&query=${Query}" style="font-size:1.3em" class="pagebutton">${cnt }</a>
					</span>
				</c:if>
				<c:if test="${cnt!=index }">
					<a href="searchCake.do?index=${cnt }&query=${Query}" class="pagebutton">${cnt }</a>
				</c:if>
			</c:if>
		</c:forEach>
		<c:if test="${index<Math.ceil(Size/rowcount) }">
			<a href="searchCake.do?index=${index+1 }&query=${Query}" class="pagebutton">다음</a>
		</c:if>
		<a href="searchCake.do?index=${Math.ceil(Size/rowcount) }&query=${Query}" class="pagebutton">끝으로</a>
	</div>
	</c:if>
</div>
</body>
</html>