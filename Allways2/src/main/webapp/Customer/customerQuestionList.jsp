<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

<style>

#write_button {

	width: 115px;
	height: 45px;
	
	font-family: 'Baloo Tammudu 2';
	font-style: normal;
	font-weight: 700;
	font-size: 14px;
	line-height: 32px;
	align-items: center;
	text-align: center;
	
	color: #766262;
	width: 145px;
	height: 55px;
	
	background: #FBEAEA;
	border: 0.7px solid #000000;
	border-radius: 70px;

}

#search_button {

	box-sizing: border-box;
	width: 73px;
	height: 35px;
	font-family: 'Baloo Tammudu 2';
	font-style: normal;
	font-weight: 600;
	font-size: 14px;
	line-height: 32px;
	align-items: center;
	text-align: center;
	color: #766262;

	width: 60px;
	height: 25px;
	background: #FBEAEA;
	border: 0.7px solid #000000;
	border-radius: 30px;
}

#button_group {
	width: 115px;
	height: 45px;
	
	font-family: 'Baloo Tammudu 2';
	font-style: normal;
	font-weight: 700;
	font-size: 14px;
	line-height: 32px;
	align-items: center;
	text-align: center;
	
	color: #766262;

	width: 145px;
	height: 55px;
	
	background: #FFFFFF;
	border: 3px solid #FBEAEA;
	border-radius: 70px;
}
</style>

<script type="text/javascript">

function review() {
	var form = document.myform;
	form.method = "post";
	form.action = "customerOrdersReview.do";
}

function ordersList() {
	var form = document.myform;
	form.action = "customerOrdersList.do";
	form.submit();
}

function searchList() {
	var form = document.myform;
	form.action = "customerOrdersReview.do";
	form.submit();
}

</script>
	

</head>
<body>

<%@include file="customerHeader.jsp" %>
	
	<div align="center" style = "margin-top: 110px">
		<form name = "list" method = "post">
			<table>
				
				<tr>
					<td>
						<a href = "customerWriteList.do"><button type = "button" name = "buttons" id="button_group">BOARD</button></a>&nbsp;
					</td>
					<td>
						<a href = "customerOrdersReview.do"><button type = "button" name = "buttons" id="button_group" onclick = "reviewList();">REVIEW</button></a>&nbsp;
					</td>
					<td>
						<a href = "customerQuestionList.do"><button type = "button" name = "buttons" id="button_group" onclick = "QNA();">Q&A</button></a>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
	
	<div style = "margin-left: 250px; margin-top: 100px;">
		
		<form name = "myform" method = "post">
		
			<select style = "margin-left: 720px;" name = "combo">
				<option value = "or_customerId">작성자</option>
				<option value = "oreviewContent">내용</option>
			</select>
			
			<input type = "text" name = "searchContent" size = "20"> &nbsp;
			<button id="search_button" onclick = "searchList()">Search</button>
			
		</form>
	</div>
	
	<div align="center" class="container text-center">
		<form action = "" name = "list" method = "post">
			<table class="table">
				
				<thead>
					<tr>
						<th>No</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				
				<c:forEach var = "dto" items="${questionList }" begin="${(index - 1) * rowcount }" end="${(index) * rowcount - 1}">
					<c:if test="${dto != null }">
						<tbody>
							<tr>
								<td>${dto.rowNum }</td>
								<td><a href = "customerAnswerList.do?questionId=${dto.questionId }">${dto.questionTitle }</a></td>
								<td>${dto.q_customerId }</td>
								<td>${dto.questionInitdate }</td>
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
							<a href="customerQuestionList.do?index=${index-1 }">이전</a>&nbsp;
						</c:if> 
				
						<c:forEach var="cnt" begin="${pagecount * pagepage + 1}" end="${pagecount * (pagepage + 1)}">
							<c:if test="${cnt <= Math.ceil(arrsize / rowcount)}">
							
								<c:if test="${cnt == index }">
									<a href="customerQuestionList.do?index=${cnt }" style="font-size:1.3em">[${cnt }]</a>
								</c:if>
						
								<c:if test = "${cnt != index }">
									<a href="customerQuestionList.do?index=${cnt }" style="font-size:0.9em">[${cnt }]</a>&nbsp;
								</c:if>
								
							</c:if>
						</c:forEach>
				
						<c:if test="${index >= maxpage }">
							[다음]
						</c:if>
						
						<c:if test="${index < Math.ceil(arrsize / rowcount)}">
							<a href="customerQuestionList.do?index=${index+1 }">다음</a>&nbsp;
						</c:if>
						
					</td>
				</tr>
			</table>
		</div>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
</body>
</html>