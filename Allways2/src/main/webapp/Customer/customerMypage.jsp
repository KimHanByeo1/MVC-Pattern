<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Viewport -->
<meta name="viewport" content="width=device-width, initial-scale=1" />

<meta name="format-detection" content="telephone=no, address=no, email=no" />

<!-- XEIcon -->
<link rel="stylesheet" href="/assets/fonts/icons/xeicon/xeicon.css?ver=1.015" />

<!-- Masstige Custom Icon for Board Template -->
<link rel="stylesheet" href="/assets/fonts/icons/icomoon/masstige-icons.css?ver=1.015" />

<!-- Google Material Icons -->
<link rel="stylesheet" href="/assets/fonts/icons/material/material-icons.css?ver=1.015" />

<!-- Bootstrap Icons -->
<link rel="stylesheet" href="/assets/fonts/icons/bootstrap/bootstrap-icons.min.css?ver=1.015" />

<!-- Stylesheet -->
<link rel="stylesheet" href="/assets/css/jquery-ui.min.css?ver=1.015" />
<link rel="stylesheet" href="/assets/css/common.min.css?220214v2&ver=1.015" />

<!-- Load jQuery -->
<script src="/assets/js/lib/jquery-1.7.1.min.js"></script>
<!-- update your pre-1.9 jQuery code to jQuery 1.9 up to 3.0 -->
<script src="/assets/js/lib/jquery-migrate-1.4.1.min.js"></script>
<!-- jQuery 3.0 or higher, once you have used Migrate 1.x and upgraded to jQuery 1.9 or higher -->
<!-- <script src="/assets/js/lib/jquery-migrate-3.3.2.min.js"></script>  -->
<!-- mCustomScrollbar 사용시 아래 1.11.1 버전 사용 -->
<!-- <script src="/assets/js/lib/jquery-1.11.1.min.js"></script> -->

<script src="/assets/js/lib/jquery-ui.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@700&display=swap" rel="stylesheet">

<style type="text/css">	
	#Join{
		font-family: 'Baloo Tammudu 2'; 
		font-style: normal; 
		font-weight: 700;
		font-size: 34px;
		color: #EE3838;
	}
	
	#label_design{
		font-family: 'Baloo Tammudu 2';
		font-style: normal;
		font-weight: 600;
		font-size: 18px;
		line-height: 32px;
		display: flex;
		color: #766262;
		margin-bottom: 0px;
		height:25px;
		align: right;
	}	
	
	#LoginBtn{
	width: 365px;
	height: 54px;
	background: #EE7272;
	border: 3px solid #EE7272;
	border-radius: 50px;
	}

	#pSet {
	  
	  text-align: center;
	  color: rgba(255, 255, 255, 1);
	  font-family: 'Baloo Tammudu 2';
	  font-style: normal;
	  font-size: 22px;
	  
}
	
</style>

<script type="text/javascript">


function revision(index){
		var form = document.customerMypage;
		
		if(index==1){
		form.action="customerRevision.do";
		}
		
		if(index==2){
		form.action="customerOrderList.do";
		}
		
		if(index==3){
		form.action="customerMyPointList.do";
		}
		
		form.submit();
	
	}
	
/* 	
function orderlist(){
		var form = document.customerMypage;
		form.action="customerOrdersList.do";
		form.submit();
	}
	 */
</script>

<title>MYPAGE REVISION</title>
<%@include file="customerHeader.jsp" %>
</head>
<body>
	
	<form action="customerMypage.do" name="customerMypage" method="post" style="height: 1400px;">
		<div class="container text-center">
			<div class="row">
				<div class="col">
					<br><br><br><br><br><br><br><br><br>
				
				
				</div>
				<div class="col">
					<img src="./images/Amypage.png" id="Join_image" style="margin-top: 30px;"><br>
					<br><h2 id="Join">MYPAGE</h2><br>
					
					<button id="LoginBtn" type="button" name="Revision" onclick="revision(1)">
					<p id="pSet" style="padding-top: 11px;">INFORMATION REVISION</p></button><br><br>
					
					<button id="LoginBtn" type="button" name="orderlist" onclick="revision(2)">
					<p id="pSet" style="padding-top: 11px;">MY ORDERLIST</p></button><br><br>
					
					<button id="LoginBtn" type="button" name="mypoint" onclick="revision(3)">
					<p id="pSet" style="padding-top: 11px;">MY POINT</p></button><br><br>
					
					
					
				</div>
			<div class="col">
			</div>
			</div>
		</div>
	</form>






	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	
<script src="/assets/js/lib/jquery-ui.min.js"></script>
<script src="/assets/js/lib/popper.min.js"></script>
<script src="/assets/js/lib/bootstrap.min.js"></script>
<script src="/assets/js/lib/slick.min.js"></script>
<script src="/assets/js/lib/wow.min.js"></script>
<script src="/assets/js/lib/aos.min.js"></script>
<script src="/assets/js/lib/jquery.magnific-popup.min.js"></script>
<!-- fullpage에서 scrollOverflow 옵션 사용 시 선언 -->
<!-- <script src="/assets/js/lib/scrolloverflow.min.js"></script> -->
<!-- css3:false 옵션 적용 후 "linear", "swing" 또는 "easeInOutCubic" 대신 다른 easing 효과 사용 시  선언-->
<!-- <script src="/assets/js/lib/easings.min.js"></script>
<script src="/assets/js/lib/fullpage.min.js"></script> -->
<script src="/assets/js/lib/swiper.min.js"></script>
<script src="/assets/js/lib/jquery.scrollbar.min.js"></script>
<script src="/assets/js/lib/jquery.mCustomScrollbar.min.js"></script>
<script src="/assets/js/lib/paper-full.min.js"></script>
<!-- <script src="/assets/js/lib/jquery.rwdImageMaps.min.js"></script> 이미지맵 반응형 플러그인 -->

<!-- for Board Template-->
<script src="/assets/js/custom/clipboard.js"></script>

<!-- Custom Library -->
<script src="/assets/js/custom/nav_active-1.1.6.masstige.min.js"></script>
<script src="/assets/js/custom/tab-1.1.0.masstige.js"></script>
<script src="/assets/js/custom/resizingCheck-1.0.0.masstige.js"></script>
<!-- <script src="/assets/js/custom/fullpage.coverflow.masstgie.js"></script>  사용시에만 주석 해제 -->
<script src="/assets/js/custom/nav_drop-1.0.1.masstige.min.js"></script>
<script src="/assets/js/custom/scroll_track-1.0.1.masstige.min.js"></script>
<!-- <script src="/assets/js/custom/wow.masstige.js"></script>  -->
<!-- wow.masstige.js : wow reinit -->

<!-- COMMON -->
<script src="/assets/js/common.js"></script>
<script src="/js/other.js?ver=1.0408"></script>
<script src="/js/pg_common.js?ver=1.0408"></script>
<script src="/js/orderform.js?ver=1.0408"></script>
<script src="/lib/mall/order.js?ver=1.0408"></script>


<script type="text/javascript">
<script
src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</body>
</html>