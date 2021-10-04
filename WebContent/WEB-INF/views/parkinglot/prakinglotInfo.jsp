<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차정보 조회</title>


<link rel="stylesheet" href="css/animatedLogin.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nice-select.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slicknav.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>

<!-- 유료 페이지 화면 -->

  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCPFgHJIaTcEiKvpRjt8HcYE6cGZSJbosM&callback=initMap"></script>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
         <script>
          function initialize() {
           var myLatlng = new google.maps.LatLng(X,Y);
           var mapOptions = {
                zoom: 12,
                center: myLatlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
           }
           var map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
           var marker = new google.maps.Marker({
             position: myLatlng,
             map: map,
             title: ""

        
            });
        }
         </script>

</head>
<body onload="initialize()">
<c:if test="${sessionScope.userId eq null}">
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
	<form action="/parkinglotInfo/Detail" method="get">
		<div>
	        <input name ="mountainName"><input name="PARKINGLOT_NAME">
	    </div>
       <center><div id="map_canvas"style="width:600px; height:400px; float:left;"></div></center>
           
         <div class="parkinlottb">
                <table border="6">
                    <tr align ="center">
                        <td colspan = "3" >주차장 요금</td>
                    </tr>
                    <tr>
                        <td align ="center">-</td>
                        <td align ="center">대형</td>
                        <td align ="center">소형</td>
                    </tr>
                    <tr>
                        <td>1시간</td>
                        <td align ="center"><input name = "parkinglot_price_big" value=""></td>
                        <td align ="center"><input name = "parkinglot_price_small" value=""></td>
                    </tr>
                    <tr>
                        <td>종일권</td>
                        <td align ="center"><input name = "" value=""></td>
                        <td align ="center"><input name = "" value=""></td>
                    </tr>
                </table>
           </div>
        <div>
            <ul class="contact_list">
                <li class="parkinglot">
                    <i class="fas fa-map-marker-alt"></i>
                    <div>주소 :</div>
                    <div><input value="time"></div>
                </li>
                    <li class="parkinglot"><i class="fas fa-phone-alt"></i>
                    <div>연락처 :</div>
                    <div><input value="time"></div>
                </li>
                    <li class="parkinglot"><i class="fas fa-parking">
                    <div>이용시간 : <input value="time"></div></i>
                </li>
            </ul>
        </div>
        <div class="button">
            <a href=""><input type="submit" value="다음에 이용하기"></a>
        </div>
        <div class="pass">
            <a href="/parkingReservation/register"><input type="submit" value="예약하기"></a> 
        </div>
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
	
	
	
	 <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/main.js"></script>
	</c:if>
	
	
	
</body>
</html>



<!-- 무료 페이지 화면 -->
	

 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCPFgHJIaTcEiKvpRjt8HcYE6cGZSJbosM&callback=initMap"></script>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
         <script>
          function initialize() {
           var myLatlng = new google.maps.LatLng(X,Y);
           var mapOptions = {
                zoom: 12,
                center: myLatlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
           }
           var map = new google.maps.Map(document.getElementById('map_canvas'), mapOptions);
           var marker = new google.maps.Marker({
             position: myLatlng,
             map: map,
             title: ""

        
            });
        }
         </script>

</head>
<body onload="initialize()">
<c:if test="${userId ne null and userId ne ''}">
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
	<form action="/parkinglotInfo/Detail" method="get">
		<div>
	        <input name ="mountainName"><input name="PARKINGLOT_NAME">
	    </div>
       <center><div id="map_canvas"style="width:600px; height:400px; float:left;"></div></center>
           
         <div class="parkinlottb">
                <table border="6">
                    <tr align ="center">
                        <td colspan = "3" >주차장 요금</td>
                    </tr>
                    <tr>
                        <td align ="center">-</td>
                        <td align ="center">대형</td>
                        <td align ="center">소형</td>
                    </tr>
                    <tr>
                        <td>1시간</td>
                        <td align ="center"><input name = "parkinglot_price_big" value=""></td>
                        <td align ="center"><input name = "parkinglot_price_small" value=""></td>
                    </tr>
                    <tr>
                        <td>종일권</td>
                        <td align ="center"><input name = "" value=""></td>
                        <td align ="center"><input name = "" value=""></td>
                    </tr>
                </table>
           </div>
        <div>
            <ul class="contact_list">
                <li class="parkinglot">
                    <i class="fas fa-map-marker-alt"></i>
                    <div>주소 :</div>
                    <div><input value="time"></div>
                </li>
                    <li class="parkinglot"><i class="fas fa-phone-alt"></i>
                    <div>연락처 :</div>
                    <div><input value="time"></div>
                </li>
                    <li class="parkinglot"><i class="fas fa-parking">
                    <div>이용시간 : <input value="time"></div></i>
                </li>
            </ul>
        </div>
        <div class="button">
            <a href=""><input type="submit" value="다음에 이용하기"></a>
        </div>
        <div class="pass">
            <a href="/parkingReservation/register"><input type="submit" value="예약하기"></a> 
        </div>
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

