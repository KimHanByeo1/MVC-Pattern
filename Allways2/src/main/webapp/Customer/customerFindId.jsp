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
	
	#Join_image{
		padding-top: 70px; 
		padding-left: 0px; 
		padding-bottom: 13px;
	}	
	
	#Line{
		width: 700px;
		height: 0px;
		border: 2px dashed #FF9191;
		
	}
	
	#input_box{
		box-sizing: border-box;
		left: 30px;
		right: 0px;
		width: 350px;
		height: 45px;
		background: #FFFFFF;
		border: 3px solid #FCD5D5;
		padding-left: 10px;
	
	}
	
	#code_box{
		box-sizing: border-box;
		left: 30px;
		right: 0px;
		width: 270px;
		height: 45px;
		background: #FFFFFF;
		border: 3px solid #FCD5D5;
		padding-left: 10px;
	
	}
	
	#select_box{
		box-sizing: border-box;
		left: 30px;
		right: 0px;
		width: 224px;
		height: 45px;
		background: #FFFFFF;
		border: 3px solid #FCD5D5;
		padding-left: 10px;
	
	}
	
	#id_box{
		box-sizing: border-box;
		left: 0px;
		right: 0px;
		width: 270px;
		height: 45px;
		background: #FFFFFF;
		border: 3px solid #FCD5D5;
		padding-left: 10px;
	
	}
	
	#address_box{
		box-sizing: border-box;
		left: 30px;
		right: 0px;
		width: 289px;
		height: 45px;
		background: #FFFFFF;
		border: 3px solid #FCD5D5;
		padding-left: 10px;
	
	}
	
	#email_first{
		box-sizing: border-box;
		left: 30px;
		right: 0px;
		width: 162.3px;
		height: 45px;
		background: #FFFFFF;
		border: 3px solid #FCD5D5;
		padding-left: 10px;
	
	
	}
	#email_second{
		box-sizing: border-box;
		left: 30px;
		right: 0px;
		width: 162.3px;
		height: 45px;
		background: #FFFFFF;
		border: 3px solid #FCD5D5;
		padding-left: 10px;
	
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
	}	
	
	#radio_design{
		/* Vector */
		width: 32.67px;
		height: 32.67px;
		color: #FCD5D5;

		/* Vector */
		width: 16.33px;
		height: 16.33px;
		color: #FCD5D5;
		
		/* WOMAN */
		font-family: 'Baloo Tammudu 2';
		font-style: normal;
		font-weight: 600;
		font-size: 14px;
		line-height: 32px;
		
		color: #FCD5D5;
		
	}

	#join_button {
		width: 136.55px;
		height: 41.63px;
		background: #FCD5D5;
		border: 2px solid #FCD5D5;
		font-family: 'Baloo Tammudu 2';
		font-style: normal;
		font-weight: 700;
		font-size: 20px;
		color: #FFFDFD;
		line-height: 46px;
	}
	
	
	#check_box{
		box-sizing: border-box;
		width: 72px;
		height: 41.74px;
		background: #FCD5D5;
		border: 2px solid #FCD5D5;
		color: #FFFFFF;
	}
	
	#send_box{
		box-sizing: border-box;
		width: 120px;
		height: 41.74px;
		background: #FCD5D5;
		border: 2px solid #FCD5D5;
		color: #FFFFFF;
	}

</style>

<title>ALLWAYS FIND ID</title>
<%@include file="customerHeader.jsp" %>

<script type="text/javascript">

	function findAction(){
		
		var form = document.customerFindId;
		
		if(form.customerName.value.length == 0) {
			alert("이름을 입력해주세요.");
			form.customerName.focus();
			return;
		}
		
		if(form.customerBirth.value.length == 0){
			alert("생년월일을 선택해 주세요");
			form.customerBirth.focus();
			return;
		}
		
		if(form.customerPhone.value.length == 0){
			alert("전화번호를 입력해 주세요.");
			form.customerPhone.focus();
			return;
		}
		
		if(form.email1.value.length == 0) {
			alert("메일을 입력해 주세요.");
			form.email1.focus();
			return;
		}
		
		if(form.email2.value.length == 0) {
			alert("메일주소를 선택해 주세요.");
			form.email2.focus();
			return;
		}

		if(form.codecheck.value != 1){
			alert("이메일 인증을 해주세요");
			return;
		}
		
		form.submit();
	}

</script>

<script>


	$(document).ready(function(){
		
		$('#send_box').click(function(){
		
			var uemail = $('#email_first').val() + "@" + $('#email_second').val();
			var email1 = $('#email_first').val();
			var email2 = $('#email_second').val();
			
			if(email1==""){
				alert("이메일을 입력해주세요");
			}else{
				alert('이메일 전송중입니다. 이메일 전송 완료 알림이 뜰 때까지 기다려주세요.');
				
				$.ajax({
					url:'http://localhost:8080/Allways/Email2',
					type:'POST',
					data:{email1 : email1 , email2 : email2},
					success:function(response){
						$('#email_certify_num').attr('value',response);
						alert('이메일 전송이 완료되었습니다.');
					}
				});
			}
		})
	})

	
	function CheckCode() {
	// 이메일 인증번호가 일치하는지 확인
		var insert_num = $('#ucertify_num').val(); 
		var answer = $('#email_certify_num').val();
		if(insert_num != answer){
			alert("인증번호가 틀렸습니다. 다시 확인해 주세요.");
			focus($('#ucertify_num'));
			var offset = $("#ucertify_num").offset(); 
			$("html, body").animate({scrollTop: offset.top},200); 
			return;
		}
		
		if(insert_num == answer){
			var result = 1;
			alert("인증되었습니다.");
			$('input[name=codecheck]').attr('value',result);
		}
	}
	
</script>

</head>
<body>

<form action="customerFindId.do" name="customerFindId" method="post" style="height: 1000px;">
		<div class="container text-center">
			<div class="row">
				<div class="col">
				</div>
				<div class="col">
					<img src="./images/find.png" id="Join_image"><br>
					<br><h2 id="Join">FIND YOUR ID</h2><br>
					
					<label id="label_design">NAME</label>
					<input id="input_box" type="text" name="customerName" placeholder="이름을 입력해주세요"><br><br>
					
					<label id="label_design">BIRTHDAY</label>
					<input id="input_box" type="date" name="customerBirth" style="padding-right: 10px;"><br><br>
					
					<label id="label_design">PHONE</label>
					<input id="input_box" type="text" name="customerPhone" placeholder=" '-' 를 제외하고 숫자만 입력해주세요"><br><br>
					
					<label id="label_design">EMAIL</label>
					<input id="email_first" type="text" name="email1" value="${EMAIL}"> @ <input id="email_second" type="text" name="email2" placeholder="직접 입력">
						<select id="select_box" name="selectemail" style="margin-top: 5px;" onChange="selectEmail(this)">
							<option value="" selected="selected">선택하세요</option>
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="gmail.com">daum.net</option>
							<option value="1">직접 입력</option>
						</select>
					<input type="button" id="send_box" value="인증번호 보내기"><br><br>
					
					
					<label id="label_design">VERIFICATION CODE CHECK</label>
					<input style="box-sizing: border-box;
								left: 30px;
								right: 0px;
								width: 270px;
								height: 45px;
								background: #FFFFFF;
								border: 3px solid #FCD5D5;
								padding-left: 10px;" 
					id="ucertify_num" type="text" name="" placeholder="인증번호를 입력해주세요">
					<input type="button" name="btnIdCheck" id="check_box" value="확인" onclick="CheckCode()"><br><br>
					
					<input type="hidden" id="email_certify_num" >
					
					<input type="hidden" id="codecheck" name="codecheck" value="">
					
					<input id="join_button" style="margin-top: 30px" type="button" name="find" value="FIND" onclick="findAction()">			
				</div>
			<div class="col">
			</div>
			</div>
		</div>
	</form>
	
	<script src = "js/jquery-3.6.0.min.js"></script>
	
	<script type="text/javascript">
	function selectEmail(ele) {
		var $ele = $(ele);
	    var $email2 = $('input[name=email2]');
	    // '1'인 경우 직접입력
	    if($ele.val() == "1"){
	        $email2.attr('readonly', false);
	        $email2.val('');
	    } else {
	        $email2.attr('readonly', true);
	        $email2.val($ele.val());
	    }
	}
</script>
	
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


</body>
</html>