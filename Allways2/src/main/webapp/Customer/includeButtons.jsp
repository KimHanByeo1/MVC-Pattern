<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
crossorigin="anonymous">


<style>

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

</head>
<body>

<script type="text/javascript">

function reviewList() {
	var form = document.list;
	form.action = "customerOrdersReview.do";
	form.submit();
}

function board() {
	var form = document.list;
	form.action = "customerWriteList.do";
	form.submit();
}

function QNA() {
	var form = document.list;
	form.action = "customerQuestionList.do";
	form.submit();
}

</script>

	<div align="center" style = "margin-top: 110px">
		<form name = "list" method = "post">
			<table>
				
				<tr>
					<td>
						<button type = "button" name = "buttons" id="button_group" onclick = "board();">BOARD</button>&nbsp;
					</td>
					<td>
						<button type = "button" name = "buttons" id="button_group" onclick = "reviewList();">REVIEW</button>&nbsp;
					</td>
					<td>
						<button type = "button" name = "buttons" id="button_group">FAQ</button>&nbsp;
					</td>
					<td>
						<button type = "button" name = "buttons" id="button_group" onclick = "QNA();">Q&A</button>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
crossorigin="anonymous"></script>
