<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animatedLogin.css"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
<script>
    $(function(){

$('#user-id').blur(function(){

var value=$('#user-id').val().trim();

var reg=/^[a-zA-Z][A-Za-z0-9]{4,}/;

if(!reg.test(value))

{

alert("5글자이상, 영문자, 숫자만 가능");

$('#user-id').val('');

}

});

$('#pwd-check').keyup(function(){

var pw1=$('#user-pwd').val().trim();

if(pw1==""){

alert("패스워드를 입력하세요");

$('#pwd-check').val('');

$('#user-pwd').focus();

}

var pw2=$('#pwd-check').val().trim();

if(pw1.length!=0 && pw2.length!=0){

if(pw1==pw2)

{

$('#out').html("패스워드가 일치합니다.");

$('#out').css({'color':'green','font-weight':'bolder'});

}

else{

$('#out').html("패스워드가 일치하지 않습니다.");

$('#out').css({'color':'red','font-weight':'bolder'});

}

}

});
});
    </script>
</head>
<body>
    
    <form action="/member/enroll" class="login-form" method="post">
        <h1>회원가입</h1>


        <div class="txtb">
            <input type="text" name="user-id" id="user-id">
            <span data-placeholder="아이디"></span>
        </div>

        <div class="txtb">
            <input type="password" name="user-pwd" id="user-pwd">
            <span data-placeholder="비밀번호"></span><span id="out"></span>
        </div>

        <div class="txtb">
            <input type="password" name="pwd-check" id="pwd-check">
            <span data-placeholder="비밀번호 확인"></span>
        </div>

        <div class="txtb">
            <input type="text" name="user-name" id="user-name">
            <span data-placeholder="이름"></span>
        </div>

        <div class="txtb">
            <input type="text" name="user-phone" id="user-phone">
            <span data-placeholder="전화번호(-제외)"></span>
        </div>

        <div class="txtb">
            <input type="text" name="user-email" id="user-email">
            <span data-placeholder="이메일"></span>
        </div>


        <input type="submit" class="logbtn" value="가입하기">

        <div class="bottom-text">
            <a href="/member/login">뒤로가기</a>
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