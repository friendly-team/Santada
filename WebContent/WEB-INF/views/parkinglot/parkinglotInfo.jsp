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




    <style>
	    
	 
	    
	    
	    input {
	    border:none
	  
	  	}
	  
	    th, td {
	    border-bottom: 1px solid #444444;
	    padding: 10px;
	  	}
	  
	    ul{
	    list-style:none;
	    

	  	}
	  
	  	.wrap {
	  	margin-top :110px;
	  	padding-bottom: 10%;
	    margin-left : 270px;
	    }
	    
	    .contact_list{
		 margin-left: auto; 
		 margin-right: 110px;
	    }
	  
	</style>
           

  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCPFgHJIaTcEiKvpRjt8HcYE6cGZSJbosM&callback=initMap"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  
  

</head>
<body onload="initialize(${pInfo.parkinglotGoogleMapX},${pInfo.parkinglotGoogleMapY})"> 
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
        <h2><input name ="mountainName" value="${pInfo.mountainName}" type='text' style="text-align:center; width:100;height:30;text-align:right;padding-top:5;"><input name="parkinglotName" value="${pInfo.parkinglotName}"></h2>
    </div>	
	<div class = "wrap" >
		
       <center><div id="map_canvas"style="width:600px; height:400px; float:left;"></div></center>
           
                <table  border-collapse: collapse; style="margin-left: auto; margin-right: auto;">
                    <tr align ="center">
                        <th colspan = "3">주차장 요금</th>
                    </tr>
                    <tr>
                        <td align ="center">-</td>
                        <td align ="center">대형</td>
                        <td align ="center">소형</td>
                    </tr>
                    <tr>
                        <td>1시간</td>
                        <td align ="center"><input name = "parkinglotPriceBig" value="${pInfo.parkinglotPriceBig}원" type='text' style='text-align:center'></td>
                        <td align ="center"><input name = "parkinglotPriceSmall" value="${pInfo.parkinglotPriceSmall}원" type='text' style='text-align:center'></td>
                    </tr>
                    <tr>
                        <td>종일권</td>
                        <td align ="center"><input name = "parkinglotDayPriceBig" value="${pInfo.parkinglotDayPriceBig}원" type='text' style='text-align:center'></td>
                        <td align ="center"><input name = "parkinglotDayPriceSmall" value="${pInfo.parkinglotDayPriceSmall}원" type='text' style='text-align:center'></td>
                    </tr>
                </table>
				<div style="font-size:12px; margin-right:10px;">
				   *1시간에 500원추가 
				</div>                
        <div style ="text-align: center;  vertical-align: middle;">
            <ul class="contact_list" >
                    <li class="parkinglot"><i class="fas fa-map-marker-alt"></i>
                    <div>주소 : <input name = "parkinglotAddress" value="${pInfo.parkinglotAddress}"></div>
                </li>
                    <li class="parkinglot"><i class="fas fa-phone-alt"></i>
                    <div>연락처 : <input name = "parkinglotTel" value="${pInfo.parkinglotTel}"></div>
                </li>
                    <li class="parkinglot"><i class="fas fa-parking"></i>
                    <div style="margin-left: auto; margin-right: auto;">이용시간 : <input name = "parkinglotOpenTime" value="${pInfo.parkinglotOpenTime}"  size=2 maxlength=6> - <input name = "parkinglotCloseTime" value="${pInfo.parkinglotCloseTime}" size=6 maxlength=6></div>
                </li>
            
        </div>
	        <div style ="text-align: center;">
	            <a href="../index.jsp"><input type="button" value="다음에 이용하기" style="height: 40px;width: 140px;"></a>
	            <a href="/parkingReservation/register"><input type="button" value="예약하기" style="height: 40px;width: 100px;"></a> 
	        </div>
       </div>
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
	    function initialize(X, Y) {
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
	       title: "${pInfo.mountainName}"
	      });
	  }
    </script>	
    
    
</body>
</html>

