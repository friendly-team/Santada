<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="clubPost.model.vo.ClubPost"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>소모임 리스트</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"href="${pageContext.request.contextPath}/css/bootstrap.min.css"type="text/css">
<link rel="stylesheet"href="${pageContext.request.contextPath}/css/font-awesome.min.css"type="text/css">
<link rel="stylesheet"href="${pageContext.request.contextPath}/css/nice-select.css"type="text/css">
<link rel="stylesheet"href="${pageContext.request.contextPath}/css/slicknav.min.css"type="text/css">
<link rel="stylesheet"href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<meta name="description" content="Yoga Studio Template">
<meta name="keywords" content="Yoga, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<style>

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
          width: 1000px;
      }
	  table.type11 td {
		width: 155px;
		padding: 10px;
        font-weight: normal;
        font-size: 10pt;
		vertical-align: top;
		border-bottom: 1px solid #ccc;
		background: #eee;
      
	  }
      #divserach{
          height: 40px;
          width: 300px;
          background-color: #ffffff;
          display: inline-flex;
          float: left;
      }
      #search {
            font-size: 16px;
            width: 325px;
            padding: 10px;
            border: 0;
            outline: none;
            float: left;
            background-color: #F5F6FA;
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
                                <li><a href="/club/join">소모임가입</a></li>
                                <li><a href="/club/create">소모임생성</a></li>
                                <li><a href="/club/list">소모임 리스트</a></li>
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
	<section style="width: 100%; height: 900px;">
		<h2 style="position: relative; top: 3%; left: 3%;">소모임 리스트</h2>
		<hr style="position: relative; top: 3%; background-color: D3D3D3;">
		<div style="width: 100%; height: 80%; position: relative; top: 3%; text-align: center;">
			<table class="type11" style="position: relative;top: 3%; margin-left: auto; margin-right: auto;">
				<tr>
					<th>소모임장</th>
					<th>소모임명</th>
					<th>생성일</th>
				</tr>
				<c:forEach items="${cList }" var ="cOne" varStatus="index">
					<tr>
						<td>${cOne.userId }</td>
						<td><a href="/club/detail?clubNo=${cOne.clubNo }">${cOne.clubName }</a></td>
						<td>${cOne.clubCreateDate }</td>
					</tr>
				</c:forEach>
					<tr>
						<td colspan="5" align="center" style="font-size: 13pt;">
							${pageNavi }
						</td>
					</tr>
			</table>
			<!-- 여기서 serch작업 -->
			<form action="/club/search" method="post" style="display: inline; position: relative; right: 28.4%;">
				<input type="text" placeholder="소모임명을 입력하세요" name="keyword">
				<input type="submit" value="검색">
			</form>
		</div>
	</section>
	<footer class="footer-section" style="text-align: center;">
		<div class="container">
			<div>
				<div>
					<div class="logo">
						<a href="../index.jsp"> <img src="../imgs/로고6.png" alt="">
						</a>
						<p>Friendly-Team SeungTaek Kwon</p>
					</div>
				</div>
				<div class="col-lg-6 offset-lg-1"></div>
				<div class="row">
					<div class="col-lg-12">
						<div class="copyright-text">
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</div>
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