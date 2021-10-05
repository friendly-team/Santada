<%@page import="parkingReservation.model.vo.ParkingReservation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <% 
   		List<ParkingReservation> pList = (List<ParkingReservation>)request.getAttribute("pList");
   		String pageNavi = (String)request.getAttribute("pageNavi");
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차예약내역</title>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nice-select.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slicknav.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>


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

	 <section>
        <div style="text-align: center;">
            <h2>주차 예약 내역</h2>
        </div>
		<table>
			<tr>
				<th>산이름</th>
				<th>차량종류</th>
				<th>예약기간</th>
				<th>예약시간</th>
				<th>처리상황</th>
			</tr>
			<% for(ParkingReservation nOne : pList) { %>
			<tr>
				<td><%= nOne.getMountainName() %></td>
				<td><%= nOne.getReservationCarType() %></td>
				<td><a href = "/parkinglotReservation/detail?reservationNo"><%= nOne.getReservationStartDate()%>-<%= nOne.getReservationEndDate() %></a></td>
				<td><%= nOne.getReservationStartTime()%>-<%=nOne.getReservationEndTime()%></td>
				<td><%= nOne.getReservationCancel() %></td>
			</tr>
			<%  } %>
			
				<tr>
				<td colspan="4" align="center">
				   <%= pageNavi %>
				</td>
		  </tabel>
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
	
</body>
</html>