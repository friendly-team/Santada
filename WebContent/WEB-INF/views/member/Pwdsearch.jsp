<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animatedLogin.css"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
</head>
<body>
    
    <form action="/pwd/search" class="login-form" method="post">
        <h1>비밀번호 찾기</h1>


        <div class="txtb">
            <input class="id"type="text" name="user-id">
            <span data-placeholder="아이디"></span>
        </div>

        <div class="txtb">
            <input class="email" type="text" name="user-name">
            <span data-placeholder="이름"></span>
        </div>

        <div class="txtb">
            <input class="email" type="text" name="user-email">
            <span data-placeholder="이메일"></span>
        </div>

        <input type="submit" class="logbtn" value="비밀번호 찾기">

        <div class="bottom-text">
            계정이 있으신가요? <a href="/member/enroll">회원가입</a> <br>
            아이디를 잊으셨나요? <a href="/member/find">아이디 찾기</a>
            <br>메인으로가기 <a href="/index.jsp">메인으로</a>
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