<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="customerHeader.jsp"%>
</head>
<body>

	<main>
	
		<div class="row">
			
			<c:forEach items="${productList}" var="dto">
				<div class="col-lg-2 col-md-4">
					<div class="card" style="width: 14rem;">
					<a href="productDetail.do?productmodel=${dto.productmodel}">
						<img src="./productListImage/${dto.productmodel}.png" class="card-img-top"
							alt="${dto.productmodel}">
					</a>
						<div class="card-body">
							<p class="card-text" align="center">${dto.productbrand} ${dto.productmodel}</p>
							<p class="card-text" align="center">${dto.productprice}</p>
						</div>
					</div>
				</div>
			</c:forEach>
			
			<c:forEach items="${productListCategory}" var="dto">
				<div class="col-lg-2 col-md-4">
					<div class="card" style="width: 14rem;">
					<a href="productDetail.do?productmodel=${dto.productmodel}">
						<img src="./productListImage/${dto.productmodel}.png" class="card-img-top"
							alt="${dto.productmodel}" style="max-height:100">
					</a>
						<div class="card-body">
							<p class="card-text" align="center">${dto.productbrand} ${dto.productmodel}</p>
							<p class="card-text" align="center">${dto.productprice}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</main>

	<script src="/docs/5.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>