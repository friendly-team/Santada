<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="clubPost.model.vo.ClubPost"%>
<%@page import="clubPost.model.vo.ClubPostFile"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소모임 게시판</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/nice-select.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<meta name="description" content="Yoga Studio Template">
<meta name="keywords" content="Yoga, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	background: #ce4869;
}

table.type11 th:nth-child(2) {
	width: 1000px;
}

table.type11 td {
	width: 155px;
	padding: 10px;
	font-weight: normal;
	font-size: 10pt;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #eee;
}

#divserach {
	height: 40px;
	width: 300px;
	background-color: #ffffff;
	display: inline-flex;
	float: left;
}

#search {
	font-size: 16px;
	width: 325px;
	padding: 10px;
	border: 0;
	outline: none;
	float: left;
	background-color: #F5F6FA;
}
</style>
</head>
<body>
<!-- 오요요요 -->
	<header class="header-section-other">
		<div class="container-fluid">
			<div class="logo" style="height: 100%; width: 25%;">
				<a href="../index.jsp"><img src="../imgs/로고6.png"
					style="height: 100%; width: 60%;" alt=""></a>
			</div>
			<div class="nav-menu">
                  <nav class="main-menu mobile-menu">
					<ul>
					  <li><a href="/index.jsp">Home</a></li>
                        <li><a href="/mountainPost/list">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="/mountainPost/list">등산 인증</a></li>
                                <li><a href="/treeCampaign/write">나무심기 캠페인</a></li>
                                <li><a href="/ranking">등산 랭킹</a></li>
                            </ul>
                        </li>
						<li><a href="/mountain/recommend">추천코스</a></li>
						<li class="active"><a href="#">소모임</a>
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
						 <li><a href="/mypage/info">마이페이지</a></li>
					</ul>
				</nav>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<c:if test="${cpFile.fileName eq null }">
		<section style="height: 900px; width: 100%;">
			<div style="height: 100px; width: 100%;"></div>
			<h5 style="display: inline;">제목 : ${cpOne.postSubject }</h5>
				<form action="/clubPost/delete" method="post" style="display: inline;">
					<input type="hidden" value="${cpOne.postNo }" name="post-no">
					<input type="hidden" value="${cpOne.clubNo }" name="club-no">
					<input type="hidden" value="${cpOne.userId }" name="write-user">
					<input style="position: relative; left: 62.2%;" type="submit" value="게시글 삭제">
				</form>
				<form action="/clubPost/modify" method="get" style="display: inline;">
					<input type="hidden" value="${cpOne.userId }" name="write-user">
					<input type="hidden" value="${cpOne.postNo }" name="post-no">
					<input style="position: relative; left: 64.4%;" type="submit" value="게시글 수정">
				</form>
			<hr style="background-color: 2f4f4f;">
			<h6 style="display: inline;">작성자 : ${cpOne.userId }</h6>
			&nbsp;&nbsp;
			<h6 style="display: inline;">작성일 : ${cpOne.writeDate }</h6>
			<form style="display: inline; position: relative; left: 54%;"
				action="/clubPost/recommend" method="post">
				<input type="hidden" value="${cpOne.postNo }" name="post-no">
				<input type="hidden" value="${cpOne.recommend }" name="recommend">
				<input type="submit" value="추천" onclick="alert('추천완료')">
			</form>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<form style="display: inline; position: relative; left: 54.3%;"
				action="/report/write?postNo=${cpOne.postNo }" method="get">
				<input type="hidden" value="${cpOne.postNo }" name="postNo">
				<input type="submit" value="신고">
			</form>
			<hr style="background-color: 2f4f4f;">
			<p>${cpOne.postContents }</p>
			<hr style="background-color: 2f4f4f;">
		</section>
		<section>
			<form action="/clubPostReply/write" method="post">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 : <input type="text" name="replyContents" placeholder="댓글을 작성해보세요" style="width: 40%; height: 9%;">
				<input type="hidden" name="postNo" value="${cpOne.postNo }">
				<input type="submit" value="작성">
			</form>
		</section>
		<section>
			<table style="width: 80%;">
				<tr>
					<th style="width: 60%;">댓글</th>
					<th style="width: 10%;">아이디</th>
					<th style="width: 10%;">작성날짜</th>
				</tr>
				<c:forEach items="${cpOne.clubReplies }" var="reply">
					<tr>
						<td>${reply.replyContents }</td>
						<td>${reply.replyUserId }</td>
						<td>${reply.replyDate }</td>
						<td><a href="javascript:void(0)" onclick="showModifyReply(this)">수정</a></td>
						<td><a href="/clubPostReply/delete?postNo=${reply.postNo }&replyNo=${reply.replyNo }&replyUser=${reply.replyUserId }">삭제</a></td>
					</tr>
					<tr style="display: none;">
						<td>
							<input type="text" size="80" value="${reply.replyContents }" id="modifyReply">
						</td>
						<td>
							<a href="javascript:void(0)" 
							onclick="modifyReply(this,${reply.replyNo},${reply.postNo},'${reply.replyUserId}')">수정완료</a>
							<a href="javascript:void(0)" onclick="hidenModifyReply(this)">취소</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<form action="/clubPostReply/modify" method="post" id="modifyForm">
				<input type="hidden" name="replyContents" id="modifyReplyContents">
				<input type="hidden" name="replyNo" id="modifyReplyNo">
				<input type="hidden" name="postNo" id="modifyPostNo">
				<input type="hidden" name="replyUser" id="modifyReplyUser">
			</form>
		</section>
		
	</c:if>
	<c:if test="${cpFile.fileName ne null }">
		<section style="height: 900px; width: 100%;">
			<div style="height: 100px; width: 100%;"></div>
			<h5>제목 : ${cpOne.postSubject }</h5>
			<form action="/clubPost/delete" method="post" style="display: inline;">
				<input type="hidden" value="${cpOne.postNo }" name="post-no">
				<input type="hidden" value="${cpOne.clubNo }" name="club-no">
				<input type="hidden" value="${cpOne.userId }" name="write-user">
				<input style="position: relative; left: 72.2%;" type="submit" value="게시글 삭제">
			</form>
			<form action="/clubPost/modify" method="get" style="display: inline;">
				<input type="hidden" value="${cpOne.userId }" name="write-user">
				<input type="hidden" value="${cpOne.postNo }" name="post-no">
				<input style="position: relative; left: 74%;" type="submit" value="게시글 수정">
			</form>
			<hr style="background-color: 2f4f4f;">
			<h6 style="display: inline;">작성자 : ${cpOne.userId }</h6>
			&nbsp;&nbsp;
			<h6 style="display: inline;">작성일 : ${cpOne.writeDate }</h6>
			<form style="display: inline; position: relative; left: 60%;"
				action="/clubPost/recommend" method="get">
				<input type="hidden" value="${cpOne.postNo }" name="post-no">
				<input type="hidden" value="${cpOne.recommend }" name="recommend">
				<input type="submit" value="추천" onclick="alert('추천완료')">
			</form>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<form style="display: inline; position: relative; left: 60%;"
				action="/report/write?postNo=${cpOne.postNo }" method="get">
				<input type="hidden" value="${cpOne.postNo }" name="postNo">
				<input type="submit" value="신고">
			</form>
			<hr style="background-color: 2f4f4f;">
			<div style=" height:80%; width: 100%;">
				<img style="height: 80%;width: 40%; position: relative; left: 30%;" 
					src="${pageContext.request.contextPath}/clubUpload/${cpFile.fileName }">
				<p>${cpOne.postContents }</p>
			</div>
			<hr style="background-color: 2f4f4f;">
		</section>
		<section>
			<form action="/clubPostReply/write" method="post">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;댓글 : <input type="text" name="replyContents" placeholder="댓글을 작성해보세요" style="width: 40%; height: 9%;">
				<input type="hidden" name="postNo" value="${cpOne.postNo }">
				<input type="submit" value="작성">
			</form>
		</section>
		<section>
			<table style="width: 80%;">
				<tr>
					<th style="width: 60%;">댓글</th>
					<th style="width: 10%;">아이디</th>
					<th style="width: 10%;">작성날짜</th>
				</tr>
				<c:forEach items="${cpOne.clubReplies }" var="reply">
					<tr>
						<td>${reply.replyContents }</td>
						<td>${reply.replyUserId }</td>
						<td>${reply.replyDate }</td>
						<td><a href="javascript:void(0)" onclick="showModifyReply(this)">수정</a></td>
						<td><a href="/clubPostReply/delete?postNo=${reply.postNo }&replyNo=${reply.replyNo }&replyUser=${reply.replyUserId }">삭제</a></td>
					</tr>
					<tr style="display: none;">
						<td>
							<input type="text" size="80" value="${reply.replyContents }" id="modifyReply">
						</td>
						<td>
							<a href="javascript:void(0)" 
							onclick="modifyReply(this,${reply.replyNo},${reply.postNo},'${reply.replyUserId}')">수정완료</a>
							<a href="javascript:void(0)" onclick="hidenModifyReply(this)">취소</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<form action="/clubPostReply/modify" method="post" id="modifyForm">
				<input type="hidden" name="replyContents" id="modifyReplyContents">
				<input type="hidden" name="replyNo" id="modifyReplyNo">
				<input type="hidden" name="postNo" id="modifyPostNo">
				<input type="hidden" name="replyUser" id="modifyReplyUser">
			</form>
		</section>
	</c:if>
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
	<!-- Footer Section End -->

	<!-- Search model -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch"></div>
			<form class="search-model-form">
				<input type="text" id="search-input">
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
	<script>
		function modifyReply(obj,replyNo,postNo,replyUser){
			var contents = $(obj).parent().prev().find("input").val();
			$("#modifyReplyUser").val(replyUser);
			$("#modifyReplyContents").val(contents);
			$("#modifyReplyNo").val(replyNo);
			$("#modifyPostNo").val(postNo);
			$("#modifyForm").submit();
		}	
		function showModifyReply(obj){
			$(obj).parents("tr").next().show();
			$(obj).parents("tr").hide();
		}
		function hidenModifyReply(obj){
			$(obj).parents("tr").prev().show();
			$(obj).parents("tr").hide();
		}
	</script>
</html>