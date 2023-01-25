<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<title>${cakeInfo.cakeName}</title>
<head>

<script type="text/javascript">
	function login() {
		alert('Available after login.');
		var form = document.detail;
		form.action = "customerLoginPage.do";
		form.submit();
	}

	function mySubmit(index) {
		var form = document.detail;

		if (index == 1) {
			if (form.detailoptionPickupDate.value.length == 0) {
				alert("Please choose a pickup date.")
				return;
			}
			if (form.shape.value.length == 0) {
				alert("Please choose a shape.");
				return;
			}
			if (form.size.value.length == 0) {
				alert("Please choose a size.");
				return;
			}
			if (form.detailoptionLettering.value.length == 0) {
				alert("Please enter a phrase.");
				return;
			}
			if (form.detailoptionLettering.value.length > 30) {
				alert("30 Char.Max.");
				return;
			}
			if (form.ordersQuantity.value == 0) {
				alert("Please select a quantity.");
				return;
			}
			if (form.ordersQuantity.value > 10) {
				alert("You can order up to 10.");
				return;
			}
			alert("set in cartlist.");
			form.action = "customerCakeCart.do";
		}
		if (index == 2) {
			if (form.detailoptionPickupDate.value.length == 0) {
				alert("Please choose a pickup date.")
				return;
			}
			if (form.shape.value.length == 0) {
				alert("Please choose a shape.");
				return;
			}
			if (form.size.value.length == 0) {
				alert("Please choose a size.");
				return;
			}
			if (form.detailoptionLettering.value.length == 0) {
				alert("Please enter a phrase.");
				return;
			}
			if (form.detailoptionLettering.value.length > 30) {
				alert("30 Char.Max.");
				return;
			}
			if (form.ordersQuantity.value == 0) {
				alert("Please select a quantity.");
				return;
			}
			form.action = "customerCakeQuickOrder.do";
		}
		form.submit();
	}
	
	
	const input  = document.getElementById('input');
	const kern   = document.getElementById('kern');
	const nokern = document.getElementById('nokern');

	input.addEventListener('keyup', () => {
	  kern.textContent = input.value; /* Update content */
	  nokern.textContent = input.value;
	});

	kern.textContent = input.value; /* Initialize content */
	nokern.textContent = input.value;
	
	function printQuantity()  {
  	  const name = document.getElementById('quantity').value;
  	  document.getElementById("result").innerText = name;
  	}
	
</script>

<%@include file="customerHeader.jsp"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@700&display=swap" rel="stylesheet">

<style type="text/css">

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
    color: #766262;
    border-radius: 70px;
}
.select input[type=radio]:checked+label{
    background-color: #FBEAEA;
    color: #766262;
}

#cake_name{
font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 600;
font-size: 35px;
line-height: 45px;
text-transform: capitalize;

color: #766262;
}

#cake_option{
font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 600;
font-size: 25px;
line-height: 25px;
text-transform: capitalize;

color: #766262;
}

#cake_detail{
font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 600;
font-size: 20px;
line-height: 20px;
text-transform: capitalize;

color: #766262;
}

#line{
width: 600px;
height: 0px;
border: 2px solid #FECACA;
}

#line2{
width: 650px;
height: 0px;
border: 2px solid #FECACA;
}

#line4{
width: 400px;
height: 0px;
border: 2px solid #FECACA;
}

#lettering {
background: #FFFFFF; 
border: 2px solid #FBEAEA; 
width: 380px;
height: 35px;
margin-bottom: 10px;

font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 400;
font-size: 15px;
line-height: 15px;
text-transform: capitalize;
align-items: center;
color: #766262;
	}

#quantity {
background: #FFFFFF; 
border: 2px solid #FBEAEA; 
width: 50px;
height: 30px;
margin-bottom: 10px;

font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 400;
font-size: 15px;
line-height: 15px;
text-transform: capitalize;
align-items: center;
color: #766262;
	}

#option_price{
font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 400;
font-size: 15px;
line-height: 15px;
text-transform: capitalize;
align-items: center;
color: #766262;
}

#checkout_box{
width: 621px;
height: 55px;

background: #FBEAEA;
border: 1px solid #FBEAEA;
}

#guidebox{
width: 562px;
height: 53px;

background: #FBEAEA;
border: 1px solid #FBEAEA;
border-radius: 70px;
}

#guidedetailbox{
width: 300px;
height: 30px;
background: #FBEAEA;
border: 1px solid #FBEAEA;
border-radius: 70px;

font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 600;
font-size: 20px;
line-height: 20px;
text-transform: capitalize;
align-items: center;
color: #766262;
}

#util_box{
width: 160px;
height: 41.63px;
background: #EF8C8C;
border: 2px solid #EF8C8C;

font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 700;
font-size: 24px;
line-height: 50px;
align-items: center;
text-align: center;
text-transform: capitalize;
color: #FFFDFD;
}

#checkout_box{
width: 400px;
height: 41.63px;
background: #EF8C8C;
border: 2px solid #EF8C8C;

font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 700;
font-size: 24px;
line-height: 50px;
align-items: center;
text-align: center;
text-transform: capitalize;
color: #FFFDFD;
}
</style>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>

		<div class="row">
			<div class="col" align="center">
			<br>
				<div>
					<img alt="" src="./cakeListImage/${cakeInfo.cakeImage}" width="500px">
				</div>
				<div align="center">
					<hr id="line2">
				</div>
				<div>
					<input id="guidedetailbox" value="Cake Detail" disabled="disabled"
						style="padding-left: 100px; padding-top: 10px;">
				</div><br>
				<div id="cake_detail" align="left" style="margin-left: 60px;">
					${cakeInfo.cakeDetail }
				</div>
			</div>
			
		<form action="" style="width: 768px;" name="detail" method = "get">
			<div class="col" style="width: 768px;"><br><input type="hidden" name="cakeId" value="${cakeInfo.cakeId }">
				<div id="cake_name" align="left"><input type="hidden" name="cakeName" value="${cakeInfo.cakeName }">
					${cakeInfo.cakeName }
				</div>
				<div id="cake_name" align="left"><input type="hidden" name="cakePrice" value="${cakeInfo.cakePrice }">
					￦ <fmt:formatNumber value="${cakeInfo.cakePrice}"/>
				</div>
				<div>
					<hr id="line4">
				</div>
				
				 <div id="cake_option" align="left">
				Pickup Date
				</div>
				<div id="cake_option" align="left">
				</div>
				<div align="left">
					 <input type="date" id="Date" name="detailoptionPickupDate" ><br><br>
				</div>
				
				
				
				<div id="cake_option" align="left">
				Shape
				</div>
				
				<div class="select" align="left">
					<table>
						<tr align="center">
							<c:forEach var="dto" items="${shapeList}">
								<td>
									<c:set var="i" value="${i+1 }"/>
										<input type="radio" id="shape${i}" name="shape" value="${dto.cakeoptionId}"><label for="shape${i}">${dto.cakeoptionValue}</label>
										&nbsp;
								</td>
							</c:forEach>
						</tr>
						<tr align="center">
							<c:forEach var="dto" items="${shapeList }">
								<td>
									<c:if test="${dto.cakeoptionPrice ne 0 }">
										<label id="option_price">
										+ ￦ <fmt:formatNumber value="${dto.cakeoptionPrice}"/>
										</label>&nbsp;
										<input type = "hidden" name="shapePrice" value="${dto.cakeoptionPrice }">
									</c:if>						
								</td>
							</c:forEach>
						</tr>
					</table>
				</div>
				
			
				<div id="cake_option" align="left">
					Size
				</div>
				
				<div class="select" align="left">
					<table>
						<tr align="center">
							<c:forEach var="dto" items="${sizeList}">
								<td>
									<c:set var="i" value="${i+1 }"/>
										<input type="radio" id="size${i}" name="size" value="${dto.cakeoptionId}"><label for="size${i}">${dto.cakeoptionValue}</label>
										&nbsp;
								</td>
							</c:forEach>
						</tr>	
						<tr align="center">
							<c:forEach var="dto" items="${sizeList }">
								<td>
									<c:if test="${dto.cakeoptionPrice ne 0 }">
										<label id="option_price">
										+ ￦ <fmt:formatNumber value="${dto.cakeoptionPrice}"/>
										</label>
										<input type = "hidden" name="sizePrice" value="${dto.cakeoptionPrice }">
									</c:if>
								</td>
							</c:forEach>
						</tr>
					</table>
				</div>
			
				<div id="cake_option" align="left">
					Flavor
				</div>
				
				<div class="select" align="left">
					<table>
						<tr align="center">
							<c:forEach var="dto" items="${flavorList}">
								<td>
									<c:set var="i" value="${i+1 }"/>
										<input type="radio" id="flavor${i}" name="flavor" value="${dto.cakeoptionId}"><label for="flavor${i}">${dto.cakeoptionValue}</label>
										&nbsp;
								</td>
							</c:forEach>
						</tr>	
						<tr align="center">
							<c:forEach var="dto" items="${flavorList }">
								<td>
									<c:if test="${dto.cakeoptionPrice ne 0 }">
										<label id="option_price">
										+ ￦ <fmt:formatNumber value="${dto.cakeoptionPrice}"/>
										</label>
										<input type = "hidden" name="flavorPrice" value="${dto.cakeoptionPrice }">
									</c:if>
								</td>
							</c:forEach>
						</tr>
					</table>
				</div>
			
				<div id="cake_option" align="left">
					Lettering
				</div>
				
				<div align="left">
					<input type="text" id="lettering" name = "detailoptionLettering" placeholder="Handwritten In Icing. 30 Char. Max." style="padding-top: 8px;">
				</div><br>
				
				<div id="cake_option" align="left">
					Quantity
				</div>
				<div align="left">
					<input type="number" id="quantity" min="0" max="50" name ="ordersQuantity" placeholder="0" value="quantity" onchange = "printQuantity()">
				</div>
				
				<hr id="line4">
				
				<div align="left" id="cake_option">
					<table>
						 <tr align="center">
							<td style="width: 150px;">
								Total Quantity
							</td>
							<td style="width: 50px;">
								<div id='result'>0</div>
							</td>
						</tr>
						<tr align="center">
							<td style="width: 150px;" height="50px">
								Total Price
							</td>
							<td style="width: 100px;">￦ <fmt:formatNumber
									value="${cakeInfo.cakePrice}" /> 
						</tr>
						<tr align="center">
							<td colspan="2"><hr id="line4"></td>
						</tr>
						<tr align="center">
						<c:choose>
							<c:when test="${ID != null }">
								<td><button type = "button" id="util_box" onclick = "mySubmit(1)">Cart</button></td>
								<td><button type = "button" id="util_box" onclick = "mySubmit(2)">Buy Now</button></td>
							</c:when>
							<c:otherwise>
								<td><button type = "button" id="util_box" onclick = "login()">Cart</button></td>
								<td><button type = "button" id="util_box" onclick = "login()">Buy Now</button></td>
							</c:otherwise>
						</c:choose>
						</tr>
					</table>
				</div>
			</div>
			</form>
			
		</div>
		
<div align="center">
<hr id="line"><br>
</div>

<div align="center">
	<input id="guidedetailbox" value="Review" disabled="disabled"
		style="padding-left: 115px; padding-top: 10px;">
</div><br>

<!--  -->

  <div align="center" class="container text-center">
		<form action = "" name = "list" method = "post">
			<table class="table">
				
				<thead>
					<tr>
						<th>No</th>
						<th>내용</th>
						<th>별점</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				
		<c:forEach var = "dto" items="${reviewList }" begin="${(index - 1) * rowcount }" end="${(index) * rowcount - 1}">
			<c:if test="${dto != null }">
				<tbody>
					<tr>
						<td>${dto.rowNum }</td>
						<td>${dto.oreviewContent }</td>
						<td>
							<c:forEach begin = "1" end = "${dto.oreviewStarrating }">
								<label>★</label>
							</c:forEach>
						</td>
						<td>${dto.or_customerId }</td>
						<td>${dto.oreviewInitdate }</td>
					</tr>
				</tbody>
			</c:if>
		</c:forEach>
				
			</table>
		</form>
		
	<div align="center">
		<table>
			<tr align="center" height="20">
				<td>
				
					<c:if test="${index <= 1}">
						[이전] &nbsp;
					</c:if>
				
					<c:if test="${index != 1 }">
						<a href="customerCakeDetail.do?index=${index-1 }">이전</a>&nbsp;
					</c:if> 
			
					<c:forEach var="cnt" begin="${pagecount * pagepage + 1}" end="${pagecount * (pagepage + 1)}">
						<c:if test="${cnt <= Math.ceil(arrsize / rowcount)}">
						
							<c:if test="${cnt == index }">
								<a href="customerOrdersReview.do?index=${cnt }" style="font-size:1.3em">[${cnt }]</a>
							</c:if>
					
							<c:if test = "${cnt != index }">
								<a href="customerOrdersReview.do?index=${cnt }" style="font-size:0.9em">[${cnt }]</a>&nbsp;
							</c:if>
							
						</c:if>
					</c:forEach>
			
					<c:if test="${index >= maxpage }">
						[다음]
					</c:if>
					
					<c:if test="${index < Math.ceil(arrsize / rowcount)}">
						<a href="customerCakeDetail.do?index=${index+1 }">다음</a>&nbsp;
					</c:if>
					
				</td>
			</tr>
		</table>
	</div>
	</div>
	
	<!--  -->

	<script src="/docs/5.2/dist/js/bootstrap.bundle.min.js"
integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
crossorigin="anonymous"></script>
</body>
</html>