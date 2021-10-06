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
.t__contents {
	border: 1px solid white;
	align-items: center;
	width: 1500px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 30px;
	margin-bottom: 50px;
	border-collapse: separate;
	border-spacing: 1px;
	line-height: 1.5;
}

.t__contents tr {
	height: 50px;
}

.t__head {
	background: #b2dfdb;
	color: white;
	font-size: 1.2em;
}

.btn {
	background-color: #b2dfdb;
	align-items: center;
	color: white;
	padding: 6px;
	font-weight: bolder;
	letter-spacing: 1px;
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
						<li class="active"><a href="#">소모임</a>
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
		<section style="height: 1100px; width: 100%; text-align: center;">
			<div style="height: 100px; width: 100%;"></div>
			<table class="t__contents" style="position: relative;top: 3%; margin-left: auto; margin-right: auto;">
				<tr class="t__head" align="center">
					<th>소모임 이름</th>
				</tr>
				<tr align="center">
					<td>${club.clubName }</td>
				</tr>
				<tr class="t__head" align="center">
					<th>소모임장 아이디</th>
				</tr>
				<tr align="center">
					<td>${club.userId }</td>
				</tr>
				<tr class="t__head" align="center">
					<th>활동 지역</th>
				</tr>
				<tr align="center">
					<td>${club.clubRegion }</td>
				</tr>
				<tr class="t__head" align="center">
					<th>모집 연령</th>
				</tr>
				<tr align="center">
					<c:if test="${club.clubAge eq 0 }">
						<td>무관</td>
					</c:if>
					<c:if test="${club.clubAge ne 0 }">
						<td>${club.clubAge }대</td>
					</c:if>
				</tr>
				<tr class="t__head" align="center">
					<th>소모임 생성일</th>
				</tr>
				<tr align="center">
					<td>${club.clubCreateDate }</td>
				</tr>
				<tr class="t__head" align="center">
					<th>소모임 회원수</th>
				</tr>
				<tr align="center">
					<td>${clubPersonnel } 명</td>
				</tr>
				<tr class="t__head" align="center">
					<th>소모임 소개</th>
				</tr>
				<tr align="center">
					<td>${club.clubIntroduce }</td>
				</tr>
			</table>
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