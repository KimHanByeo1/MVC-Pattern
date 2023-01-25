<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KAKAO API 예제</title>
</head>
<body>

<a href="kakaologin1.jsp">로그인이동</a><p>

페이지 내 처리 예제 - creatLoginButton<br>
<a id="kakao-login-button"></a><br>

<p>
<a href="https://developers.kakao.com/logout">로그아웃</a>

<script src="https://code.jquery.com/jquery3.1.1.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">

Kakao.init('f671edc3fc17d4fe50018e3c23712b17');

Kakao.Auth.createLoginButton({
	container: '#kakao-login-button',
	success: function(authObj){
		Kakao.API.request({
			url:'v2/user/me',
			success: function(res){
				console.log(res);
				var id = res.id;
				var email = res.kakao_account.email;
				var name = res.properties.nickname;
				var image = res.properties.profile.image;
				var html = '<BR>' + email + '<BR>' + name;
				
				html += '<BR><img src="' + image + '">';
			}
		})
	}
});

<script>


</body>
</html>