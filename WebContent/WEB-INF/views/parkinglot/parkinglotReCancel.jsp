<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	     <form >
	        <input type="date" name = "starttime">  - <input type="date" name = "endtime">
	      </form>
	      
	      <span>이용권</span><br>
	      <label><input type="radio" name="fruit" value="">일반</label>
	      <label><input type="radio" name="fruit" value="">종일권</label>
	      
	      <form >
	        <input type="time" name="birthtime"> - <input type="time" value="time"  name="birthtime">
	      </form>
	      
	      <form action="#">
	        <div class="select-itms">
	            <span>차량 : </span>
	            <select name="select" id="select1">
	                <option value="big">대형</option>
	                <option value="small">중/소형</option>
	            </select>
	        </div>
	       </form>
     
	      <form action="#">
	        <div class="select-itms">
	            <span>결제 : </span>
	            <select name="select" id="select2">
	                <option value="cash">현금</option>
	                <option value="card">카드</option>
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
		
		<!-- 쉽게 말해 여기가 Detail.jsp -->
        <!-- 여기서 예약 취소 버튼을 누르면 확인창이 뜨고 거기서  "예" 누르면  예약 내역 페이지로 다시 이동  
        	  원래는  이 페이에다가 또다른 예약확인 화면을 만들어야함  시간이 되면 페이지 디자인 해볼것
        	  또다른 예약 확인 화면이란 ?예약 화면에 취소 버튼만 바꾸는게 아니라  전체적인 페이지를 따로 바꿔 줘야한다는 뜻
        -->
		<div class="single-select-box pt-45 mb-30">
		    <button onclick="delConfirm()">예약취소</button>
	    <script>
	      function delConfirm() {
	        var txt = "예약 취소하시겠습니까?";
	        var del = confirm(txt);
	        if (del == true) { 
	          alert('예약 취소되었습니다.\n이용해주셔서 감사합니다.');
	          document.location.href="parkinglotReList.jsp";
	        }
	        else {
	          alert('변경이 취소되었습니다.');
	          document.location.href="parkinglotReList.jsp";
	        }
	      }
	    </script>
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
	


</body>
</html>