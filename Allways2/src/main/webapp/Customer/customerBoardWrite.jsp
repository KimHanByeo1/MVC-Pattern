<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰작성 페이지</title>

<link href="/assets/css/star.css" rel="stylesheet"/>
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

<script type="text/javascript">

function writeAction(){
	
	var form = document.myform;
	
	if(form.writeTitle.value.length == 0) {
		alert("제목을 작성하세요.");
		myform.writeTitle.focus();
		return;
	}
	
	if(form.writeContent.value.length == 0) {
		alert("게시글 내용을 작성하세요.");
		myform.writeContent.focus();
		return;
		
	}else {
		alert("게시글이 등록 되었습니다.");
		form.action = "customerBoardWrite.do";
		form.submit();
	}
	
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

	<form class="mb-3" name="myform" id="myform" method="post">
	
		<div align="center" style = "margin-top: 100px;">
			<table>
				<tr>
					<td><input type = "text" name = "writeTitle" size = "52" placeholder="게시글 제목"></td>
				</tr>
				<tr>
					<td><textarea rows="10" cols="50" name = "writeContent" placeholder="게시글 내용을 작성하세요."></textarea></td>
				</tr>
				<tr>
					<td align = "center"><button onclick="writeAction()" type = "button">Write</button></td>
				</tr>
			</table>
		</div>
		
			
	</form>

</body>
</html>