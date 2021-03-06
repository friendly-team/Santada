<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="club.model.vo.ClubManagement"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta name="description" content="Yoga Studio Template">
<meta name="keywords" content="Yoga, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta charset="UTF-8">
    <title>신고하기</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">

    <!-- Css Styles -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">

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
    </style>
</head>

<body>
  
    <header class="header-section-other">
        <div class="container-fluid">
			<div class="logo" style="height: 100%; width: 25%;">
				<a href="../index.jsp"><img src="../imgs/로고6.png"
					style="height: 100%; width: 60%;" alt=""></a>
			</div>
            <div class="nav-menu">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                        <li><a href="#">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="/mountainPost/list">등산 인증</a></li>
                                <li><a href="/treeCampaign/write">나무심기 캠페인</a></li>
                                <li><a href="/ranking">등산 랭킹</a></li>
                            </ul>
                        </li>
                        <li  class="active"><a href="/mountain/recommend">추천코스</a></li>
                        <li><a href="/clubPost/List">소모임</a>
                            <ul class="sub-menu">
                                <li><a href="/club/join">소모임가입</a></li>
                                <li><a href="/club/join">소모임생성</a></li>
                            </ul>
                        </li>
                        <li><a href="/letter/send">쪽지</a>
                            <ul class="sub-menu">
                                <li><a href="/letter/send">쪽지작성</a></li>
                               <li><a href="/letter/inbox">받은 쪽지함</a></li>
                                <li><a href="/letter/list">보낸 쪽지함</a></li>
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
   
    <section class="contact-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <form action="#" method="post" class="contact-form">
                        <h3>신고 하기</h3>
                        <div class="col-lg-6">
                            <div style="float: left;">
                                <b>게시판&nbsp;&nbsp;&nbsp;
                                <select name="postType" id=""> 
                                <option value=" ${report.postType }"> ${report.postType }</option>      
                               </select><br></b>
                            </div>
                            <b style="line-height: 37px;">신고 유형</b>
                            <div style="position: relative; left: 440px; top: 30px;">
                                <span><select name="reportType" id="" style="position: relative; bottom: 67px;">
                                 <option value="${report.reportType }">${report.reportType }</option>
                            </select></span>
                            </div>
                        </div>
                        <div class="row">

                             <div class="col-lg-12" style="display: inherit;">
                                <input type="text" style="margin-right: 20%; font-weight: bold;display: inline-block; " readonly value="신고자 ID : ${report.userId }">
                               
                               <b style="width: 22%; position: relative; right: 5%; top: 20%; ">게시글번호</b><input type="text" name="postNo" style="font-weight: bold; " readonly value="${report.postNo}">
                            </div>
                            <div class="col-lg-12">
                                <input name="Title" type="text" placeholder="제목" value="${report.reportTitle }">
                                <textarea name="Contents" placeholder="내용">${report.reportContents }</textarea>
                            </div>
                        </div>
                           <button type="submit" onclick="openWin();" style="float: left; margin-left: 200px; background-color: deeppink; border: none;">답변하기</button>
                           </form>
                           <form action="/club/exit" method="post" class="contact-form">
                           <input type="hidden" value="${cm.userId }" name="userId">
                        <button type ="reset" onclick="moveIndex();">돌아가기</button>
                           </form>
                </div>
            </div>
        </div>
    </section>
    <!-- Contact Section End -->

  
    <footer class="footer-section" style="text-align: center;">
        <div class="container">
            <div>
                <div>
                   
          			<div class="logo">
                            <a href="../index.jsp">
                                <img src="../imgs/로고6.png" alt="">
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
    <script>
    function moveIndex(){
        location.href = "/admin/report";
   }function openWin(){  
	    window.open("/admin/letter?reportNo=${report.reportNo}&writeId=${report.userId}", "쪽지보내기", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no" );  
		
   }  
    </script>
</body>

</html>