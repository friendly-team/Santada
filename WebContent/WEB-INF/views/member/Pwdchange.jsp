<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>비밀번호 변경</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animatedLogin.css"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css"/>
<script>
    $(function(){

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
    
    <form action="/pwd/change" class="login-form" method="post">
        <h1>비밀번호 변경</h1>


		<div class="txtb">
            <input class="email" type="text" name="user-id" value="${change}" readonly>
        </div>

        <div class="txtb">
            <input class="email" type="password" name="user-pwd" id="user-pwd">
            <span data-placeholder="비밀번호"></span><span id="out"></span>
        </div>

        <div class="txtb">
            <input class="email" type="password" name="pwd-recheck" id="pwd-check">
            <span data-placeholder="비밀번호 확인"></span>
        </div>

        <input type="submit" class="logbtn" value="완료" id = "insert_btn">

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
<script>
    $("#insert_btn").click(function(){
            alert("비밀번호가 성공적으로 변경되었습니다");
        
    });
    </script>
</body>
</html>