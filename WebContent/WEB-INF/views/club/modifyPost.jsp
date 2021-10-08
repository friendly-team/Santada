<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="clubPost.model.vo.ClubPost"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>소모임 게시판</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
							</ul></li>
						<li><a href="/mountain/recommend">추천코스</a></li>
						<li class="active"><a href="/clubPost/List">소모임</a>
							<ul class="sub-menu">
								<c:set var="clubName" value="${clubName.clubName }" />
								<c:if test="${cm eq null}">
									<li><a href="/club/join">소모임가입</a></li>
									<li><a href="/club/create">소모임생성</a></li>
									<li><a href="/club/list">소모임 리스트</a></li>
								</c:if>
								<c:if test="${cm.clubNo ne null and cm.approvalPosition eq 'N'}">
									<li>${clubName}소모임가입대기중</li>
								</c:if>
								<c:if
									test="${cm.clubNo ne null and cm.clubNo ne '' and cm.approvalPosition eq 'Y' and club.userId eq null}">
									<li><a href="/clubPost/List">${clubName }소모임</a></li>
									<li><a href="/club/leave?clubNo=${cm.clubNo}">소모임탈퇴</a></li>
								</c:if>
								<c:if test="${club.userId ne null}">
									<li><a href="/clubPost/List">${clubName}소모임</a></li>
									<li><a href="/club/memberList?clubNo=${cm.clubNo }">소모임회원관리</a></li>
									<li><a href="/clubjoin/management?userId=${club.userId}">소모임승인관리</a></li>
									<li><a href="/remove/club?clubNo=${cm.clubNo}">소모임폐쇄</a></li>
								</c:if>
							</ul></li>
						<li><a href="/letter/send">쪽지</a>
							<ul class="sub-menu">
								<li><a href="/letter/send">쪽지작성</a></li>
								<li><a href="/letter/inbox">받은 쪽지함</a></li>
								<li><a href="/letter/list">보낸 쪽지함</a></li>
							</ul></li>
						<li><a href="/mypage/info">마이페이지</a></li>
					</ul>
				</nav>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
		<form action="/clubPost/modify" method="post">
			<div style="height: 900px; width: 100%;">
				<div style="height: 15%; width: 60%;">
		 			<h5 style="display: inline; position: relative; top: 20%; left: 16.7%;">제목</h5>
					<input type="text" name="clubPost-subject" value="${cp.postSubject }" style="height: 30%; width: 40%; position: relative; left: 13%; top: 55%;">
				</div>
				<div style="height: 60%; width: 100%;">
					<div style="height: 10%; width: 100%;">
						<h5 style="display:inline; position: relative; left: 10%;">내용</h5>
					</div>
					<textarea name="clubPost-contents" style="height: 90%; width: 80%; position: relative; left: 10%;">${cp.postContents }</textarea>
				</div>
				<div style="height: 25%; width: 100%; text-align: center;">
					<input type="hidden" name="post-no" value="${cp.postNo }">
					<input type="submit" value="수정완료" style="display:inline; width: 10%; height: 30%; position: relative; top: 20%;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소" style="display:inline; width: 10%; height: 30%; position: relative; top: 20%;">
				</div>
			</div>
		</form>
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