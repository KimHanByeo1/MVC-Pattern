<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
input::placeholder {
  
  text-align: center;
  color: rgba(255, 184, 184, 0.4);
  font-family: 'Baloo Tammudu 2';
  font-style: normal;
  font-size: 22px;
  
}
#pSet {
  
  text-align: center;
  color: rgba(255, 255, 255, 1);
  font-family: 'Baloo Tammudu 2';
  font-style: normal;
  font-size: 22px;
  
}
#IDandPW {
	background: #FFFFFF; 
	border: 3px solid #EF7A7A; 
	border-radius: 50px;
	width: 365px;
	height: 54px;
	margin-bottom: 10px;
	}
	
#LoginBtn{
	width: 365px;
	height: 54px;
	background: #EE7272;
	border: 3px solid #EE7272;
	border-radius: 50px;
}
#TextColor{
	font-family: 'Baloo Tammudu 2';
	font-style: normal;
	font-size: 17px;
	line-height: 0px;
	color: #E7A2A2;
}	
	
</style>

<script type="text/javascript">
	function loginAction(){
		var form = document.customerLogin;
		form.action="customerLogin.do";
		form.submit();
	}
	
	/* 
	function backtomain(){
		var form=document.login;
		form.action="http://localhost:8080/All100Shoes/Customer/main.jsp";
		form.submit();
	}
	
	function makeaccount(){
		var form=document.login;
		form.action="managerAdd.jsp";
		form.submit();
	} */
</script>

<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://code.jquery.com/jquery3.1.1.min.js"></script>
<script type="text/javascript">

<script>
Kakao.init('f671edc3fc17d4fe50018e3c23712b17'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (authObj) {
    	  
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response);
        	  
        	  var id = res.id;
        	  var email = res.kakao_account.email;
        	  var name = res.properties.nickname;
        	  var html = '<BR>' + email + '<BR>' + name;
        	  
        	  $('body').append(html);
        	  
          }
        })
        	consolelog.log(authObj);
        	var token = authObj.access_token;
        	
      	},	
          fail: function (err) {
           	alert(JSON.stringify(err));
          }
        });

    //카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>	

<title>Login</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Tammudu+2:wght@700&display=swap" rel="stylesheet">

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
</head>
<body style="background: #FFF1F1">
	<form name="customerLogin" method="post">
		<div class="container text-center">
			<div class="row">
				<div class="col">
				</div>
				<div class="col">
				<img src="./images/LOGO.png"><br></img>
				<input style="padding-left: 20px;" id="IDandPW" type="text" name="customerId" placeholder="ID"><br>
				<input style="padding-left: 20px;" id="IDandPW" type="password" name="customerPw" placeholder="PASSWORD"><br>
				<button id="LoginBtn" type="button" name="Login" onclick="loginAction()">
				<p id="pSet" style="padding-top: 11px;">LOGIN</p></button><br>
				
				<c:choose> 
					<c:when test="${CHECK == false}">
						<p class="danger-text" style="color:blue; margin-top: 5px;">아이디 또는 비밀번호를 확인해주세요!</p>
					</c:when>
					<c:otherwise>
						<p class="danger-text" style="color:blue; margin-top: 5px;"></p>
					</c:otherwise> 
				</c:choose>
								
				<ul>
	<li onclick="kakaoLogin();">
      <a href="javascript:void(0)">
          <span>카카오 로그인</span>
      </a>
	</li>
	<li onclick="kakaoLogout();">
      <a href="javascript:void(0)">
          <span>카카오 로그아웃</span>
      </a>
	</li>
</ul>
			
								
				<a href="customerJoin.jsp" id="TextColor">ALLWAYS 첫 방문이신가요? ▶ JOIN</a><br>
				<a href="customerFindId.jsp" id="TextColor" >ID/PASSWORD를 잊어버리셨나요? ▶ ID찾기 / </a>
				<a href="customerFindPw.jsp" id="TextColor" >PASSWORD 찾기</a><br>
				
				<a href="customerAbout.jsp" id="TextColor" style="font-size: 21px;">GO HOME</a>
				
				</div>
			<div class="col">
			</div>
			</div>
		</div>
	</form>
	

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
</body>
</html>