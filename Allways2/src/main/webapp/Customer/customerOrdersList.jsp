<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

</head>
<body>

	<%@include file="customerHeader.jsp" %>
	
	<div align="center" class="container text-center" style = "margin-top: 50px;">
		<form action = "" method = "post" name = "myform">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">No</th>
						<th scope="col">케이크 이름</th>
						<th scope="col">구매자</th>
						<th scope="col">가격</th>
						<th scope="col">구매수량</th>
						<th scope="col">구매날짜</th>
					</tr>
				</thead>
				
				<c:forEach var = "dto" items = "${ordersList}" begin = "${(index - 1) * rowcount }" end = "${(index) * rowcount - 1}">
					<c:if test="${arrsize != 0 }">
						<tbody>
							<tr>
								<td>${dto.ROWNUM}</td>
								<td>${dto.cakeName}</td>
								<td>${dto.o_customerId}</td>
								<td><fmt:formatNumber value="${dto.ordersSalePrice}"/></td>
								<td>${dto.ordersQuantity}</td>
								<td>${dto.ordersDate}</td>
							</tr>
						</tbody>
					</c:if>
					
					<c:if test = "${arrsize == 0 }">
						<h5>리뷰 작성 가능한 상품이 없습니다.</h5>
					</c:if>
				</c:forEach>
			</table>
		</form>
		
		<div align="center">
		<table>
			<tr align="center" height="20">
				<td>
					<c:if test="${arrsize != 0 }">
						<c:if test="${index <= 1}">
							[이전] &nbsp;
						</c:if>
					</c:if>
				
					<c:if test="${index != 1 }">
						<a href="customerOrderList.do?index=${index-1 }">이전</a>&nbsp;
					</c:if> 
			
					<c:forEach var="cnt" begin="${pagecount * pagepage + 1}" end="${pagecount * (pagepage + 1)}">
						<c:if test="${cnt <= Math.ceil(arrsize / rowcount)}">
						
							<c:if test="${cnt == index }">
								<a href="customerOrderList.do?index=${cnt }" style="font-size:1.3em">[${cnt }]</a>
							</c:if>
					
							<c:if test = "${cnt != index }">
								<a href="customerOrderList.do?index=${cnt }" style="font-size:0.9em">[${cnt }]</a>&nbsp;
							</c:if>
							
						</c:if>
					</c:forEach>
					
					<c:if test="${arrsize != 0 }">
						<c:if test="${index >= maxpage }">
							[다음]
						</c:if>
					</c:if>
					
					<c:if test="${index < Math.ceil(arrsize / rowcount)}">
						<a href="customerOrderList.do?index=${index+1 }">다음</a>&nbsp;
					</c:if>
					
				</td>
			</tr>
		</table>
	</div>
		
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>