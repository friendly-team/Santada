<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animatedLogin.css"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>

</head>
<body>
    
    <form action="/member/login" class="login-form">
        <h1>아이디 찾기</h1>

        <b>고객님의 정보와 일치하는 아이디 목록입니다.</b>

       <div class="search-form">
            <ul class="search-form-box">
                <li>${idOne.userId}</li>
                <li>가입: ${idOne.enrollDate}</li>
            </ul>
       </div>

        <input type="submit" class="logbtn" value="로그인">

        <div class="bottom-text">
            계정이 있으신가요? <a href="/member/enroll">회원가입</a> <br>
            비밀번호를 잊으셨나요? <a href="/pwd/search">비밀번호 찾기</a> 
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