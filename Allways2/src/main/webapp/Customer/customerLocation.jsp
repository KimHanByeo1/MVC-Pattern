<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALLWAYS LOCATION</title>

<%@include file="customerHeader.jsp" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=79cc95a0154045598e5c05072effa0f2"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@700&display=swap" rel="stylesheet">

<style>
	#title{
		font-family: 'Baloo Tammudu 2'; 
		font-style: normal; 
		font-weight: 700;
		font-size: 41px;
		color: #EE3838;
		margin-top: 5px;
	}
	
	#address{
	/* 서울 강남구 강남대로 78길 8 한국빌딩 4F */
		width: 658px;
		height: 70px;
		font-family: 'EF_Diary';
		font-style: normal;
		font-weight: 400;
		font-size: 25px;
		color: #4E4D4D;
		margin-top: 20px;
	}
	

</style>

</head>
<body style="background: #FFF1F1">
	<form action="customerLocation.do" name="customerLocation" method="post">
		<div class="container text-center">
			<div class="row">
				<div class="col"></div>
				<div class="col">
					<img src="./images/Amap.png" style="width:80px;height:80px; margin-top: 50px; margin-bottom: 5px;">
					<h1 align="center" id="title"> LOCATION </h1>
						<p id="address">서울 강남구 강남대로 78길 8 한국빌딩 4F</p>
				<div id="map" style="width:600px;height:500px; margin-top:3px; margin-left: 30px; margin-bottom: 40px;"></div>
						<p id="address" style="height:70px;">강남역 4번출구에서 133m</p>
				</div>
				<div class="col"></div>
			</div>
		</div>
		
		
		
		<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.494753466226925, 127.03002602066344),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		var markerPosition  = new kakao.maps.LatLng(37.494753466226925, 127.03002602066344);
		var marker = new kakao.maps.Marker({
			position: markerPosition 
		});
		    marker.setMap(map); 
		var iwContent = '<div style="padding:5px;">더조은 컴퓨터학원 <br><a href="https://map.kakao.com/link/map/Roast Bean Company,37.494753466226925,127.03002602066344" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Roast Bean Company,37.494753466226925,127.03002602066344" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

		// 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
		    position : iwPosition, 
		    content : iwContent 
		});
		  
		// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
		infowindow.open(map, marker); 
		
	</script>


	</form>
</body>
</html>