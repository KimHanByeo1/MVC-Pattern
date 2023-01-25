<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="javascript:kakaoLogin();"><img src="https://www.gb.go.kr/Main/Images/ko/member/certi_kakao_login.png" style="height:60px; width:auto;"/></a>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	
	<script type="text/javascript">
		Kakao.init('f671edc3fc17d4fe50018e3c23712b17');
	
		function kakaoLogin(){
			Kakao.Auth.login({
				scope:'account_email, gender',
				success: function(authObj){
					console.log(authObj);
					Kakao.API.request({
						url: '/v2/user/me',
						success: res => {
							const kakao_account = res.kakao_account;
							console.log(kakao_account);
						}
					});
				}
			});
		}
		
		
	</script>
</body>
</html>