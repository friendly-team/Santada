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
    <title>${clubName.clubName } 소모임 회원 가입 정보</title>

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
        span{
            display: flex;
            margin-left: 30%;
        }
        th{
            padding: 80px;
        }
        
    </style>
</head>

<body>
    <!-- Page Preloder -->

    <!-- Header Section Begin -->
    <header class="header-section-other">
        <div class="container-fluid">
			<div class="logo" style="height: 100%; width: 25%;">
				<a href="../index.jsp"><img src="../imgs/로고6.png"
					style="height: 100%; width: 60%;" alt=""></a>
			</div>
            <div class="nav-menu">
                <nav class="main-menu mobile-menu">
					<ul>
					  <li><a href="/index.jsp">Home</a></li>
                        <li><a href="/mountainPost/list">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="/mountainPost/list">등산 인증</a></li>
                                <li><a href="/treeCampaign/write">나무심기 캠페인</a></li>
                                <li><a href="/ranking">등산 랭킹</a></li>
                            </ul>
                        </li>
						<li><a href="/mountain/recommend">추천코스</a></li>
						<li class="active"><a href="#">소모임</a>
							<ul class="sub-menu">
      							<li><a href="/clubPost/List">${clubName.clubName}소모임</a></li>
                                <li><a href="/club/memberList?clubNo=${cm.clubNo }">소모임회원관리</a></li>
                                <li><a href="/clubjoin/management?userId=${club.userId}">소모임승인관리</a></li>
                                <li><a href="/remove/club?clubNo=${cm.clubNo}">소모임폐쇄</a></li>
							</ul>
						</li>
                        <li><a href="/letter/send">쪽지</a>
                            <ul class="sub-menu">
                                <li><a href="/letter/send">쪽지작성</a></li>
                                <li><a href="/letter/inbox">받은 쪽지함</a></li>
                                <li><a href="/letter/list">보낸 쪽지함</a></li>
                            </ul>
                        </li>
						 <li><a href="/mypage/info">마이페이지</a></li>
					</ul>
				</nav>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Hero Search Section Begin -->
    <section class="contact-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <form action="/clubMember/detail" class="contact-form" method="post">
                        <h3>회원정보</h3><br><br><br>
                        <span style="display: flex;float: left;">
                            닉네임 <input type="text" value="${cm.userName }" name="" id="" style="height: 30px; width: 130px;text-align: center; " readonly>
                        </span>
                        <span>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            아이디<input type="text" value="${cm.userId }" name="userId" id="" style="height: 30px; width: 200px;text-align: center; " readonly>
                        </span>
                        <br><br>
                        <span style="display: flex; float: left;" >
                           나이&nbsp;&nbsp;&nbsp;<input type="number" value="${cm.userAge }" name="" id="" style="height: 30px; width: 100px; " readonly></span>
                        <span>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            신청일 <input type="text" value="${cm.joinDate }" name="" id="" style="height: 30px; width: 140px; " readonly>
                        </span>
                        <br><br>
                 <table>
                     <tr>
                          <th>  
                           		자기소개 <textarea style="width: 90%; "  name="" id="" cols="30" rows="10" readonly>${cm.userIntroduce }
                                      </textarea>  
                          </th>
                          <th>
                                                                       가입경로<textarea style="width: 90%;"  name="" id="" cols="30" rows="10" readonly>${cm.joinRoute }
                                    </textarea>
                          </th>
                    </tr>
                 </table>
						  <c:if test="${club.userId ne cm.userId }">
                        <button type="submit" style="float: left; margin-left: 200px; background-color: deeppink; border: none;">강퇴하기</button> 
                           </c:if>
                           </form>
                           <form action="/club/exit" method="post" class="contact-form">
                           <input type="hidden" value="${cm.userId }" name="userId">
                        <button type ="reset" onclick="moveIndex();">돌아가기</button>
                           </form>
                </div>
            </div>
        </div>
    </section>
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
     location.href = "/club/memberList";
}
</script>
</body>

</html>