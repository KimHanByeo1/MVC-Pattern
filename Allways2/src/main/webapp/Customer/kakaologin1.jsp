<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script src="https://code.jquery.com/jquery3.1.1.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">

	// 사용할 앱의 JS키 설정
	Kakao.init('f671edc3fc17d4fe50018e3c23712b17');
	
	/*
	
	Kakao.Auth.authorize({
		redirectUri: "http://localhost:8080/Allways/Customer/customerLogin.jsp",	
	});

	*/
	
	Kakao.Auth.loginForm({
		success: function(authObj){
			
			Kakao.API.request({
				url:'v2/user/me',
				success: function(res){
					console.log(res);
					var id = res.id;
		        	var email = res.kakao_account.email;
		        	var name = res.properties.nickname;
		        	var html = '<BR>' + email + '<BR>' + name;
		        	  
		        	  $('body').append(html);
					
					//location.href='Allways/Customer/customerLogin.jsp?email=' + email + '&name=' + name;
				}
			})
			
			console.log(authObj);
			var token = authObj.access_token;
		},
		
		fail: function(err){
			alert(JSON.stringify(err));
		}
	});
	
</script>

</body>
</html>