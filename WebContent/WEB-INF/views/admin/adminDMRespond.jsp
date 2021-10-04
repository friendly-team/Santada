<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변완료</title>
</head>
<body>
	<h1>답변을보냈습니다.</h1>
	
	<script>  
    function closeWindow() {  
            setTimeout(function() {  
        window.close();  
            }, 1000);  
        }  
    window.onload = closeWindow();  
    opener.parent.location.replace("/admin/report");
</script>  
</body>
</html>