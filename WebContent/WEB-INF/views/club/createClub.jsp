<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<meta name="description" content="Yoga Studio Template">
<meta name="keywords" content="Yoga, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>소모임 생성</title>
</head>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap"
	rel="stylesheet">

<!-- Css Styles -->

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
	<!-- Header End -->
	<form action="/club/create" method="post">
		<div style="height: 900px; width: 100%;">
			<div style="height: 150px; width: 100%; ">
				<h2 style="position: relative; top: 50px; left: 50px;">소모임 만들기</h2>
				<h5 style="position: relative; top: 60px; left: 50px;">마음 맞는 멤버를 모집하고 같이 등산하세요.</h5>
				<hr style="position: relative; top: 55px; background-color: black">
			</div>
			<div style="height: 100px; width: 100%;">
				<h4 style="float: left; position: relative; left: 250px; top: 30px">소모임 이름</h4>
				<input type="text" name="club-name" placeholder="소모임 명을 입력하세요." style="position: relative; left: 300px; top: 20px; height: 40%; width: 50%;">
				<hr style="background-color: D3D3D3; position: relative; top: 25px;">
			</div>
			<div style="height: 200px; width: 100%;">
				<h4 style="float: left; position: relative; top:60px; left: 250px;">소모임 소개글</h4>
				<input type="text" name="club-introduce" placeholder="소모임의 소개글을 입력하세요." style="position: relative; left: 278px; top:30px;  height: 50%; width: 50%;">
				<hr style="background-color: D3D3D3; position: relative; top: 35px;">
			</div>
			<div>
				<div style="height: 150px; width: 100%;">
					<h4 style="float: left; position: relative; left: 13%; top: 32%;">지역</h4>
					<input type="text" name="club-region" placeholder="활동 지역을 입력하세요." style="position: relative; left: 20%; top: 28%; height: 25%; width: 20%;">
					<h4 style="position: relative;top: 34%; left: 30%; display: inline;">모집 연령대</h4>
					<select name="club-age" style="height: 20%; width: 5%; position: relative; left: 35%; top: 31%;">
						<option value="0">무관</option>
						<option value="10">10대</option>
						<option value="20">20대</option>
						<option value="30">30대</option>
						<option value="40">40대</option>
						<option value="50">50대</option>
						<option value="60">60대</option>
					</select>
					<hr style="background-color: D3D3D3; position: relative; top: 50px;">
				</div>
				<div style="height: 150px; width: 100%;">
					<h4 style="float: left; position: relative; left: 13%; top: 20%;">회원 나이</h4>
					<select name="user-age" style="height: 20%; width: 5%; position: relative; left: 17%; top: 18%;">
						<option value="10">10대</option>
						<option value="20">20대</option>
						<option value="30">30대</option>
						<option value="40">40대</option>
						<option value="50">50대</option>
						<option value="60">60대</option>
					</select>
				</div>
			</div>
			<div style="height: 150px; width: 100%; text-align: center;">
				<input type="submit" value="소모임생성" style="width: 10%; height: 40%; position: relative; top: 20%; background-color: deeppink; border: none;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소" style="width: 10%; height: 40%; position: relative; top: 20%;">
			</div>
		</div>
	</form>
	<!-- Footer Section Begin -->
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
                <div class="col-lg-6 offset-lg-1"></div>
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