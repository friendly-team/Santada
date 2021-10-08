<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="mountainPost.model.vo.MountainPost"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Santada</title>
<link rel="stylesheet" href="css/animatedLogin.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nice-select.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slicknav.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
	<c:if test="${sessionScope.userId eq null }">
		<header class="header-section">
        <div class="container">
            <div class="logo">
                <a href="/index.jsp"><img src="${pageContext.request.contextPath}/imgs/로고5.png" alt=""></a>
            </div>
            <div class="nav-menu" style="width: 100%;">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="/show/main.jsp">Home</a></li>
                        <li><a href="/member/login" onclick="alert('회원만 이용 가능한 서비스입니다.')">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="/member/login" onclick="alert('회원만 이용 가능한 서비스입니다.')">등산 인증</a></li>
                                <li><a href="/member/login" onclick="alert('회원만 이용 가능한 서비스입니다.')">나무심기 캠페인</a></li>
                                <li><a href="/ranking">등산 랭킹</a></li>
                            </ul>
                        </li>
                        <li><a href="/mountain/recommend">추천코스</a></li>
                        <li><a href="/member/login" onclick="alert('회원만 이용 가능한 서비스입니다.')">소모임</a>
                            <ul class="sub-menu">
                                <li><a href="/member/login" onclick="alert('회원만 이용 가능한 서비스입니다.')">소모임가입</a></li>
                                <li><a href="/member/login" onclick="alert('회원만 이용 가능한 서비스입니다.')">소모임생성</a></li>
                            </ul>
                        </li>
                        <li><a href="/member/login" onclick="alert('회원만 이용 가능한 서비스입니다.')">쪽지</a>
                            <ul class="sub-menu">
                                <li><a href="/member/login" onclick="alert('회원만 이용 가능한 서비스입니다.')">쪽지작성</a></li>
                                <li><a href="/member/login" onclick="alert('회원만 이용 가능한 서비스입니다.')">받은 쪽지함</a></li>
                                <li><a href="/member/login" onclick="alert('회원만 이용 가능한 서비스입니다.')">보낸 쪽지함</a></li>
                            </ul>
                        </li>
                        <li style="display: inline-block;"><a href="/member/login">로그인</a></li>
                        <li style="display: none;"><a href="/mypage/info">마이페이지</a></li>
                        <li style="display: none;"><a href="/member/logout">로그아웃</a></li>
                    </ul>

                </nav>
                
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Page Top Recipe Section Begin -->
    <section class="page-top-recipe">
        <div class="container">
        	<c:forEach items="${mList}" var="mountainCourse" begin="0" end="0">
            <div class="row">
                <div class="col-lg-6 order-lg-2">
                    <div class="pt-recipe-item large-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                             <img src="${pageContext.request.contextPath}/imgs/main1.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                        <!--  사진사진사진사진사진 -->
                        <!-- <img src="${pageContext.request.contextPath}/mtUpload/${mFileOne.fileName}" alt=""> -->
                        
                            <h3><a href="/member/login" onclick="alert('산타다 회원만 조회 가능합니다.')">
                            ${mList[0].mountainPostSubject}</a></h3>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 order-lg-1">
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                             <img src="${pageContext.request.contextPath}/imgs/main2.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                            <h4><a href="/member/login" onclick="alert('산타다 회원만 조회 가능합니다.')">
                            ${mList[1].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                             <img src="${pageContext.request.contextPath}/imgs/main3.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                            <h4><a href="/member/login" onclick="alert('산타다 회원만 조회 가능합니다.')">
                            ${mList[2].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 order-lg-3">
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                             <img src="${pageContext.request.contextPath}/imgs/main4.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                            <h4><a href="/member/login" onclick="alert('산타다 회원만 조회 가능합니다.')">
                            ${mList[3].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                             <img src="${pageContext.request.contextPath}/imgs/main5.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                           <h4><a href="/member/login" onclick="alert('산타다 회원만 조회 가능합니다.')">
                            ${mList[4].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </section>
    <!-- Footer Section Begin -->
    <footer class="footer-section" style="text-align: center;">
        <div class="container">
            <div>
                <div>
                        <div class="logo">
                            <a href="/index.jsp">
                                <img src="${pageContext.request.contextPath}/imgs/로고6.png" alt="">
                            </a>
                        <p>Friendly-team ｜ Seungtaek-Kwon&nbsp;&nbsp;&nbsp;Hyeonjong-Oh&nbsp;&nbsp;&nbsp;Seokin-Yun&nbsp;&nbsp;&nbsp;Woobin-Jeon&nbsp;&nbsp;&nbsp;Ahram-Jeong&nbsp;&nbsp;&nbsp;Jungeun-Chae</p>
                    </div>
                </div>
                <div class="col-lg-6 offset-lg-1">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="copyright-text" style="text-align: center;">
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
     
	</c:if>
</body>
</html>
	<c:if test="${userId ne null and userId ne 'admin'}">
	<header class="header-section">
        <div class="container">
            <div class="logo">
                <a href="/index.jsp"><img src="${pageContext.request.contextPath}/imgs/로고5.png" alt=""></a>
            </div>
            <div class="nav-menu" style="width: 100%;">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="/show/main.jsp">Home</a></li>
                        <li><a href="/mountainPost/list">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="/mountainPost/list">등산 인증</a></li>
                                <li><a href="/treeCampaign/write">나무심기 캠페인</a></li>
                                <li><a href="/ranking">등산 랭킹</a></li>
                            </ul>
                        </li>
                        <li><a href="/mountain/recommend">추천코스</a></li>
                        <li><a href="/clubPost/List">소모임</a>
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
                                <c:if test="${cm.clubNo ne null and cm.clubNo ne '' and cm.approvalPosition eq 'Y' and club.userId eq null}">
                                <li><a href="/clubPost/List">${clubName }소모임</a></li>
                                <li><a href="/club/leave?clubNo=${cm.clubNo}">소모임탈퇴</a></li>
                                </c:if>
                                <c:if test="${club.userId ne null}">
                                <li><a href="/clubPost/List">${clubName}소모임</a></li>
                                <li><a href="/club/memberList?clubNo=${cm.clubNo }">소모임회원관리</a></li>
                                <li><a href="/clubjoin/management?userId=${club.userId}">소모임승인관리</a></li>
                                <li><a href="/remove/club?clubNo=${cm.clubNo}">소모임폐쇄</a></li>
                                </c:if>
                            </ul>
                        </li>
                        <li><a href="/letter/send">쪽지</a>
                            <ul class="sub-menu">
                                <li><a href="/letter/send">쪽지작성</a></li>
                                <li><a href="/letter/inbox">받은 쪽지함</a></li>
                                <li><a href="/letter/list">보낸 쪽지함</a></li>
                            </ul>
                        </li>
                        <li style="display: none;"><a href="/login/home">로그인</a></li>
                        <li style="display: inline-block;"><a href="/mypage/info">마이페이지</a></li>
                        <li style="display: inline-block; margin-right: -11px;"><a href="/member/logout">로그아웃</a></li>
                    </ul>

                </nav>
                
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Page Top Recipe Section Begin -->
    <section class="page-top-recipe">
        <div class="container">
        	<c:forEach items="${mList}" var="mountainCourse" begin="0" end="0">
            <div class="row">
                <div class="col-lg-6 order-lg-2">
                    <div class="pt-recipe-item large-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                        <img src="${pageContext.request.contextPath}/imgs/main1.jpg" alt="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <h3><a href="/mountainPost/detail?mountainPostNo=${mList[0].mountainPostNo}">
                            ${mList[0].mountainPostSubject}</a></h3>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 order-lg-1">
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg">
                       	<img src="${pageContext.request.contextPath}/imgs/main2.jpg" alt="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <h4><a href="/mountainPost/detail?mountainPostNo=${mList[1].mountainPostNo}">
                            ${mList[1].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                            <img src="${pageContext.request.contextPath}/imgs/main3.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                            <h4><a href="/mountainPost/detail?mountainPostNo=${mList[2].mountainPostNo}">
                            ${mList[2].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 order-lg-3">
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                            <img src="${pageContext.request.contextPath}/imgs/main4.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                            <h4><a href="/mountainPost/detail?mountainPostNo=${mList[3].mountainPostNo}">
                            ${mList[3].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                            <img src="${pageContext.request.contextPath}/imgs/main5.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                           <h4><a href="/mountainPost/detail?mountainPostNo=${mList[4].mountainPostNo}">
                            ${mList[4].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </section>
    <!-- Footer Section Begin -->
    <footer class="footer-section" style="text-align: center;">
        <div class="container">
            <div>
                <div>
                        <div class="logo">
                            <a href="../index.jsp">
                                <img src="${pageContext.request.contextPath}/imgs/로고6.png" alt="">
                            </a>
                        <p>Friendly-team ｜ Seungtaek-Kwon&nbsp;&nbsp;&nbsp;Hyeonjong-Oh&nbsp;&nbsp;&nbsp;Seokin-Yun&nbsp;&nbsp;&nbsp;Woobin-Jeon&nbsp;&nbsp;&nbsp;Ahram-Jeong&nbsp;&nbsp;&nbsp;Jungeun-Chae</p>
                    </div>
                </div>
                <div class="col-lg-6 offset-lg-1">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="copyright-text" style="text-align: center;">
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
    if (self.name != 'reload') {
        self.name = 'reload';
        self.location.reload(true);
    }
    else self.name = ''; 
    </script>
    </c:if>
</body>
	 <c:if test="${userId eq 'admin' }">
	<header class="header-section">
        <div class="container">
            <div class="logo">
                <a href="/index.jsp"><img src="${pageContext.request.contextPath}/imgs/로고5.png" alt=""></a>
            </div>
            <div class="nav-menu" style="width: 100%;">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="../index.jsp">Home</a></li>
                        <li><a href="/mountainPost/list">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="/mountainPost/list">등산 인증</a></li>
                                <li><a href="/treeCampaign/write">나무심기 캠페인</a></li>
                                <li><a href="/ranking">등산 랭킹</a></li>
                            </ul>
                        </li>
                        <li><a href="/mountain/recommend">추천코스</a></li>
                        <li><a href="#">소모임</a>
                            <ul class="sub-menu">
                                <li><a href="#">소모임가입</a></li>
                                <li><a href="#">소모임생성</a></li>
                            </ul>
                        </li>
                        <li><a href="/letter/send">쪽지</a>
                            <ul class="sub-menu">
                                <li><a href="/letter/send">쪽지작성</a></li>
                                <li><a href="/letter/inbox">받은 쪽지함</a></li>
                                <li><a href="/letter/list">보낸 쪽지함</a></li>
                            </ul>
                        </li>
                        <li style="display: none;"><a href="/member/login">로그인</a></li>
                        <li style="display: inline-block;"><a href="/admin/report"">관리 페이지</a></li>
                        <li style="display: inline-block; margin-right: -11px;"><a href="/member/logout">로그아웃</a></li>
                    </ul>

                </nav>
                
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Page Top Recipe Section Begin -->
   
    <section class="page-top-recipe">
        <div class="container">
        	<c:forEach items="${mList}" var="mountainCourse" begin="0" end="0">
            <div class="row">
                <div class="col-lg-6 order-lg-2">
                    <div class="pt-recipe-item large-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                             <img src="${pageContext.request.contextPath}/imgs/main1.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                            <h3><a href="/mountainPost/detail?mountainPostNo=${mList[0].mountainPostNo}">
                            ${mList[0].mountainPostSubject}</a></h3>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 order-lg-1">
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                             <img src="${pageContext.request.contextPath}/imgs/main2.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                            <h4><a href="/mountainPost/detail?mountainPostNo=${mList[1].mountainPostNo}">
                            ${mList[1].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                             <img src="${pageContext.request.contextPath}/imgs/main3.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                            <h4><a href="/mountainPost/detail?mountainPostNo=${mList[2].mountainPostNo}">
                            ${mList[2].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 order-lg-3">
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                             <img src="${pageContext.request.contextPath}/imgs/main4.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                            <h4><a href="/mountainPost/detail?mountainPostNo=${mList[3].mountainPostNo}">
                            ${mList[3].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                             <img src="${pageContext.request.contextPath}/imgs/main5.jpg" alt="">
                        </div>
                        <div class="pt-recipe-text">
                           <h4><a href="/mountainPost/detail?mountainPostNo=${mList[4].mountainPostNo}">
                            ${mList[4].mountainPostSubject}</a></h4>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </section>
    <!-- Footer Section Begin -->
    <footer class="footer-section" style="text-align: center;">
        <div class="container">
            <div>
                <div>
                        <div class="logo">
                            <a href="../index.jsp">
                                <img src="${pageContext.request.contextPath}/imgs/로고6.png" alt="">
                            </a>
                        <p>Friendly-team ｜ Seungtaek-Kwon&nbsp;&nbsp;&nbsp;Hyeonjong-Oh&nbsp;&nbsp;&nbsp;Seokin-Yun&nbsp;&nbsp;&nbsp;Woobin-Jeon&nbsp;&nbsp;&nbsp;Ahram-Jeong&nbsp;&nbsp;&nbsp;Jungeun-Chae</p>
                    </div>
                </div>
                <div class="col-lg-6 offset-lg-1">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="copyright-text" style="text-align: center;">
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
    </c:if> 
</html>
