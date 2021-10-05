<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SANTADA | ADMIN_신고관리</title>
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
		background: #fff;
      
	  }
</style>

<body>
 		<header class="header-section">
        <div class="container">
            <div class="logo">
                <a href="/index.html"><img src="../imgs/로고5.png" alt=""></a>
            </div>
            <div class="nav-menu" style="width: 100%;">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="../index.jsp">Home</a></li>
                        <li><a href="#">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="about-me.html">등산인증</a></li>
                                <li><a href="categories.html">등산후기</a></li>
                                <li><a href="recipe.html">랭킹</a></li>
                            </ul>
                        </li>
                        <li><a href="/mountain/list">추천코스</a></li>
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
                        <li style="display: none;"><a href="/member/login">로그인</a></li>
                        <li style="display: none;"><a href="#">마이페이지</a></li>
                        <li style="display: inline-block;"><a href="/member/logout">로그아웃</a></li>
                    </ul>

                </nav>
                
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
</head>
<body>
   <!-- Single Recipe Section Begin -->
    <section class="single-page-recipe spad">
        <div class="recipe-top">
            <div class="container-fluid">
                <div class="recipe-title">
                    <h2>REPORT</h2>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <div class="ingredients-item">
                        <div class="ingredient-list" >
                            <div class="list-item">
                                <h5>ADMIN</h5>
                                <div class="salad-list">
                                    <ul>
										<li><a href="/user/list">회원 관리</a></li>
                                        <li><a href="/admin/report">신고 관리</a></li>
                                        <li><a href="/admin/treeCampaignmg">나무 포인트 관리</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="nutrition-fact">
                        <div class="nutri-title">
                        </div>
                    </div>
                </div>
                <div class="col-lg-7">
                    <div class="recipe-right">
                        <div class="recipe-desc">
                               <table class="type11" align="left" >
							        <tr>
							   
							        <th> 선택 </th>
							        <th> 제목 </th> 
							        <th> 작성자 </th>
							        <th> 작성일 </th>
							        <th> 답변 상태 </th>
							        </tr>
							        <form action="/admin/report" method="post" >
							        <c:forEach items="${rList }" var = "rList" varStatus="index">
							        <tr>
							             <td><input type="checkbox" name="check" id="" style="width: 20px;
                                    height: 20px;"value="${rList.reportNo }"></td>
							            <td><a href="/reportAdmin/detail?reportNo=${rList.reportNo }">${rList.reportTitle }</a></td> 
							            <td> ${rList.userId }</td>
							            <td> ${rList.reportDate } </td>
							            <td>대기</td>
							          </c:forEach>
							             
							        <tr>
                          		  	<td colspan="5" align="center" style="font-size: 15pt; margin: 0px 10px;">
                                  		${pageNavi}	<input type="submit" value="삭제">
                            		</td>
							        </tr>
							        </form>

							    </table>
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
</body>
</html>