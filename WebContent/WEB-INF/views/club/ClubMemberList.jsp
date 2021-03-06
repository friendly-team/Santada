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
    <title>${clubName.clubName } 소모임 회원리스트</title>

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
            font-weight: normal;
            display: flex;
        }
        table.type11 {
		border-collapse: separate;
		border-spacing: 1px;
		text-align: center;
		line-height: 1.5;
		margin: 20px 10px;
	  }
	  table.type11 th {
		width: 155px;
		padding: 10px;
		font-weight: bold;
		vertical-align: top;
		color: #fff;
		background: #ce4869 ;
	  }
      table.type11 th:nth-child(2){
          width: 400px;
      }
	  table.type11 td {
		width: 155px;
		padding: 10px;
        font-weight: normal;
        font-size: 10pt;
		vertical-align: top;
		border-bottom: 1px solid #ccc;
		background: #eee;
	  } #idSerach{
          height: 50px;
          width: 25%;
          background-color: #ffffff;
          display: inline-flex;
          margin-left: 61%;
      }
      #search {
            font-size: 16px;
            padding: 0%;
            outline: none;
            float: left;
            background-color: #F5F6FA;
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
						<li class="active"><a href="/clubPost/List">소모임</a>
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
                        <div style="margin-right: 20px;   float: left; width: 140px; height: 40px; border-radius: 10px;"><a href="/club/memberList?userId=${userId}" > 소모임 회원관리</a></div>
                       <div style="float: left; font-weight: normal; color: white; width: 100px; height: 40px; border-radius: 10px;"><a href="/clubjoin/management?userId=${userId} style='font-weight: normal;' ">승인관리</a></div>
                        <br><br><br><hr>
                        <table class="type11">
                           
                            <tr>
                              <th scope="cols">이름</th>
                              <th scope="cols">아이디</th>
                              <th scope="cols">나이</th>
                              <th scope="cols">가입일</th>
                              <th scope="cols">직급</th>
                            </tr>
                            
                            <c:forEach items="${cmList }" var = "cm" varStatus="index">
                         
                            <tr>
                              <td>${cm.userName }</td>
                              <td><a href="/clubMember/detail?userId=${cm.userId }">${cm.userId }</a></td>
                              <td>${cm.userAge }</td>
                              <td>${cm.joinDate }</td>
                              
                              <c:set var="position" value="${cm.userPosition }" />
                              <c:if test="${position eq '0'}">
                              <td>소모임장</td>
                              </c:if>
                              <c:choose> 
                                <c:when test="${position eq '1'}">
                              <td>회원</td>
                              </c:when>
                              </c:choose>
                            </tr>
                            </c:forEach>
                            <tr>
                            <td colspan="5" align="center" style="font-size: 15pt; margin: 0px 10px;">
                                  ${pageNavi}
                            </td>
                            </tr>
             
                             
                          </table>
                    <form action="/club/memberSearch" method="get" class="contact-form">
                        <div id="idSerach">
	                        <input type="text" name="searchKeyword" id="search" style="width: 90%; height: 40px;"placeholder="아이디검색"><!-- 검색창 인풋 -->
	                        <input type="submit" style="width: 40%; height: 80%; padding: 0px; font-size: 11pt;background-color : black; color : white"  value="검색">
                      	</div>
                    </form>

                </div>
            </div>
            <hr>
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
                        <p>Friendly-Team Woobin-Jeon</p>
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