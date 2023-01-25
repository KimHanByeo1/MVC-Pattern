<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <!DOCTYPE html>
<html lang="ko">
	<head>
		<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-KPSDHV9');</script>
<!-- End Google Tag Manager -->

<meta charset="UTF-8" />
<!-- ( < IE10 ) -->
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

<!-- Console 화면 노출  -->
<script>
	var cssRule = 'font-size: 16px;';
	if (window.console != undefined) {
		setTimeout(console.log.bind(console, '%c _____ _____ _____ _____ _____ _____ _____ _____\n|     |  _  |   __|   __|_   _|     |   __|   __|\n| | | |     |__   |__   | | | |-   -|  |  |   __|\n|_|_|_|__|__|_____|_____| |_| |_____|_____|_____|\nCreated By MASSTIGE.', cssRule), 0);
	}
</script>

<title>   회원가입 |  Drawing fun, 케이크로 제안하는 특별한 일상 </title>
		<link rel="stylesheet" href="../assets/css/member.min.css" />
	</head>
	<body class="sub-body">
		<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-KPSDHV9"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>


		<button class="search-mobile__btn" type="button">
						<img src="/assets/images/icon/search_icon_color.svg" alt="search" />
						<i class="bi bi-x-lg text-color-1"></i>
		</button>

		<button class="nav-mobile__btn" type="button">
			<i class="bi bi-list"></i>
		</button>

		<div class="nav__bg d-none"></div>


<script>

function enterkey() {
  if (window.event.keyCode == 13) {
  $('.search-box__btn').trigger('click');
  }
}
</script>
		<main class="main sub-main" id="contents">
			<section class="section">
				<div class="container">
					<div class="text-center title-icon mb-2">
						<img src="../assets/images/sub/title_icon.png" alt="candy" />
					</div>
					<h1 class="sub-main__title mb-10">회원가입</h1>

					<form name="signform" id="signform" method="post" action="../Bboard/memberok.php" enctype="multipart/form-data" autocomplete="off" onsubmit="return memberform_chk();">
						<input type="hidden" name="formmode" value="save" />
						<input type="hidden" name="passchk1" id="passchk1" value="" title="비밀번호" />
						<input type="hidden" name="passchk" id="passchk" value="" title="비밀번호" />
						<input type="hidden" name="idchk" id="idchk" value="" title="아이디" />
            <input type="hidden" name="snstype" id="snstype" value="">
            <input type="hidden" name="snsid" id="snsid" value="">
						<div class="join__wrap">
							<!-- S : 필수사항 -->
							<div class="join-area join-area--border-top2 join-area--border-color1 mt-3">
								<div class="join-area__box">
									<p class="join-area__title">회원구분</p>
									<div class="row no-gutters mt-4">
										<div class="col-auto">
											<label class="input-label input-label--radio">
												<input type="radio" id="ulevel1" name="ulevel" value="1" checked onclick="ulevel_formchk(1);" />
												<span class="input-label__txt text-color-1 font-weight-medium">개인회원</span>
											</label>
										</div>
										<div class="col-auto ml-5">
											<label class="input-label input-label--radio">
												<input type="radio" id="ulevel2" name="ulevel" value="2"  onclick="ulevel_formchk(2);" />
												<span class="input-label__txt text-color-1 font-weight-medium">기업회원</span>
											</label>
										</div>
									</div>
								</div>
                								<div class="join-area__box">
									<p class="join-area__title">아이디(이메일)</p>
									<input class="input_for" type="email" name="mid" id="mid" title="아이디" placeholder="이메일 주소를 입력해주세요." required="" value="" />
									<p class="text-size-14 text-danger mt-2" id="loginId"></p>
								</div>
                                  <div class="join-area__box">
                    <p class="join-area__title">비밀번호</p>
                    <input type="password" class="input_for" name="upasswd" id="upasswd" title="비밀번호" txtlimit="6" maxlength="16" chk="pwcheck" placeholder="" required="" aria-autocomplete="list" />
                    <p class="text-size-14 text-danger mt-2" id="passId"></p>
                  </div>
                  <div class="join-area__box">
                    <p class="join-area__title">비밀번호 확인</p>
                    <input type="password" class="input_for" name="upasswd1" id="upasswd1" title="비밀번호 확인" txtlimit="6" maxlength="16" chk="pwcheck" placeholder="비밀번호 재입력" required="" />
                    <p class="text-size-14 text-danger mt-2" id="passId_1"></p>
                  </div>
                								<div class="join-area__box">
									<p class="join-area__title">이름</p>
									<input class="input_for" type="text" name="uname" id="uname" title="이름" placeholder="이름을 입력해주세요." required="" />
								</div>
								<div class="join-area__box">
									<p class="join-area__title">성별</p>
									<div class="row mt-4">
										<div class="col-auto"><input type="radio" id="female" name="gender" value="female" /><label for="female" class="text-color-1 font-weight-medium">여성</label></div>
										<div class="col-auto pl-0"><input type="radio" id="male" name="gender" value="male" /><label for="male" class="text-color-1 font-weight-medium">남성</label></div>
									</div>
								</div>
								<div class="join-area__box">
									<p class="join-area__title">휴대폰번호</p>
									<div class="input_find">
										<input class="input_for" type="tel" name="uptel" id="uptel" title="연락처" onkeyup="if(isNaN(this.value)) {alert('숫자만 입력해 주세요.');this.value=''};" placeholder="‘–’ 제외하고 숫자만 입력해주세요." required="" />
										<button type="button" class="btn-type-01 table-btn-01 text-size-15 request-btn">인증번호 요청</button>
										<button type="button" class="btn-type-01 table-btn-01 text-size-15 request-complete-btn unbind" style="display: none">인증완료</button>
										<p class="text-size-14 text-danger mt-2" id="phonenum_return"></p>

										<input type="hidden" id="smscheck" value="" />
										<input type="hidden" name="uptelcheck_value" value="" />
									</div>
									<div class="input_find number-form mt-3 input-time__count22">
										<div class="input-time__count">
											<input type="text" class="input_for" onkeyup="if(isNaN(this.value)) {alert('숫자만 입력해 주세요.');this.value=''};" placeholder="인증번호(6자리)" id="certNumber" />
											<div class="input-time__count--box">
												<span class="input-time__count--min"></span>
												<span class="input-time__count--sec"></span>
											</div>
										</div>
										<button type="button" class="btn-type-01 table-btn-01 text-size-15 certify-btn" onclick="chknumber($('#certNumber').val())">인증하기</button>
									</div>
								</div>
								<div class="join-area__box">
									<p class="join-area__title">생년월일</p>
									<input class="input_for" type="date" placeholder="생년월일을 숫자 8자리로 입력해주세요. (ex. 19880512) 만 14세 이상" name="ubir" required="" />
								</div>
								<!--
                <div class="join-area__box">
                  <p class="join-area__title">기념일</p>
                  <input class="input_for" type="date" placeholder="기념일을 숫자 8자리로 입력해주세요. (ex. 19950602)" required name="ubir1"/>
                  <p class="text-size-14 text-color-1 mt-2">* 터틀힙에서 작은 선물을 준비할게요. 특별한 날을 알려주세요.</p>
                </div>
				-->
								<div class="join-area__box">
									<p class="join-area__title">주소</p>
									<div class="input_find input_40">
										<input type="text" id="uzip" name="uzip" class="" readonly="" onclick="daum_zipcode()" />
										<a href="javascript:daum_zipcode()" class="btn-type-01 table-btn-01 text-size-15">우편번호</a>
									</div>
									<div class="row mx-0">
										<div class="col-12 px-0 mt-2">
											<input type="text" class="input_for" name="uaddr1" id="uaddr1" title="기본주소" maxlength="200" value="" readonly="" placeholder="기본주소" onclick="daum_zipcode()" />
										</div>
										<div class="col-12 px-0 mt-2">
											<input type="text" class="input_for" name="uaddr2" id="uaddr2" title="상세주소" maxlength="200" value="" placeholder="상세주소 입력" />
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="text-center mt-12">
							<button type="submit" class="btn-type-01 py-4 px-15 text-size-18">회원가입</button>
						</div>
					</form>
				</div>
			</section>
		</main>

		<script>
  (function() {
    var w = window;
    if (w.ChannelIO) {
      return (window.console.error || window.console.log || function(){})('ChannelIO script included twice.');
    }
    var ch = function() {
      ch.c(arguments);
    };
    ch.q = [];
    ch.c = function(args) {
      ch.q.push(args);
    };
    w.ChannelIO = ch;
    function l() {
      if (w.ChannelIOInitialized) {
        return;
      }
      w.ChannelIOInitialized = true;
      var s = document.createElement('script');
      s.type = 'text/javascript';
      s.async = true;
      s.src = 'https://cdn.channel.io/plugin/ch-plugin-web.js';
      s.charset = 'UTF-8';
      var x = document.getElementsByTagName('script')[0];
      x.parentNode.insertBefore(s, x);
    }
    if (document.readyState === 'complete') {
      l();
    } else if (window.attachEvent) {
      window.attachEvent('onload', l);
    } else {
      window.addEventListener('DOMContentLoaded', l, false);
      window.addEventListener('load', l, false);
    }
  })();
  ChannelIO('boot', {
    "pluginKey": "3aa5499c-f222-47eb-ac33-daa372bfa134" //please fill with your plugin key
  });
</script>
		<!-- <script src="/assets/js/lib/velocity.min.js"></script> 테스트중 -->
<!-- <script src="/assets/js/lib/velocity.ui.min.js"></script> 테스트중 -->
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
	//========== 로그인

		$(document).ready(function(){
			$("#loginSubmit").css("cursor","pointer");

			$("#GetPw_t").keydown(function(key){
				if(key.keyCode == 13){//키가 13이면 실행 (엔터는 13)
					loginProcess();
				}
			});

			$("#loginSubmit").click(function(){
				loginProcess();
			});

			$('.wrap').on('keypress', function(e) {
				if (e.which == 13) {/* 13 == enter key@ascii */
					//alert("you pressed enter key");
					//loginProcess();
				}
			});

			loginProcess=function(){
				var v1 = $('input[name="GetId"]').val();
				var v2 = $('input[name="GetPw"]').val();
				var v4 = $(":input:checkbox[name=idsave]:checked").val();

					if(!v1){
						alert ("아이디를 입력해주세요.");
						return false;
					}
					if(!v2){
						alert ("비밀번호를 입력해주세요.");
						return false;
					}

					$.ajax({
						type : "POST"
						, url : "/INC/userlogin_ajax1.php"
						, dataType : "JSON"
						, data : "mode=login&session_id=75449fd0ec7732eba4a5a1d45c226580&v1="+v1+"&v2="+v2+"&v4="+v4+"&backurl="
						, success : function(res){
							if(res.code=="1"){
								location.href = "../main/main.html";
							} else if(res.code=="2"){	//불량
								alert (res.msg);
								return false;
							} else if(res.code=="3"){	//탈퇴
								alert (res.msg);
								return false;
							} else if(res.code=="4"){	//휴면
								//alert (res.msg);
								//휴면계정 풀림 안내 페이지 이동
								location.href ="../member/dormant_member.html";
								return false;
							}else{
								alert ("입력하신 아이디 또는 비밀번호가 잘못 되었습니다.");
								return false;
							}
						}
					});
			}

		});

	//========== END 로그인

	//========== 로그아웃
	//로그아웃 처리
	$(document).ready(function(){
		$(".process_logout_anywhere").css("cursor","pointer");
		$(".process_logout_anywhere").click(function(){
				$.ajax({
					type : "POST"
					, url : "/INC/userlogin_ajax1.php"
					, dataType : "JSON"
					, data : "mode=logout"
					, success : function(res){
						if(res.code=="1"){
							location.replace("../main/main.html");
						}
					}
				});
		});
	});
	//========== END 로그아웃

	$(document).ready(function() {
		//아이디찾기 실행
		$('#btn-submit_id').click(function(e){
			this_ = $(this);
			e.preventDefault();	//href 안보내기
			var THISCHCK = "uname_1,uptel";
			if(frmCheck( THISCHCK )==true){
				$.ajax({
					type : "POST"
					, url : "/Bboard/idpw_ok.php"
					, dataType : "json"
					, data : $("#formInput").serialize()
					, success : function(res){
						if(res.code!=0){
							view_val = res.msg+'님의 가입하신 아이디는<br /><span class="ff-spartan text-primary">'+res.msg1+'('+res.msg2+')</span> 입니다.';
							$('#idfind_result').html(view_val);
							$('.login__find--before').hide();
							$('.login__find--after').show();
						}else{
							view_val = "일치하는 정보가 없습니다.";
							alert(view_val);
						}
					}
				}); //$.ajax({
			}else{
				return false;
			}
		});
		//비밀번호 찾기 실행
		$('#btn-submit2').click(function(e){
			this_ = $(this);
			e.preventDefault();	//href 안보내기
			var THISCHCK = "mid_1,uname_1,uptel";
			if(frmCheck( THISCHCK )==true){
				$.ajax({
					type : "POST"
					, url : "/Bboard/idpw_ok.php"
					, dataType : "json"
					, data : $("#formInput").serialize()
					, success : function(res){
						if(res.code!=0){
							view_val = '입력하신 '+res.msg+'로 임시비밀번호가 발송되었습니다.';
							$('#idfind_result').html(view_val);
							$('.login__find--before').hide();
							$('.login__find--after').show();
						}else{
							//팝업오픈
							view_val = "일치하는 정보가 없습니다.";
							alert(view_val);
						}
					}
				}); //$.ajax({
			}else{
				return false;
			}
		});
	});
	</script>

<!--회원있을때  /include/js.html 하단에 붙여 넣을 부분 끝 -->

    <script>
    ulevel_formchk('1');
      /* 휴대폰 번호 인증 */
      var numdefault = 180; // 몇분을 설정할지의 대한 변수 선언
      var num = numdefault;
      var myVar;
      function time() {
        myVar = setInterval(alertFunc, 1000);
        alert('인증번호가 발송되었습니다.');
        $('.number-form').css('display', 'flex');
      }

      function alertFunc() {
        var min = num / 60;
        min = Math.floor(min);

        var sec = num % 60;
        // console.log(min);
        // console.log(sec);
        if (sec < 10) viewsec = '0' + sec;
        // 초단위 숫자가 10 보다 작아지면 09,08,07...,00 이와 같이 출력
        else viewsec = sec;

        var $input = $('.input-time__count--min').html(min),
          $input2 = $('.input-time__count--sec').html(':' + viewsec);

        if (num == 0) {
          alert('인증시간이 초과되었습니다. 인증번호를 다시 요청해주십시오.');
          clearInterval(myVar); // num 이 0초가 되었을대 clearInterval로 타이머 종료
		  $('.input-time__count22').hide();
          $('.request-btn').text('인증번호 재요청');
          $('#certNumber').val(''); //인증번호 input 초기화
          num = numdefault;
        }
        num--;
      }

      function chknumber(v) {
        var certification = $('input[name="uptelcheck_value"]').val(); // 인증번호

        if (v == certification) {
          if ($('.certify-btn').hasClass('unbind')) {
            return false;
          } else {
            alert('인증성공');
          }
          clearInterval(myVar); //clearInterval로 타이머 종료
          $('.input-time__count--box').hide(); //타이머 숨김
          $('.input-time__count22').hide(); // 인증요청 버튼 숨김
          $('#uptel').attr('readonly', true); // 휴대폰번호 입력 input readonly 처리
          $('#uptel').addClass('readonly'); // 휴대폰번호 입력 input readonly 처리
		  $('.request-btn').hide();
		  $('.request-complete-btn').show();
		  $('#smscheck').val('1');

        } else {
          alert('인증실패');
          $('#certNumber').val(''); //인증번호 input 초기화
        }
      }

      // function btnDefault(e) {
      //   e.preventDefault();
      //   e.stopPropagation();
      // }

      $(document).on('click', '.request-btn', function () {

				$("#phonenum_return").html('');
		  var uptel = $('#uptel').val();
		  if (!uptel){
			  alert('연락처를 입력해주세요.');
			  $('#uptel').focus();
			  return false;
		  }

			if(uptel.length >= 11){

				$.ajax({
					type : "POST"
					, url : "/INC/other_ajax.php"
					, dataType : "json"
					, data : "mode=uptelchk&v="+uptel
					, beforeSend: function(){  $("#curtainTop").show(); }
					, success : function(res){ $("#curtainTop").hide();
					 if(res.code=='1'){
						alert('이미 가입되어 있는 휴대폰번호입니다.');
					 }else{
						$('input[name="uptelcheck_value"]').val(res.sms_return);
						time();
					 }
					}
				});
			}else{
				$("#phonenum_return").html('<span style="font-size:14px;color:#ff0000">휴대폰번호가 올바르지 않습니다</span>');
			}
      });


	function ulevel_formchk(v)
	{
		if (v=="1") {
			$('.level2_addarea').hide();
			$('#info1').removeAttr("required");
			$('#info2').removeAttr("required");
			$('#info3').removeAttr("required");
			$('#info4').removeAttr("required");
			$('#info5').removeAttr("required");
		}
		if (v=="2") {
			$('.level2_addarea').show();
			$('#info1').attr("required","required");
			$('#info2').attr("required","required");
			$('#info3').attr("required","required");
			$('#info4').attr("required","required");
			$('#info5').attr("required","required");
		}
	}


	function memberform_chk(){
		//sns 로그인이 아닐때만
		if($('#snstype').val()==""){
			if($('#passchk').val()==""){
				alert('비밀번호가 형식에 맞지 않습니다.');
				$('#passchk').focus();
				return false;
			}
			if($('#passchk1').val()==""){
				alert('비밀번호가 다릅니다.');
				$('#passchk1').focus();
				return false;
			}
		}
		if($('#smscheck').val() != "1" ){
			alert('연락처를 인증해주세요');
			return false;
		}
	}

$(function(){
    $("#check_all11").click(function(){
        var chk = $(this).is(":checked");//.attr('checked');
        if(chk) $(".select_subject1").prop('checked', true);
        else  $(".select_subject1").prop('checked', false);
    });
    $("#agree__16").click(function(){
        var chk = $(this).is(":checked");//.attr('checked');
        if(chk) $(".mailsmstype").prop('checked', true);
        else  $(".mailsmstype").prop('checked', false);
    });
});


    </script>

<!-- ========== 우편번호 api ============== -->
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<!--
<script src="https://spi.maps.daum.net/imap/map_js_init/postcode.v2.js"></script>
-->
<script>
    function daum_zipcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById("uzip1").value = data.postcode1; //6자리 우편번호 사용
                //document.getElementById("uzip2").value = data.postcode2; //6자리 우편번호 사용
                document.getElementById("uzip").value = data.zonecode; //5자리 기초구역번호 사용
                document.getElementById("uaddr1").value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("uaddr2").focus();
            }
        }).open();
    }


</script>
	</body>
</html>
