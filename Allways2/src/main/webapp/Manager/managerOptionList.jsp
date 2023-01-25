<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>옵션</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="managerstyle.css">
<link rel="shortcut icon" href="./images/HeaderLogo2.png" sizes="180x180">
<link rel="stylesheet" href="css/Table22.css">
<style>
div{
	padding:1%;
}

input[type=file]::file-selector-button{
	background-color:#ffffff;
	border-color:#fdcdcd;
	border-radius:10px;
	hover:{
		background:#fdcdcd;
	}
}
</style>
</head>
<body >
<%@include file="managerHeader.jsp"%>
<script type="text/javascript">
function SELECT1() {
	var Olist = document.Olist;
	Olist.action="Mselect.do";
	Olist.submit();
	
}
function Addoption(){
		var Olist = document.Olist;
		Olist.action="addList.do";
		Olist.submit();
		}
		
</script>
<div style="text-align:center"><hr/><h1>옵션</h1><hr/></div>

<div align="center">
<form name="Olist" method="post" >
	<select name="option" style="background:#ffffff;border-color:#a87878;color:#a87878">
		<option value="">검색 유형</option>
		<option value="cakeoptionId">번호</option>
		<option value="cakeoptionCategory">카테고리</option>
		<option value="cakeoptionValue">옵션</option>
		<option value="cakeoptionPrice">가격</option>
	</select>
	<script type="text/javascript">
	const param__option = '${param.option}';
	if(param__option) {
		$('select[name="param__option"]').val('${param__option}');
	}
	</script>
	<input type="hidden" style="border-color:#FDCDCD" name ="boardId" value="${param.boardId }"/>
<input value="${param.Query }" style="border-color:#FDCDCD" type="text" name="Query" size="30">
<input type="button" style="background:#ffffff;border-color:#a87878;color:#a87878" name="Select" value="검색" onclick="SELECT1()">
<input type="button" style="background:#ffffff;border-color:#a87878;color:#a87878" name="add" value="추가" onclick="Addoption()" >
총 ${Size}건
<div class="tablediv" >
	<table  border="1" >
	<thead align="center">
		<tr>
			<th>번호</th>
			<th>카테고리</th>
			<th>옵션</th>
			<th>가격</th>
		</tr>	
			<c:forEach items = "${OptionList}" var = "dto" begin="${(index-1)*rowcount }" end="${(index)*rowcount-1}">
			
		<tr>
			<td><a href="optionId.do?cakeoptionId=${dto.cakeoptionId}" class="tablebutton">${dto.cakeoptionId}</a></td>
			<td>${dto.cakeoptionCategory}</td>
			<td>${dto.cakeoptionValue}</td>
			<td><fmt:formatNumber value="${dto.cakeoptionPrice}" type="currency"/></td>
		</tr>
			</c:forEach>
			</thead>
</table>
</div>
<c:if test="${Query==null }">
	<div class="tablediv" align="center">
		<a href="Mlist.do?index=1">처음으로</a>
		<c:if test="${index!=1 }">
			<a href="Mlist.do?index=${index-1 }">이전</a>
		</c:if>
		<c:forEach var="dto" begin="${pagecount*pagepage+1}" end="${pagecount*(pagepage+1) }">
			<c:if test="${dto<=Math.ceil(Size/rowcount) }">
				<c:if test="${dto==index }">
					<span style="display:inline">
						<a href="Mlist.do?index=${dto }" style="font-size:1.3em">${dto }</a>
					</span>
				</c:if>
				<c:if test="${dto!=index }">
					<a href="Mlist.do?index=${dto }" style="font-size:0.9em">${dto }</a>
				</c:if>
			</c:if>
		</c:forEach>
		<c:if test="${index<Math.ceil(Size/rowcount) }">
			<a href="Mlist.do?index=${index+1 }">다음</a>
		</c:if>
		<a href="Mlist.do?index=${Math.ceil(Size/rowcount) }">끝으로</a>
	</div>
	</c:if>
	
	<c:if test="${Query!=null }">
	<div class="tablediv" align="center">
		<a href="Mselect.do?index=1&query=${Query}">처음으로</a>
		<c:if test="${index!=1 }">
			<a href="Mselect.do?index=${index-1 }&query=${Query}">이전</a>
		</c:if>
		<c:forEach var="cnt" begin="${pagecount*pagepage+1}" end="${pagecount*(pagepage+1) }">
			<c:if test="${cnt<=Math.ceil(Size/rowcount) }">
				<c:if test="${cnt==index }">
					<span style="display:inline">
						<a href="Mselect.do?index=${cnt }&query=${Query}" style="font-size:1.3em">${cnt }</a>
					</span>
				</c:if>
				<c:if test="${cnt!=index }">
					<a href="Mselect.do?index=${cnt }&query=${Query}" style="font-size:0.9em">${cnt }</a>
				</c:if>
			</c:if>
		</c:forEach>
		<c:if test="${index<Math.ceil(Size/rowcount) }">
			<a href="Mselect.do?index=${index+1 }&query=${Query}">다음</a>
		</c:if>
		<a href="Mselect.do?index=${Math.ceil(Size/rowcount) }&query=${Query}">끝으로</a>
	</div>
	</c:if>
</form>
</div>
</body>
</html>