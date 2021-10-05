<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="club.model.vo.Club"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소모임 소개</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/nice-select.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<meta name="description" content="Yoga Studio Template">
<meta name="keywords" content="Yoga, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	background: #ce4869;
}

table.type11 th:nth-child(2) {
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

#divserach {
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
		<section style="height: 900px; width: 100%; text-align: center;">
			<div style="height: 100px; width: 100%;"></div>
			<div>
			<h5 style="display: inline;">소모임 이름 : </h5>
			<input style=" position: relative; left: 1%;" type="text" value="${club.clubName }" readonly="readonly">
			</div>
			<div style="margin-top: 1%;">
			<h5 style="display: inline; position: relative; right: 0.7%;">소모임장 : </h5>
			<input style="position: relative; left: 1.5%;" type="text" value="${club.userId }">
			</div>
			<div style="margin-top: 1%;">
			<h5 style="display: inline; position: relative; right: 0.6%;">활동 지역 : </h5>
			<input style="position: relative; left: 1.4%;" type="text" value="${club.clubRegion }">
			</div>
			<div style="margin-top: 1%;">
			<h5 style="display: inline; position: relative; right: 0.6%;">모집 연령 : </h5>
			<input style="position: relative; left: 1.4%;" type="text" value="${club.clubAge }대">
			</div>
			<div style="margin-top: 1%;">
			<h5 style="display: inline; position: relative; left: 0.3%;">소모임 생성일 : </h5>
			<input style="position: relative; left: 0.5%;" type="text" value="${club.clubCreateDate }">
			</div>
			<div style="margin-top: 1%;">
			<h5 style="display: inline; position: relative; left: 0.3%;">소모임 회원수 : </h5>
			<input style="position: relative; left: 0.5%;" type="text" value="${clubPersonnel }">	
			</div>
			<div style="margin-top: 1%;">
			<h5 style="position: relative; right: 5.5%;">소모임 소개 </h5>
			<textarea style="position: relative; left: 2.3%; margin-top: 1%;" rows="7;" cols="50" readonly="readonly">${club.clubIntroduce }</textarea>
			</div>
			&nbsp;&nbsp;&nbsp;
			<form style="display: inline;" action="/club/join" method="get">
			<input style="display: inline;"type="submit" value="가입하기">
			<input type="hidden" value="${club.clubName }" name="club-name">
			</form> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<form style="display: inline;" action="/club/list" method="get">
			
			<input type="submit" value="뒤로가기">
			</form>
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
			<div class="search-close-switch"></div>
			<form class="search-model-form">
				<input type="text" id="search-input">
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