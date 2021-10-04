<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="UTF-8">
<title>주차장예약</title>

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
	      <form action="/parkingReservation/register" method="post">
	        <input type="date" name = "starttime">  - <input type="date" name = "endtime">
	      </form>
	      
	      <span>이용권</span><br>
	       <label><input type="radio" name="fruit" value="일반">일반</label>
	       <label><input type="radio" name="fruit" value="종일권 ">종일권</label>
	      
	      <form >
	        <input type="time" name="birthtime"> - <input type="time"  name="birthtime">
	      </form>
	      
	      <form action="#">
	        <div class="select-itms">
	            <span>차량 : </span>
	            <select name="select" id="select1">
	                <option value="대형">대형</option>
	                <option value="중/소형">중/소형</option>
	            </select>
	        </div>
	      </form>
     
	      <form action="#">
	        <div class="select-itms">
	            <span>결제 : </span>
	            <select name="select" id="select2">
	                <option value="현금">현금</option>
	                <option value="카드">카드</option>
	            </select>
	        </div>
	      </form>

   
        <div class="boking-tittle">
            <span>결제금액  <input value=""  name="" placeholder="원"></span>
        </div>      
    
		
		<div>
			<input type="checkbox" id="scales" name="scales" checked>
			<label for="scales">예약일시 및 예약정보 확인</label>
		</div>
		
		<!-- 확인창 만들고 페이지 처리 -->
		<div id="dialog-message" title="예약확인" style='display:none'>
                예약이 완료되었습니다.<br> 확인하시겠습니까?
      </div>
      
      <button class="ui-button ui-widget ui-corner-all" onclick="crayBtn1()">예약(현장에서결제)</button>
      
      <!-- 메인으로 갈지 아니오 부분      -->
      <script>
      function crayBtn1()
      {
          $('#dialog-message').dialog({
              modal: true, 
              buttons: {
                  "네": function() { $(this).dialog('close'); document.location.href="parkinglotReList.jsp"},
                  "아니오": function() { $(this).dialog('close'); document.location.href="index.jsp"},
              }
          });
       }
      </script>
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