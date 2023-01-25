<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가상품 관리</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="managerstyle.css">
<link rel="shortcut icon" href="./images/HeaderLogo2.png" sizes="180x180">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
<script>
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
	
	function submitDo(){
		var form=document.actionForm;
		console.log(form.checkName.value);
		if (form.checkName.value=="true"){
			swal("추가가 완료되었습니다",'','success');
			form.submit();
		} else{
			swal("이름 중복체크를 해 주세요.",'','warning');
			return;
		}
	}
	
	function nameCheck(){
		var form=document.actionForm;
		if (form.goodsName.value==""){
			swal("추가상품 이름을 입력하세요",'','success');
			return;
		} else{
			form.action="checkGoodsName2.do";
			form.submit();
		}
	}
	function cancelDo(){
		var form=document.actionForm;
		form.action="searchGoods.do";
		form.submit();
	}
	
	function updateDo(){
		var form=document.actionForm;
		if (form.check.value==false){
			swal("이름 중복체크를 해주세요.",'','warning');
			return;
		}
		form.action="updateGoods.do";
		swal("수정이 완료되었습니다",'','success');
		form.submit();
	}
	
	function deleteDo(){
		var form=document.actionForm;
		form.action="deleteGoods.do";
		swal("삭제가 완료되었습니다",'','success');
		form.submit();
	}
</script>
</head>
<body>
<%@include file="managerHeader.jsp"%>
<div align="center">
<form action="addGoods.do" method="post" enctype="multipart/form-data" name="actionForm">
	<input type="hidden" name="index" value="${index }">
	<h1 style="margin-bottom:3%;margin-top:3%"><b>추가상품 관리</b></h1>
	<div style="display: inline-block;width:60%">
		<div align="left" style="width:20%;display:inline-block">
			추가상품 이름
		</div>
		<div align="left" style="width:74%;display:inline-block">
			<div style="width:50%;display:inline-block">
				<input type="hidden" name="check" value="${check }">
				<input type="hidden" name="goodsOriginalName" value="${goodsOriginalName }">
				<c:if test="${check==null }">
					<input type="text" name="goodsName" class="form-control" style="border-color:#fdcdcd" value="${goodsName }">
				</c:if>
				<c:if test="${check==true }">
					<script>swal("사용 가능한 이름입니다.",'','success');</script>
					<input type="text" name="goodsName" class="form-control is-valid" style="border-color:#fdcdcd" value="${goodsName }">
				</c:if>
				<c:if test="${check==false }">
					<script>swal("이미 사용중인 이름입니다.",'','warning');</script>
					<input type="text" name="goodsName" class="form-control is-invalid" style="border-color:#fdcdcd" value="${goodsName }">
				</c:if>
			</div>
			<div style="display:inline-block">
				<input type="button" class="btn" style="background:#ffffff;border-color:#a87878;color:#a87878" value="중복체크" onclick="nameCheck()">
			</div>
		</div>
		<div align="left" style="width:20%;display:inline-block">
			카테고리
		</div>
		<div align="left" style="width:74%;display:inline-block">
			<div style="width:30%;display:inline-block">
				<select name="goodsCategory" style="border-color:#fdcdcd;border-radius:10px;height:90%">
					<c:if test="${goodsCategory=='초' }">
						<option selected value="초">초</option>
					</c:if>
					<c:if test="${goodsCategory!='초' }">
						<option value="초">초</option>
					</c:if>
					<c:if test="${goodsCategory=='풍선' }">
						<option selected value="풍선">풍선</option>
					</c:if>
					<c:if test="${goodsCategory!='풍선' }">
						<option value="풍선">풍선</option>
					</c:if>
					<c:if test="${goodsCategory=='폭죽' }">
						<option selected value="폭죽">폭죽</option>
					</c:if>
					<c:if test="${goodsCategory!='폭죽' }">
						<option value="폭죽">폭죽</option>
					</c:if>
					<c:if test="${goodsCategory=='고깔모자' }">
						<option selected value="고깔모자">고깔모자</option>
					</c:if>
					<c:if test="${goodsCategory!='고깔모자' }">
						<option value="고깔모자">고깔모자</option>
					</c:if>
				</select>
			</div>
		</div>
		<div align="left" style="width:20%;display:inline-block">
			가격
		</div>
		<div align="left" style="width:74%;display:inline-block">
			<div style="width:30%;display:inline-block">
				<input type="number" step="1000" name="goodsPrice" class="form-control" style="border-color:#fdcdcd" value="${goodsPrice }">
			</div>원
		</div>
		<div align="left" style="width:20%;height:20%;display:inline-block">
			상품설명
		</div>
		<div align="left" style="width:74%;height:20%;display:inline-block">
			<textarea style="width:100%;margin-top:20px;border-color:#fdcdcd" class="form-control" name="goodsDetail">${goodsDetail }</textarea>
		</div>
		<div align="left" style="width:20%;display:inline-block">
			사진
		</div>
		<div align="left" style="width:74%;display:inline-block">
			<input type="file" class="form-control" style="border-color:#fdcdcd" name="goodsImage" onchange="previewFile(event)">
		</div>
	</div>
	<div style="display:inline-block;width:30%;height:50%" align="center">
		<div>
			사진 미리보기
		</div>
		<div>
			<img src="/Allways/${goodsImage }" id="preview" height="200" width="200" style="display:block;margin:20px;border-radius:10px;">
			<input type="hidden" name="goodsImage" value="${goodsImage }">
		</div>
		<div>
			<input type="button" class="btn" style="background:#ffffff;border-color:#a87878;color:#a87878" value="취소" onclick="cancelDo()">
			<input type="button" class="btn" style="background:#ffffff;border-color:#a87878;color:#a87878" value="수정" onclick="updateDo()">
			<input type="button" class="btn" style="background:#ffffff;border-color:#a87878;color:#a87878" value="삭제" onclick="deleteDo()">
		</div>
	</div>
</form>
</div>
</body>
</html>