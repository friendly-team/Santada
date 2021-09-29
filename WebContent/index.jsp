<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<link rel="stylesheet" href="css/animatedLogin.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nice-select.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slicknav.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<%-- 	<% if(studentId == null) { %> --%>
	<c:if test="${sessionScope.userId eq null }">
		<header class="header-section">
        <div class="container">
            <div class="logo">
                <a href="/index.jsp"><img src="${pageContext.request.contextPath}/imgs/로고5.png" alt=""></a>
            </div>
            <div class="nav-menu" style="width: 100%;">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="about-me.html">등산인증</a></li>
                                <li><a href="categories.html">등산후기</a></li>
                                <li><a href="recipe.html">랭킹</a></li>
                            </ul>
                        </li>
                        <li><a href="recipe.html">추천코스</a></li>
                        <li><a href="./member/login.jsp" onclick="alert('회원만 이용 가능한 서비스입니다.')">소모임</a>
                            <ul class="sub-menu">
                                <li><a href="./member/login.jsp" onclick="alert('회원만 이용 가능한 서비스입니다.')">소모임가입</a></li>
                                <li><a href="./member/login.jsp" onclick="alert('회원만 이용 가능한 서비스입니다.')">소모임생성</a></li>
                            </ul>
                        </li>
                        <li><a href="/DM/Letter.jsp">쪽지</a>
                            <ul class="sub-menu">
                                <li><a href="/DM/Letter.jsp">쪽지작성</a></li>
                                <li><a href="#">보관함</a></li>
                            </ul>
                        </li>
                        <li style="display: inline-block;"><a href="/member/login">로그인</a></li>
                        <li style="display: none;"><a href="#">마이페이지</a></li>
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
            <div class="row">
                <div class="col-lg-6 order-lg-2">
                    <div class="pt-recipe-item large-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <span>March 10, 2019</span>
                            <h3>설악산 갔다왔어요~</h3>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 order-lg-1">
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <h4>Raw Vegan Carrot Cake Bites with Avocado</h4>
                        </div>
                    </div>
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <h4>One Pot Weeknight Lasagna Soup Recipe</h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 order-lg-3">
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <h4>Beef Burger with French Fries and Salad</h4>
                        </div>
                    </div>
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <h4>Raspberry Pancakes with Honey and Butter</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Footer Section Begin -->
    <footer class="footer-section" style="text-align: center;">
        <div class="container">
            <div>
                <div>
                        <div class="logo">
                            <a href="./index.html">
                                <img src="${pageContext.request.contextPath}/imgs/로고6.png" alt="">
                            </a>
                        <p>여기에는 이제 글씨가 들어갑니다!</p>
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
<%-- 	<% } %> --%>
<%-- 	<% if(studentId != null && studentId != "") { %> --%>
	<c:if test="${userId ne null and userId ne ''}">
	<header class="header-section">
        <div class="container">
            <div class="logo">
                <a href="/index.html"><img src="${pageContext.request.contextPath}/imgs/로고5.png" alt=""></a>
            </div>
            <div class="nav-menu" style="width: 100%;">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="about-me.html">등산인증</a></li>
                                <li><a href="categories.html">등산후기</a></li>
                                <li><a href="recipe.html">랭킹</a></li>
                            </ul>
                        </li>
                        <li><a href="recipe.html">추천코스</a></li>
                        <li><a href="#">소모임</a>
                            <ul class="sub-menu">
                                <c:if test="${cm.clubNo eq null}">
                                <li><a href="/club/join">소모임가입</a></li>
                                <li><a href="/club/create">소모임생성</a></li>
                                </c:if>
                            	<c:if test="${cm.clubNo ne null and cm.approvalPosition eq 'N'}">
                                <li>소모임가입대기중</li>
                                </c:if>
                                <c:if test="${cm.clubNo ne null and cm.clubNo ne '' and cm.approvalPosition eq 'Y' and club.userId eq null}">
                                <li><a href="/club/ClubJoin.jsp">ㅁㅁ소모임</a></li>
                                <li><a href="/club/createClub.jsp">소모임탈퇴</a></li>
                                </c:if>
                                <c:if test="${club.userId ne null and clubNo ne ''}">
                                <li><a href="/club/ClubJoin.jsp">ㅁㅁ소모임</a></li>
                                <li><a href="/club/createClub.jsp">소모임회원관리</a></li>
                                <li><a href="/clubjoin/management?clubNo=${cm.clubNo }&userId=${club.userId}">소모임승인관리</a></li>
                                <li><a href="/club/createClub.jsp">소모임폐쇠</a></li>
                                </c:if>
                            </ul>
                        </li>
                        <li><a href="/DM/Letter.jsp">쪽지</a>
                            <ul class="sub-menu">
                                <li><a href="/DM/Letter.jsp">쪽지작성</a></li>
                                <li><a href="#">보관함</a></li>
                            </ul>
                        </li>
                        <li style="display: none;"><a href="login.html">로그인</a></li>
                        <li style="display: inline-block;"><a href="#">마이페이지</a></li>
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
            <div class="row">
                <div class="col-lg-6 order-lg-2">
                    <div class="pt-recipe-item large-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <span>March 10, 2019</span>
                            <h3>설악산 갔다왔어요~</h3>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 order-lg-1">
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <h4>Raw Vegan Carrot Cake Bites with Avocado</h4>
                        </div>
                    </div>
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <h4>One Pot Weeknight Lasagna Soup Recipe</h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 order-lg-3">
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <h4>Beef Burger with French Fries and Salad</h4>
                        </div>
                    </div>
                    <div class="pt-recipe-item">
                        <div class="pt-recipe-img set-bg" data-setbg="">
                            <i class="fa fa-plus"></i>
                        </div>
                        <div class="pt-recipe-text">
                            <h4>Raspberry Pancakes with Honey and Butter</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Footer Section Begin -->
    <footer class="footer-section" style="text-align: center;">
        <div class="container">
            <div>
                <div>
                        <div class="logo">
                            <a href="./index.html">
                                <img src="${pageContext.request.contextPath}/imgs/로고6.png" alt="">
                            </a>
                        <p>여기에는 이제 글씨가 들어갑니다!</p>
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

</html>

