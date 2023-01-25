<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

<title>answer List</title>
</head>
<body>

<%@include file="customerHeader.jsp" %>
	
	<div align="center">
	
		<table>
			
			<tr>
				<td>
					작성자: ${answerList.a_managerId }
					&nbsp;
					작성날짜: ${answerList.answerInitdate }
				</td>
			</tr>

			<tr>
				<td><textarea rows="10" cols="40">${answerList.answerContent }</textarea></td>
			</tr>
			
		</table>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>