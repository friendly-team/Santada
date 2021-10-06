<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Yoga Studio Template">
    <meta name="keywords" content="Yoga, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>쪽지 전송</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nice-select.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slicknav.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <style>
        	select {

    width:300px;
     padding:5px;
     border:1px solid #999;
     font-family:'Nanumgothic';
     border-radius:3px;
     -webkit-appearance: none;
     -moz-appearance: none;
     appearance : none;
     
}

select::-ms-expand{

display:none;/*for IE10,11*/

}
    </style>
</head>

<body>


    <!-- Contact Section Begin -->
    <section class="contact-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <form action="/admin/letter" class="contact-form" method="post">
                        <h3><i class="far fa-edit"></i>&nbsp;&nbsp;답변하기</h3>
                        
                        <div class="row">

                            <div class="col-lg-12">
                                <input type="text" placeholder="To" name="recipient-id"value="${writeId }" readonly>
                            </div>

                            <div class="col-lg-12">
                                <input type="text" placeholder="From" name="user-id" value="${userId}" readonly>
                            </div>

                            <div class="col-lg-12">
                                <input type="text" placeholder="Subject" name="letter-subject">
                                <textarea placeholder="Comment" name="letter-contents"></textarea>
                            </div>
                        </div>
                        	<input type=hidden name="reportNo" value="${reportNo }">
                        <button type="submit" onclick="send()">Send</button>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <!-- Contact Section End -->

  
    
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
	function send(){
    window.onload = closeWindow(); 
	alert("답변을보냈습니다");
	opener.parent.location.replace("/admin/report");
   		self.close();
	}
	</script>
</body>

</html>
	<c:if test="${sessionScope.userId eq null }">
		<script>window.location.href="/member/login.jsp"
			
		</script>
	</c:if>
	