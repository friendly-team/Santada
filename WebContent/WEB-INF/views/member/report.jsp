<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Yoga Studio Template">
    <meta name="keywords" content="Yoga, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Yummy | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- Css Styles -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nice-select.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slicknav.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>

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
    <style>
        	select {

    width:300px;
     padding:5px;
     border:1px solid #999;
     font-family:'Nanumgothic';
     border-radius:3px;
     -webkit-appearance: none;
     -moz-appearance: none;
     appearance : none;
     
}

select::-ms-expand{

display:none;/*for IE10,11*/

}
#page-aside{
    width: 10%;
    position: relative;
    right: 15%;
    /* top: 17%; */
    margin-top: 20%;
}
li{
    list-style: none;
    margin-bottom: 15px;
}
form ul>li{text-align:right;width:43%;

display: inline-block; margin-right:5px}
    </style>
</head>

<body>
    <!-- Page Preloder -->
    <!-- <div id="preloder">
        <div class="loader"></div>
    </div> -->

    <!-- Header Section Begin -->
    <header class="header-section-other">
        <div class="container-fluid">
            <div class="logo">
                <a href="/index.jsp"><img src="/imgs/lettle-logo.png" alt=""></a>
            </div>
            <div class="nav-menu">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="about-me.html">등산인증</a></li>
                                <li><a href="categories.html">등산후기</a></li>
                                <li><a href="recipe.html">랭킹</a></li>
                            </ul>
                        </li>
                        <li><a href="recipe.html">추천코스</a></li>
                        <li><a href="categories.html">소모임</a>
                            <ul class="sub-menu">
                                <li><a href="#">소모임가입</a></li>
                                <li><a href="#">소모임생성</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.html">쪽지</a>
                            <ul class="sub-menu">
                                <li><a href="#">쪽지작성</a></li>
                                <li><a href="#">보관함</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
                <div class="nav-right search-switch">
                    <i class="fa fa-search"></i>
                </div>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Contact Section Begin -->
    <section class="contact-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                        <form action="#" class="contact-form">
                        <h3 style="text-align: center;">My Page</h3>
                        </form>
                        <div id="page-aside">
                                <ul>
                                    <li><a href="/mypage/info">회원 정보</a></li>
                                    <li><a href="/member/remove">회원 탈퇴</a></li>
                                    <li><a href="/point/search">포인트 조회</a></li>
                                    <li><a href="#">주차 예약 조회</a></li>
                                    <li><a href="/report/list">나의 신고 내역</a></li>
                                  
                                </ul>
                        </div> <!-- END COLORLIB-ASIDE -->
                    <div id="member-info" style="position: relative;bottom: 190px;">
                        <form action="#" class="contact-form" style="position: relative;left: 7%;">
                            <div class="col-lg-12">
                                <h4 style="text-align: left; margin-bottom: 3%;">나의 신고 내역</h4>
                            </div>

                            <div class="col-lg-12">
                                <div class="inbox-top">
                                    <div class="inbox" style="width: 8%; text-align: left; position: relative; right: 22px;">선택</div>
                                    <div class="inbox" style="    text-align: left;position: relative;left: 10px; width: 25%;">제목</div>
                                    <div class="inbox" style="width: 40%;">내용</div>
                                    <div class="inbox" style="    position: relative;text-align: right;right: 10px; width: 25%;">답변</div>
                                </div>
                            </div>

                            <div class="col-lg-12">
                            <c:forEach items="${sList }" var="report" varStatus="index">
                                <div class="inbox-top2">
                                    <div class="inbox" style="width: 6%; text-align: left; position: relative; right: 22px;"><input type="checkbox" style="width: 17px; height: 17px;"></div>
                                    <div class="inbox" style="    text-align: left;position: relative;left: 10px; width: 25%;">${report.reportTitle }</div>
                                    <div class="inbox" style="width: 40%;">${report.reportContents }</div>
                                    <div class="inbox" style="    position: relative;text-align: right;right: 10px; width: 25%;">
                                    <c:if test="${report.answer eq 0 }">
                                     	대기 
                                    </c:if>
                                    <c:if test="${report.answer eq 1 }">
                                     	완료
                                    </c:if>
                                    </div>
                                </div>
                            </c:forEach>
                                <button type="submit" style="margin-top: 9%;">삭제</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Contact Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer-section" style="text-align: center;">
        <div class="container">
            <div>
                <div>
                   
                        <div class="logo">
                            <a href="./index.html">
                                <img src="./img/로고6.png" alt="">
                            </a>
                        <p>여기도 글씨 들어가요~</p>
                    </div>
                </div>
                <div class="col-lg-6 offset-lg-1">
       

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="copyright-text">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->
    
    <!-- Search model -->
	<div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search model end -->
    
    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>