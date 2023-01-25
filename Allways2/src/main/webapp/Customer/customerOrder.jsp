<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Order</title>

<script type="text/javascript">

function order(index){
	var form = document.detail;
	if (index == 1) {
		form.action = "customerCartList.do";
	}
	if (index == 2) {
		form.action = "customerOrder.do";
		alert("Order complete.")
	}
		form.submit();
}

</script>

<%@include file="customerHeader.jsp"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@700&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<style type="text/css">
#page_name{
font-family: 'Baloo Tammudu 2';
font-style: normal;
font-weight: 700;
font-size: 50px;
line-height: 115px;
color: #E75151;
}

#line3{
width: 500px;
height: 0px;
border: 2px solid #FECACA;
}

#line4{
width: 400px;
height: 0px;
border: 2px solid #FECACA;
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

</style>
</head>
<body>

<br>
<div align="center">
	<h2 id="page_name">Order</h2>
</div>
<div align="center">
<hr id="line3"><br>
</div>

<div align="center">
<form action="" name ="detail" method="get">
	<table>
		<tr align="center">
			<th width="220px">An Optional Feature</th>
			<th width="100px">Quantity</th>
			<th width="120px">Price</th>
			<!-- <th width="120px">Date</th> -->
		</tr>
		<c:forEach items="${orderList}" var="dto">
		<tr align="center">
		<%-- <td><input type = "hidden" name = "ordersSize" value ="${ordersSize }"></td> --%>
			<td>${dto.cakeName }<input type="hidden" name="ordersId" value="${dto.ordersId}"><input type="hidden" name="cakeId" value="${dto.cakeId}"></td>
			<td>${dto.ordersQuantity }<input type="hidden" name="ordersQuantity" value="${dto.ordersQuantity }"></td>
			<td>￦ <fmt:formatNumber value="${dto.ordersSalePrice}"/><input type="hidden" name="ordersSalePrice" value="${dto.ordersSalePrice }"></td>
			<!-- <td>2022-11-11</td> -->
		</tr>
		</c:forEach>
		
		
		<c:forEach items="${cakeInfo}" var="dto">
		<tr align="center">
			<td>${dto.cakeName }</td>
			<td></td>
			<td>￦ <fmt:formatNumber value="${dto.cakePrice}"/><input type="hidden" name="ordersSalePrice" value="${dto.cakePrice }"></td>
			<!-- <td>2022-11-11</td> -->
		</tr>
		</c:forEach>
		
		
	</table>
</form>
</div><br>



<%-- <!--  수정 필요   -->
<div align="center">
	<c:forEach var = "dto" items="${optionList }">
		<tr align="center">
			<td>${dto.cakeoptionCategory }</td>
			<td>${dto.cakeoptionValue }</td>
			<td>${dto.cakeoptionPrice }</td>
			<td>${dto.detailoptionLettering }</td>
		</tr>
	</c:forEach>
</div>
<!--  수정 필요   --> --%>



<div align="center" style="padding-right: 190px;">
	<table>
	<c:forEach items="${customerInfo }" var="dto">
		<tr>
			<td width="150px;">Orderer Name</td>
			<td>${dto.customerName }</td>
		</tr>
		<tr>
			<td>Orderer Phone</td>
			<td>${dto.customerPhone }</td>
		</tr>
		<tr>
			<td>Orderer Email</td>
			<td>${dto.customerEmail }</td>
		</tr>
		<tr>
			<td>Orderer Address</td>
			<td>${dto.customerPostcode} ${dto.customerAddress} ${dto.customerAddressDetail}</td>
		</tr>
	</c:forEach>
	</table>
</div><br>


<div align="center" style="padding-right: 350px;">
	<table>
		<tr align="center">
			<td colspan="2">Payment Method</td>
		</tr>
		<tr>
			<td><input type="radio" name="payment"></td>
			<td>Credit Card</td>
		</tr>
		<tr>
			<td><input type="radio" name="payment"></td>
			<td>KakaoPay</td>
		</tr>
		<tr>
			<td><input type="radio" name="payment"></td>
			<td>NaverPay</td>
		</tr>
		<tr>
			<td><input type="radio" name="payment"></td>
			<td>PAYCO</td>
		</tr>
		<tr>
			<td><input type="radio" name="payment"></td>
			<td>Deposit</td>
		</tr>

	</table>
</div>

<div align="center" style="padding-left: 180px;">
	<table>
		<tr align="center">
			<td style="width: 150px;">
				Total Quantity
			</td>
			<c:set var ="total" value="0"/>
			<c:forEach var="result" items="${orderList }" varStatus="status">
				<c:set var="total" value="${total + result.ordersQuantity }"/>
			</c:forEach>
			<td><c:out value="${total }"/></td>
		</tr>
		<tr align="center">
			<td style="width: 150px;">
				Total Price
			</td>
			<c:set var ="total" value="0"/>
			<c:forEach var="result" items="${orderList }" varStatus="status">
				<c:set var="total" value="${total + result.ordersSalePrice }"/>
			</c:forEach>
			<td>￦ <fmt:formatNumber value="${total }"/></td>
		</tr>
		<tr align="center">
			<td colspan="2"><hr id="line4"></td>
		</tr>
		<tr align="center">
			<td><input id="util_box" type="button" value="Cancle" style="width: 150px;" onclick="order(1)"></td>
			<td><input id="util_box" type="button" value="Buy Now" style="width: 150px;" onclick="order(2)"></td>
		</tr>
	</table>
</div>

</body>
</html>