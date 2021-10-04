<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Yoga Studio Template">
    <meta name="keywords" content="Yoga, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SANTADA | 추천코스</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nice-select.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slicknav.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>
    <!-- Page Preloder -->

    <!-- Header Section Begin -->

    <!-- Hero Search Section Begin -->
     <header class="header-section-other">
        <div class="container-fluid">
            <div class="logo" style="height: 100%; width: 25%;">
                <a href="../index.jsp" ><img src="../imgs/로고6.png" style="height: 100%; width: 60%;" alt=""></a>
            </div>
            <div class="nav-menu">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li><a href="../index.jsp">Home</a></li>
                        <li><a href="#">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="/mountainPost/write">등산인증</a></li>
                                <li><a href="categories.html">등산후기</a></li>
                                <li><a href="recipe.html">랭킹</a></li>
                            </ul>
                        </li>
                        <li  class="active"><a href="/mountain/recommend">추천코스</a></li>
                        <li><a href="categories.html">소모임</a>
                            <ul class="sub-menu">
                                <li><a href="#">소모임가입</a></li>
                                <li><a href="#">소모임생성</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.html">쪽지</a>
                            <ul class="sub-menu">
                                <li><a href="#">쪽지작성</a></li>
                                <li><a href="#">보관함</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Hero Search Section Begin -->
    <div class="hero-search set-bg"  data-setbg="imgs/등산.jpg">
        <div class="container">
            <div class="filter-table">
                <form action="/mountain/list" class="filter-search" method="get">
                    <select name="mountainRegion" id="region" class="nice-select">
		            <option value="서울">서울</option>
		            <option value="경기도">경기도</option>
		            <option value="충청도">충청도</option>
		            <option value="전라도">전라도</option>
		            <option value="경상도">경상도</option>
		            <option value="강원도">강원도</option>
		            <option value="제주도">제주도</option>
                    </select>
                    <select name="mountainTime" id="time" class="nice-select">
                        <option value="1">1시간이내</option>
                        <option value="2">1시간-2시간</option>
                        <option value="3">2시간-3시간</option>
                        <option value="4">3시간-4시간</option>
                        <option value="5">4시간-5시간</option>
                        <option value="6">장거리</option>
                    </select>
                    <select name="mountainLevel"  id="level" class="nice-select">
			            <option value="1">★</option>
			            <option value="2">★★</option>
			            <option value="3">★★★</option>
			            <option value="4">★★★★</option>
			            <option value="5">★★★★★</option>
                    </select>
                    <input type="submit" value="Search">
                </form>
            </div>
        </div>
    </div>
    <!-- Hero Search Section end -->
    <!-- Recipe Section Begin -->
    <section class="recipe-section spad">
        <div class="container">
            	<h3> ${pList[0].mountainName} ${pList[0].mountainCourse}는 어떠세요?</h3>
            	<br>
				<ul> 
					<li> 소요시간 : ${pList[0].mountainTime} 시간</li>
					<li> 코스길이 : ${mList[0].mountainLength} </li>
					<li> 평균 동반 인원 : ${pList[0].mountainParty} 명</li>
				</ul>
                 <br>
                 
                  <!-- best photo part -->
            <div class="section-title">
               <h3> ${pList[0].mountainName} ${pList[0].mountainCourse} 의 BEST POST</h3>
               <br>
            </div>
            <c:forEach var="post" items="${pList[0].mountainCourse}" varStatus="status">
            <div class="row">
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-4.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">BEST POST 1</div>
                            <a href="#">
                                <h4>${pList[0].mountainPostSubject}</h4>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-5.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">BEST POST 2</div>
                            <a href="#">
                                <h4>공룡능선에 공룡이 사나요</h4>
                            </a>
                        
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="recipe-item">
                        <a href="#"><img src="img/recipe/recipe-6.jpg" alt=""></a>
                        <div class="ri-text">
                            <div class="cat-name">BEST POST 3</div>
                            <a href="#">
                                <h4>티라노사우르스는 없어요</h4>
                            </a>
                        </div>
                    </div>
                </div>
              </div>
              </c:forEach>
             <!--  best post part -->
<%--         <div class="container po-relative">
            <div class="section-title">
                <h3> ${pList.mountainName} ${pList.mountainCourse} 의 BEST POST</h3>
            </div>
            <br>
            <div class="row">
                <div class="col-lg-6">
                    <div class="top-recipe-item">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="top-recipe-img set-bg" data-setbg="img/top-recipe/recipe-2.jpg">
                                    <i class="fa fa-plus"></i>
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="top-recipe-text">
                                    <div class="cat-name">BEST POST 1</div>
                                    <a href="#">
                                        <h4>설악산에 다녀오다</h4>
                                    </a>
                                    <p>힘들어</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="top-recipe-item">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="top-recipe-img set-bg" data-setbg="img/top-recipe/recipe-3.jpg">
                                    <i class="fa fa-plus"></i>
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="top-recipe-text">
                                    <div class="cat-name">BEST POST 2</div>
                                    <a href="#">
                                        <h4>공룡능선 뿌수기</h4>
                                    </a>
                                    <p>공룡 만나는 줄 알았네</p>
                                </div>

                            </div>
		                </div>
		                </div>
		            </div>
		       	 </div>
		        </div> --%>
		        <div class="row">
                     <div class="col-sm-4" align="center">
		        <h3>자동차 타고 가세요?</h3><br>
		        	 <button type="submit"><img src="../imgs/car.png" width="150px" height="150px"></button>
		        	 <p>주차장 예약 페이지로 이동합니다.</p>
		        </div>
		        </div>
             </div>
    </section>
    
 <!--    <c:if test="${userId eq null}">
    <div align="center">
     <p>산타다 회원만 이용 가능한 페이지 입니다.</p>
     <a href="/member/login">회원가입 및 로그인</a>
     </div>
	</c:if> --> 

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
                <div class="col-lg-6 offset-lg-1">
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="copyright-text">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;<script>document.write(new Date().getFullYear());</script> 
						All rights reserved | This template is made with 
						<i class="fa fa-heart-o" aria-hidden="true"></i> 
						by <a href="https://colorlib.com" target="_blank">Colorlib</a>
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