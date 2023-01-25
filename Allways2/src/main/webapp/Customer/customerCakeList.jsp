<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cake List</title>
<%@include file="customerHeader.jsp"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@700&display=swap" rel="stylesheet">
<style>

.select {
    padding: 15px 10px;
}
.select input[type=radio]{
    display: none;
}
.select input[type=radio]+label{
    display: inline-block;
    cursor: pointer;
    height: 24px;
    width: 90px;
    border: 1px solid #FBEAEA;
    line-height: 24px;
    text-align: center;
    font-weight:bold;
    font-size:13px;
	font-family: 'Baloo Tammudu 2';
	font-style: normal;
    color: #766262;
}
.select input[type=radio]+label{
    background-color: #fff;
    color: #333;
    border-radius: 70px;
}
.select input[type=radio]:checked+label{
    background-color: #FBEAEA;
    color: #333;
}

#cakeList{
font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 600;
font-size: 17px;
line-height: 32px;
text-align: center;
text-transform: capitalize;
color: #766262;
}

.dropdown-toggle::after {
    margin-top: 0px;
}

</style>

</head>
<body>

	<main>
	
		<div class="btn-group dropend" style="margin: 30px;">
		  <button type="button" class="btn btn-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
		    Sort
		  </button>
		  <ul class="dropdown-menu">
		  	<li><a class="dropdown-item" href="customerCakeList.do?sort1=cakePrice&sort2=asc&index=${index }">Price Row - High</a></li>
		    <li><a class="dropdown-item" href="customerCakeList.do?sort1=cakePrice&sort2=desc&index=${index }">Price High - Row</a></li>
		    <li><a class="dropdown-item" href="customerCakeList.do?sort1=cakeLike&sort2=desc&index=${index }">Likes</a></li>
		    <li><a class="dropdown-item" href="customerCakeList.do?sort1=cakeViews&sort2=desc&index=${index }">Views</a></li>
		  </ul>
		</div>

		<div class="row" style="padding-left: 35px; margin-right: 0px;">
			
			<c:forEach items="${cakeList}" var="dto" begin="${(index - 1) * rowcount }" end="${(index) * rowcount - 1}">
				<div class="col-lg-3 col-md-6" style="padding-bottom: 20px;" id="cakeList">
					<div class="card" style="width: 20rem;">
					<a href="customerCakeDetail.do?cakeId=${dto.cakeId}">
						<img src="./cakeListImage/${dto.cakeImage}" class="card-img-top"
							alt="${dto.cakeId}">
					</a>
						<div class="card-body">
							<table>
								<tr>
									<td align="left" width="170px">${dto.cakeName}</td><td align="right" width="120px">￦ <fmt:formatNumber value="${dto.cakePrice}"/></td>
								</tr>
								<tr>
									<td align="left">&hearts; ${dto.cakeLike}</td><td align="right">Views ${dto.cakeViews}</td>
								</tr>
							</table> 						
						</div>
					</div>
				</div>
			</c:forEach>
			
			
		</div>

	</main>
	
	<div align="center">
			<table>
				<tr align="center" height="20">
					<td>
					
						<c:if test="${index <= 1}">
							[이전] &nbsp;
						</c:if>
					
						<c:if test="${index != 1 }">
							<a href="customerCakeList.do?index=${index-1 }&sort1=${sort1}&sort2=${sort2}">이전</a>&nbsp;
						</c:if> 
				
						<c:forEach var="cnt" begin="${pagecount * pagepage + 1}" end="${pagecount * (pagepage + 1)}">
							<c:if test="${cnt <= Math.ceil(arrsize / rowcount)}">
							
								<c:if test="${cnt == index }">
									<a href="customerCakeList.do?index=${cnt }&sort1=${sort1}&sort2=${sort2}" style="font-size:1.3em">[${cnt }]</a>
								</c:if>
						
								<c:if test = "${cnt != index }">
									<a href="customerCakeList.do?index=${cnt }&sort1=${sort1}&sort2=${sort2}" style="font-size:0.9em">[${cnt }]</a>&nbsp;
								</c:if>
								
							</c:if>
						</c:forEach>
				
						<c:if test="${index >= maxpage }">
							[다음]
						</c:if>
						
						<c:if test="${index < Math.ceil(arrsize / rowcount)}">
							<a href="customerCakeList.do?index=${index+1 }&sort1=${sort1}&sort2=${sort2}">다음</a>&nbsp;
						</c:if>
						
					</td>
				</tr>
			</table>
		</div>

	<script src="/docs/5.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>