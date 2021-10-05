<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="clubPost.model.vo.ClubPost"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>소모임 게시판</title>
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
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">등산인증</a>
							<ul class="sub-menu">
								<li><a href="about-me.html">About Me</a></li>
								<li><a href="categories.html">Categories</a></li>
								<li><a href="recipe.html">Recipe</a></li>
								<li><a href="blog.html">Blog</a></li>
								<li><a href="contact.html">Contact</a></li>
							</ul></li>
						<li><a href="recipe.html">추천코스</a></li>
						<li><a href="#">소모임</a></li>
						<li><a href="contact.html">마이페이지</a></li>
					</ul>
				</nav>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<section style="width: 100%; height: 900px;">
		<h2 style="position: relative; top: 3%; left: 3%;">${clubName } 게시판</h2>
		<hr style="position: relative; top: 3%; background-color: D3D3D3;">
		<div style="width: 100%; height: 80%; position: relative; top: 3%; text-align: center;">
			<table class="type11" style="position: relative; left: 6.5%; top: 3%;">
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>추천수</th>
				</tr>
				<c:forEach items="${cpList }" var ="cpOne" varStatus="index">
					<tr>
						<td>${cpOne.postNo }</td>
						<td><a href="/clubPost/detail?postNo=${cpOne.postNo }">${cpOne.postSubject }</a></td>
						<td>${cpOne.userId }</td>
						<td>${cpOne.writeDate }</td>
						<td>${cpOne.recommend }</td>
					</tr>
				</c:forEach>
					<tr>
						<td colspan="5" align="center" style="font-size: 13pt;">
							${pageNavi }
						</td>
					</tr>
			</table>
			<!-- 여기서 serch작업 -->
			<form action="/clubPost/search" method="post" style="display: inline; position: relative; right: 34.8%;">
				<input type="text" placeholder="제목을 입력하세요" name="keyword">
				<input type="hidden" value="">
				<input type="submit" value="검색">
			</form>
			<form style="display: inline; position: relative; left: 34.4%;" action="/clubPost/write" method="get">
				<input type="submit" value="글쓰기">
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
						<p>여기도 글씨 들어가요~</p>
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