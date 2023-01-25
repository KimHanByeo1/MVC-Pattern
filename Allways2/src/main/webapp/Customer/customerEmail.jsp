<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script type="text/javascript">
	
	
	$(document).ready(function(){
	
	$('#email_check').click(function(){
		   
		
		
		       var uemail = $('#u').val();
		        
		       if(uemail=="")
		      	{
				alert("이메일을 입력해주세요");
		       }
		       else
		       {
		    	   var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		    	   if(!regExp.test($('#uemail').val())){
		    		   alert('이메일 형식에 맞지 않습니다.');
		    		   $('#uemail').val('');
		    	   }else{
			    	   alert('이메일 전송중입니다.이메일 전송 완료 알람이 뜰 떄까지 기다려주세요.');
			    	   
			           $.ajax({
			              url:'http://localhost:8080/Allways/Email2',
			              type:'POST',
			              data:{uemail : uemail},
			              success:function(response)
			              {
			                $('#email_certify_num').attr('value',response);
			                alert('이메일 전송이 완료되었습니다.');
			              }
			           });
		    	   }
		       }
		        
			}); 
	})
	

	
	</script>
</body>
</html>