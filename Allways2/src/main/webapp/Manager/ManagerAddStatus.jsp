<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="managerHeader.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" href="css/Table22.css">

<script>

	function Return(){
		var RET = document.ADDR;
		RET.action = "MorderStatus.do";
		RET.method = "post";
		RET.submit();
	}

		function Delete2() {
			var DEL = document.ADDR;
			DEL.action = "DeleteOrder.do";
			DEL.method = "post";
			DEL.submit();
		}
	</script>
</head>
<body>
<h1>주문 상태 변환</h1>
	<form method="post" action="ADDR.do" name = "ADDR">
	<table border="0">
<thead>
	<tr>
	<td>
	<tr>
		<th>주문 번호 :
		<input type="text" name=ordersId value="${add_Order.ordersId}" readonly/>
		</th>
	</tr>
	
	<tr>
		<th>
	주문 상태 :
	<select name="ordersStatus">
		<option value="구매">구매</option>
		<option value="제작중">제작중</option>
		<option value="제작완료">제작완료</option>
	</select></th>
	</tr>
	<tr>
		<th>구매자 :
		<input type="text" name="o_customerId" value="${add_Order.o_customerId}" readonly="readonly" >
		</th>
	</tr>
	
	<tr>
		<th>케이크번호 :
		<input type="text" name="o_cakeId" value="${add_Order.o_cakeId}" readonly="readonly">
		</th>
	</tr>
	<tr>
		<th>케이크이름 :
		<input type="text" name="cakeName" value="${add_Order.cakeName}" readonly="readonly">
		</th>
	</tr>
	
	<tr>
		<th>추가상품번호:
		<input type="text" name="o_goodsId" value="${add_Order.o_goodsId}" readonly="readonly">
		</th>
	</tr>
	<tr>
		<th>추가상품이름:
		<input type="text" name="goodsName" value="${add_Order.goodsName}" readonly="readonly">
		</th>
	</tr>
	
	<tr>
		<th>주문가격 :
		<input type="text" name="ordersSalePrice" value="${add_Order.ordersSalePrice}" readonly="readonly">
		</th>
	</tr>
	<tr>
		<th>주문개수 :
		<input type="text" name="ordersQuantity" value="${add_Order.ordersQuantity}" readonly="readonly">
		</th>
	</tr>
	<tr>
		<th>포인트 :
		<input type="text" name="ordersPoint" value="${add_Order.ordersPoint}" readonly="readonly">
		</th>
	</tr>
	<tr>
		<th>
			<input type="button" value="돌아가기" onclick="Return()">
			<input type="button" value="수정" onclick="Update()">
			<input type="button" value="삭제" onclick="Delete()">
			<input type="submit" value="추가">
		</th>
	</tr>
	</table>
		
	</form>
</body>
</html>