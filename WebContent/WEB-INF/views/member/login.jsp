<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animatedLogin.css"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
  
</head>
<body>
    
    <form action="/member/login" class="login-form" method="post">
        <h1>Login</h1>

        <div class="txtb">
            <input type="text" value="" name="user-id">
            <span data-placeholder="ID"></span>
        </div>

        <div class="txtb">
            <input type="password" value="" name="user-pwd">
            <span data-placeholder="Password"></span>
        </div>

        <input type="submit" class="logbtn" value="Login">

        <div class="bottom-text">
            계정이 있으신가요? <a href="/member/enroll">회원가입</a> <br>
            아이디를 잊으셨나요? <a href="/member/find">아이디찾기</a><br>
            비밀번호를 잊으셨나요? <a href="/pwd/search">비밀번호찾기</a>
        </div>
        
        <div class="bottom-text">
            <a href="/index.jsp">뒤로가기</a>
        </div>
    </form>

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
</html>