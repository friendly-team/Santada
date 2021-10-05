<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="1 url=/member/enroll">
    <title>회원가입 실패</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animatedLogin.css"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>

</head>
<body>
    
    <h1 id="loginfail">이미 존재하는 아이디입니다.</h1>

    <script type="text/javascript">
        $(".txtb input").on("focus",function(){
            $(this).addClass("focus");
        });

        $(".txtb input").on("blur",function(){
            if($(this).val() == "")
            $(this).removeClass("focus");
        })
    </script>

</body>
</html>l>