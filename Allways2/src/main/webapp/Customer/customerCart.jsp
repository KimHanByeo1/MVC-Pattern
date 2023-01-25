<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Cart</title>

<script type="text/javascript">

function mySubmit(index){
	var form = document.orderform;
	if (index == 1) {
		form.action = "customerCartSelectDelete.do";
	}
	if (index == 2) {
		form.action = "customerCakeList.do";
	}
	if (index == 3) {
		form.action = "customerOrderPage.do";
	}
		form.submit();
}

let basket = {
	    totalCount: 0, 
	    totalPrice: 0,
	    //체크한 장바구니 상품 비우기
	    delCheckedItem: function(){
	        document.querySelectorAll("input[name=buy]:checked").forEach(function (item) {
	            item.parentElement.parentElement.parentElement.remove();
	        });
	        //AJAX 서버 업데이트 전송
	    
	        //전송 처리 결과가 성공이면
	        this.reCalc();
	        this.updateUI();
	    },
	    //재계산
	    reCalc: function(){
	        this.totalCount = 0;
	        this.totalPrice = 0;
	        document.querySelectorAll(".p_num").forEach(function (item) {
	            if(item.parentElement.parentElement.parentElement.previousElementSibling.firstElementChild.firstElementChild.checked == true){
	                var count = parseInt(item.getAttribute('value'));
	                this.totalCount += count;
	                var price = item.parentElement.parentElement.previousElementSibling.firstElementChild.getAttribute('value');
	                this.totalPrice += 1 * price;
	            }
	        }, this); // forEach 2번째 파라메터로 객체를 넘겨서 this 가 객체리터럴을 가리키도록 함. - thisArg
	    },
	    //화면 업데이트
	    updateUI: function () {
	        document.querySelector('#sum_p_num').textContent = 'Total Quantity : ' + this.totalCount.formatNumber();
	        document.querySelector('#sum_p_price').textContent = 'Total Price: ' + this.totalPrice.formatNumber();
	    },
	    //개별 수량 변경
	    checkItem: function () {
	        this.reCalc();
	        this.updateUI();
	    },
	    delItem: function () {
	        event.target.parentElement.parentElement.parentElement.remove();
	        this.reCalc();
	        this.updateUI();
	    }
	}

	// 숫자 3자리 콤마찍기
	Number.prototype.formatNumber = function(){
	    if(this==0) return 0;
	    let regex = /(^[+-]?\d+)(\d{3})/;
	    let nstr = (this + '');
	    while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
	    return nstr;
	};

</script>

<%@include file="customerHeader.jsp"%>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./CSS/cart.css" />
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

#delete_box{
width: 136.55px;
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
	<h2 id="page_name">Cart</h2>
</div>
<div align="center">
<hr id="line3"><br>
</div>
<%-- 
<div align="center">

<form action="" name ="detail" method="get">

	<table>
		<tr align="center">
			<th width="50px">cb</th>
			<th width="350px">An Optional Feature</th>
			<th width="100px">Quantity</th>
			<th width="120px">Price</th>
			<th>Delete</th>
		</tr>
		
	<c:forEach var = "dto" items="${cartList }">
	
		<tr align="center">
			<td><input type="checkbox" name="ordersId" value="${dto.ordersId }" id="chk"></td>
			<td>${dto.cakeName }</td>
			<td>${dto.ordersQuantity }</td>
			<td>￦ <fmt:formatNumber value="${dto.ordersSalePrice}"/></td>
			<td><a href="/Allways/Customer/customerCartDelete.do?ordersId=${dto.ordersId }">X</a></td>
		</tr>
		
	</c:forEach>
	
	<tr align="center"><td colspan="5"><hr id="line3"><br></td></tr>
				<tr align="center">
			<td><button type = "button" id="util_box" onclick = "mySubmit(1)">Delete</button></td>
			<td colspan="3"><button type = "button" id="util_box" onclick = "mySubmit(2)">Go Shopping</button></td>
			<td><button type = "button" id="util_box" onclick = "mySubmit(3)">Buy Now</button></td>
		</tr>
	</table>
</form>
</div><br>
	 --%>
<div align="center">

 	<form name="orderform" id="orderform" method="post" class="orderform"
		action="/Page" onsubmit="return false;">
		<input type="hidden" value="order">
		<div id="basket" class="basketdiv">
		<div class="row head">
				<div class="subdiv">
					<div class="check">Check</div>
					<div class="pname">An Optional Feature</div>
				</div>
				<div class="subdiv">
					<div class="basketprice">Price</div>
					<div class="num">Quantity</div>
					<div class="basketcmd">Delete</div>
				</div>
				 <div class="split"></div>
				</div>
		<c:forEach var = "dto" items="${cartList }">
			<div class="row data" align="center">
				<div class="subdiv">
					<div class="check"><input type="checkbox" name="ordersId" value="${dto.ordersId }" onclick="javascript:basket.checkItem();">&nbsp;</div>
					<div class="pname" style="padding-top: 24px;"><span>${dto.cakeName }</span></div>
				</div>
				<div class="subdiv">
					<div class="basketprice"><input type="hidden" id="p_price2" class="p_price" value=${dto.ordersSalePrice }>${dto.ordersSalePrice }</div>
					<div class="num">
					<c:set var="i" value="${i+1 }"/>
					<div><input type="text" id="p_num2" class="p_num" size="2" maxlength="4" value="${dto.ordersQuantity }" onkeyup="javascript:basket.changePNum(${i});" style="padding-top: 7px;"></div>
					</div>
					<div class="subdiv">
					<div><a href="/Allways/Customer/customerCartDelete.do?ordersId=${dto.ordersId}" onclick="javascript:basket.delItem();" style="margin-left: 45px;">X</a></div>
					</div>
				</div>
			</div>
		</c:forEach>

		</div>

		<div class="bigtext right-align sumcount" id="sum_p_num">Total Quantity :</div>
		<div class="bigtext right-align box blue summoney" id="sum_p_price">Total Price :</div>
		<button type = "button" id="util_box" onclick = "mySubmit(1)">Delete</button>
		<button type = "button" id="util_box" onclick = "mySubmit(2)" style="margin-left: 100px; margin-right: 100px;">Go Shopping</button>
		<button type = "button" id="util_box" onclick = "mySubmit(3)">Buy Now</button>
		
	</form> 
</div>

</body>
</html>