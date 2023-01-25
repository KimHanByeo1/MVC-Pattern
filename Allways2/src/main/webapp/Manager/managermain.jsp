<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="managerstyle.css">
<link rel="shortcut icon" href="./images/HeaderLogo2.png" sizes="180x180">
<link rel="stylesheet" href="css/Table22.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
table tr.header{
		background:#fdcdcd;
	}
</style>
</head>
<body>
<%@include file="managerHeader.jsp"%>
<fmt:setLocale value="ko_kr"/>
<div align="center">
	<h1 style="margin-bottom:3%;margin-top:3%"><b>Manager Main</b></h1>
	<div class="main">
		<h2 class="inner">최근 매출</h2>
		<div align="right" style="margin:1px">
			<a href="MorderStatus.do" class="viewall">전체보기</a>
		</div>
		<div class="inner">
			<canvas id="PriceCanvas"></canvas>
		</div>
	</div>
	<div class="main">
		<h2 class="inner">미처리 주문</h2>
		<div align="right" style="margin:1px">
			<a href="MorderStatus.do" class="viewall">전체보기</a>
		</div>
		<div class="inner">
			<table class="table">
				<tr class="header">
					<th>주문번호</th>
					<th>구매자</th>
					<th>상품명</th>
				</tr>
				<c:forEach var="cnt" items="${ORDERS }" begin="0" end="9">
					<tr>
						<td>${cnt.ordersId }</td>
						<td>${cnt.o_customerId }</td>
						<td>
								${cnt.cakeName }
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="main">
		<h2 class="inner">최근 주문 건수</h2>
		<div align="right" style="margin:1px">
			<a href="MorderStatus.do" class="viewall">전체보기</a>
		</div>
		<div class="inner">
			<canvas id="QuantityCanvas"></canvas>
		</div>
	</div>
	<div class="main">
		<h2 class="inner">최근 리뷰</h2>
		<div align="right" style="margin:1px">
			<a href="searchReview.do" class="viewall">전체보기</a>
		</div>
		<div class="inner">
			<table class="table">
				<tr class="header">
					<th>날짜</th>
					<th>작성자</th>
					<th>별점</th>
				</tr>
				<c:forEach var="cnt" items="${REVIEWDTO }" begin="0" end="9">
					<tr>
						<td><fmt:formatDate value="${cnt.oreviewInitdate }" type="both" dateStyle="full"/></td>
						<td>${cnt.or_customerId }</td>
						<td>${cnt.oreviewStarrating }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
<form action="#" name="chartdata">
	<input type="hidden" name="Xaxis" value="${XAXIS }">
	<input type="hidden" name="Price" value="${SALESPRICE }">
	<input type="hidden" name="Quantity" value="${SALESQUANTITY }">
</form>
<script>
var price = document.getElementById('PriceCanvas');
var quantity=document.getElementById('QuantityCanvas');
var ctxprice=price.getContext('2d');
var ctxquantity=quantity.getContext('2d');
var xaxis=document.chartdata.Xaxis.value;
var pricedata=document.chartdata.Price.value;
var quantitydata=document.chartdata.Quantity.value;
var arrxaxis=xaxis.split(',');
var arrprice=pricedata.split(',');
var arrquantity=quantitydata.split(',');

const priceChart = new Chart(ctxprice, {
    type: 'line',
    data: {
        labels: arrxaxis,
        datasets: [{
        	label: '매출',
            data: arrprice,
            backgroundColor: [
                'rgb(253, 205, 205)'
            ],
            borderColor: [
            	'rgb(253, 205, 205)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

const quantityChart = new Chart(ctxquantity, {
    type: 'line',
    data: {
        labels: arrxaxis,
        datasets: [{
        	label: '주문건수',
            data: arrquantity,
            backgroundColor: [
            	'rgb(253, 205, 205)'
            ],
            borderColor: [
            	'rgb(253, 205, 205)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
</script>
</body>
</html>