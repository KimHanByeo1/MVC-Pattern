<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>옵션 추가</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="managerstyle.css">
<link rel="shortcut icon" href="./images/HeaderLogo2.png" sizes="180x180">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
<body>
<%@include file="managerHeader.jsp"%>
<script type="text/javascript">
var num = /^[0-9]*$/;
document.optionPrice;
function Return(){
		var add = document.add;
		add.action="return.do";
		add.submit();
		}
function CHECKOPTION(){
		var add = document.add;
		add.action="ONameCheck.do";
		add.submit();

}
function ADDOPTION() {
		var add = document.add;
			var num = /^[0-9]*$/;
			var pw=add.optionPrice.value;
			if(!num.test(pw)){
				swal("가격은 숫자만 입력 할 수 있습니다.",'','warning');
				return;
			}
		var Cek = add.ko.value;
		console.log(Cek);
		if(Cek == 1){
			add.action="addOption.do";
			add.method = "post";
			swal("추가가 완료되었습니다",'','success');
			add.submit();
			return;
		}else if(Cek == 2){
			swal("사용 불가능한 아이디 입니다.",'','warning');
			return;
		}else{
			swal("중복체크해주세요",'','warning');
			return;
		}
		
}
function previewFile() {
	  var preview = document.querySelector('img#preview');
	  var file = document.querySelector('input[type=file]').files[0];
	  var reader = new FileReader();

	  reader.addEventListener(
	    'load',
	    function () {
	      preview.src = reader.result;
	    },
	    false
	  );

	  if (file) {
	    reader.readAsDataURL(file);
	  }
	}
</script>


	<div align="center">
	<form method="post" enctype="multipart/form-data" name = "add">
			<h1 style="margin-bottom:3%;margin-top:3%"><b>옵션 관리</b></h1>
	<div style="display: inline-block;width:60%">
			<div align="left" style="width:20%;display:inline-block">
			카테고리 :
			</div>
		<div align="left" style="width:74%;display:inline-block">
			<div style="width:50%;display:inline-block">
				<select name="option" style="border-color:#fdcdcd">
					<option style="border-color:#fdcdcd" value="size">size</option>
					<option style="border-color:#fdcdcd" value="IcingColor">IcingColor</option>
					<option style="border-color:#fdcdcd" value="BorderColor">BorderColor</option>
					<option style="border-color:#fdcdcd" value="Flavor">Flavor</option>
					<option style="border-color:#fdcdcd" value="MassageColor">MassageColor</option>
					<option style="border-color:#fdcdcd" value="Box">Box</option>
				</select>
			</div>
		</div>
			<div align="left" style="width:20%;height:20%;display:inline-block">
				옵션 ID :
		</div>
			<div align="left" style="width:74%;height:20%;display:inline-block">
		<input type="text" name="optionId" placeholder="자동으로 입력 됩니다." size="20" readonly/>
			</div>
			<div align="left" style="width:20%;height:20%;display:inline-block">
				옵션 이름 :
		</div>
			<div align="left" style="width:74%;height:20%;display:inline-block">
			<input type="text" size="30" name="optionName" style="border-color:#fdcdcd" value="${optionName}" >
		<c:if test="${check == null }">
			<input type="hidden" name="ko" style="border-color:#fdcdcd" value="0"/></c:if>
		<c:if test="${check == true }"> 
				<span style = " font-size:1.0em;  color: red;"> 사용 불가능한 이름 입니다</span>
			<<input type="hidden" name="ko" style="border-color:#fdcdcd" value="2"/></c:if>
		<c:if test="${check == false }"> 
				<span style = " font-size:1.0em;  color:  blue;"> 사용 가능한 이름 입니다</span>
			<input type="hidden" name="ko" style="border-color:#fdcdcd" value="1"/></c:if>
			</div>
		<div align="left" style="width:20%;display:inline-block">
		가격 이름 :
		</div>
		<div align="left" style="width:74%;display:inline-block">
			<input type="text" name="optionPrice" style="border-color:#fdcdcd" value="${optionPrice}" >원
		</div><br>
		<div align="left" style="width:20%;display:inline-block">
			사진
			</div>
		<div align="left" style="width:74%;display:inline-block">	
			<input type="file" name="cakeoptionImage" onchange="previewFile(event)">
		</div>
	</div>
		<div style="display:inline-block;width:30%;height:50%" align="center">
			<div>
			사진 미리보기
			</div>
		<div>
			<img src="" id="preview" height="200" width="200" style="display:block;margin:20px;border-radius:10px;">
		</div>
		<div align="center" style="width:74%;display:inline-block">
			<input type="button" value="돌아가기" style="background:#ffffff;border-color:#a87878;color:#a87878" onclick="Return()">
			<input type="button" value="중복체크" style="background:#ffffff;border-color:#a87878;color:#a87878" onclick="CHECKOPTION()">
			<input type="button" value="추가" style="background:#ffffff;border-color:#a87878;color:#a87878" onclick="ADDOPTION()">
		</div>
		</div>
		
	</form>
	</div>
		

</body>
</html>