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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
.t__contents {
	align-items: center;
	text-align: center;
	width: 1500px;
	height: 70%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 30px;
	margin-bottom: 20px;
	border-collapse: separate;
	border-spacing: 1px;
	line-height: 1.5;
}

.t__contents th {
	background-color: #b2dfdb;
	color: white;
	font-size: 1.2em;
}

.t__reply, .t__reply_write {
	align-items: center;
	align-content: center;
	width: 1500px;
	margin-left: auto;
	margin-right: auto;
	margin-bottom: 50px;
}

img {
	width: 700px;
}

button {
	align-items: center;
	margin: 10px;
	height: 40px;
	border: 0;
	outline: none;
	border-radius: 4px;
	background: #b2dfdb;
	color: white;
	font-weight: bolder;
	letter-spacing: 1px;
	cursor: pointer;
}

.btn {
	background-color: #b2dfdb;
	align-items: center;
	color: white;
	padding: 6px;
	font-weight: bolder;
	letter-spacing: 1px;
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
							</ul></li>
						<li><a href="/mountain/recommend">추천코스</a></li>
						<li class="active"><a href="/clubPost/List">소모임</a>
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
								<c:if
									test="${cm.clubNo ne null and cm.clubNo ne '' and cm.approvalPosition eq 'Y' and club.userId eq null}">
									<li><a href="/clubPost/List">${clubName }소모임</a></li>
									<li><a href="/club/leave?clubNo=${cm.clubNo}">소모임탈퇴</a></li>
								</c:if>
								<c:if test="${club.userId ne null}">
									<li><a href="/clubPost/List">${clubName}소모임</a></li>
									<li><a href="/club/memberList?clubNo=${cm.clubNo }">소모임회원관리</a></li>
									<li><a href="/clubjoin/management?userId=${club.userId}">소모임승인관리</a></li>
									<li><a href="/remove/club?clubNo=${cm.clubNo}">소모임폐쇄</a></li>
								</c:if>
							</ul></li>
						<li><a href="/letter/send">쪽지</a>
							<ul class="sub-menu">
								<li><a href="/letter/send">쪽지작성</a></li>
								<li><a href="/letter/inbox">받은 쪽지함</a></li>
								<li><a href="/letter/list">보낸 쪽지함</a></li>
							</ul></li>
						<li><a href="/mypage/info">마이페이지</a></li>
					</ul>
				</nav>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<c:if test="${cpFile.fileName eq null }">
		<table class="t__contents">
			<tr>
				<td colspan="6" align="right"><a href="/clubPost/List"
					class="btn">목록</a> <c:if
						test="${userId eq cpOne.userId or userId eq masterId}">
						<a
							href="/clubPost/delete?postNo=${cpOne.postNo}&writeUser=${cpOne.userId}&clubNo=${cpOne.clubNo}"
							class="btn">삭제</a>
					</c:if>
					<c:if test="${userId eq cpOne.userId }">
						<a href="/clubPost/modify?postNo=${cpOne.postNo}&writeUser=${cpOne.userId}"class="btn">수정</a>
					</c:if>
					</td>
			</tr>
			<tr>
				<th colspan="6"
					style="background-color: transparent; text-align: left; font-weight: bolder;">
					<h2>${cpOne.postSubject}</h2>
				</th>
			</tr>
			<tr>
				<td colspan="6" align="left">
					<h5>${cpOne.userId}｜
						${cpOne.writeDate} ｜ 추천 ${cpOne.recommend}</h5>
				</td>
			</tr>
			<tr>
				<th colspan="6" align="center">내용</th>
			</tr>
			<tr>
				<td colspan="6" align="center">
					${cpOne.postContents}</td>
			</tr>
			<tr>
				<td colspan="3" align="right" style="width: 50%;">
					<form action="/clubPost/recommend" method="post">
						<button type="submit" name="recommend"
							value="${cpOne.recommend}">추천
							${cpOne.recommend}</button>
						<input type="hidden" name="postNo"
							value="${cpOne.postNo}">
					</form>
				</td>
				<td colspan="3" align="left">
					<form action="/report/write?postNo=${cpOne.postNo}"
						method="get">
						<button>신고</button>
						<input type="hidden" name="postNo"
							value="${cpOne.postNo}">
					</form>
				</td>
			</tr>
		</table>
		<hr>
		<br>
		<!-- 댓글 출력 -->
		<table class="t__reply">
			<c:forEach items="${cpOne.clubReplies}" var="reply">
				<tr colspan="6" align="center">
					<td>${reply.replyUserId}</td>
					<td style="width: 60%;">${reply.replyContents}</td>
					<td>${reply.replyDate}</td>
					<c:if test="${userId eq reply.replyUserId}">
						<td><a href="javascript:void(0)"
							onclick="showModifyReply(this)" class="btn">수정</a>&nbsp;&nbsp; 
							<a href="/clubPostReply/delete?postNo=${reply.postNo}&replyNo=${reply.replyNo}&replyUser=${reply.replyUserId}"
							class="btn">삭제</a></td>
					</c:if>
				</tr>
				<tr style="display: none; width: 1500px;" colspan="6" align="center";>
					<td>${reply.replyUserId}</td>
					<td><input type="text" value="${reply.replyContents}"
						id="modifyReply" style="width: 800px; padding: 5px;"></td>
					<td><a href="javascript:void(0)"
						onclick="modifyReply(this,${reply.replyNo},${reply.postNo},'${reply.replyUserId }')"
						class="btn">등록</a>&nbsp;&nbsp; <a href="javascript:void(0)"
						onclick="hideModifyReply(this)" class="btn">취소</a></td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<!-- 댓글 입력 -->
		<table class="t__reply_write">
			<tr colspan="6" align="center">
				<form action="/clubPostReply/write" method="post">
					<input type="hidden" name="postNo"
						value="${cpOne.postNo}"> <input type="text"
						name="replyContents" placeholder="댓글을 입력하세요" class="t__reply"
						style="margin-left: 300px; width: 1200px; padding: 5px;">&nbsp;
					<input type="submit" value="등록" class="btn">
				</form>
			</tr>
		</table>
		<!-- 전송용 폼태그 -->
		<form action="/clubPostReply/modify" method="post" id="modifyForm">
			<input type="hidden" name="replyContents" id="modifyReplyContents">
			<input type="hidden" name="replyNo" id="modifyReplyNo"> 
			<input type="hidden" name="postNo" id="modifyPostNo"> 
			<input type="hidden" name="replyUser" id="modifyReplyUser">
		</form>

	</c:if>
	<c:if test="${cpFile.fileName ne null }">
		<table class="t__contents">
			<tr>
				<td colspan="6" align="right"><a href="/clubPost/List"
					class="btn">목록</a> <c:if
						test="${userId eq cpOne.userId or userId eq masterId}">
						<a
							href="/clubPost/delete?postNo=${cpOne.postNo}&writeUser=${cpOne.userId}&clubNo=${cpOne.clubNo}"
							class="btn">삭제</a>
					</c:if>
					<c:if test="${userId eq cpOne.userId }">
						<a href="/clubPost/modify?postNo=${cpOne.postNo}&writeUser=${cpOne.userId}"class="btn">수정</a>
					</c:if>
					</td>
			</tr>
			<tr>
				<th colspan="6"
					style="background-color: transparent; text-align: left; font-weight: bolder;">
					<h2>${cpOne.postSubject}</h2>
				</th>
			</tr>
			<tr>
				<td colspan="6" align="left">
					<h5>${cpOne.userId}｜
						${cpOne.writeDate} ｜ 추천 ${cpOne.recommend}</h5>
				</td>
			</tr>
			<tr>
				<th colspan="6" align="center">내용</th>
			</tr>
			<tr>
				<td colspan="6" align="center">
					${cpOne.postContents}</td>
			</tr>
			<tr>
				<th colspan="6" align="center">첨부사진</th>
			</tr>
			<tr>
				<td colspan="6" align="center"><img
					src="${pageContext.request.contextPath}/clubUpload/${cpFile.fileName}"
					alt=""></td>
			</tr>
			<tr>
				<td colspan="3" align="right" style="width: 50%;">
					<form action="/clubPost/recommend" method="post">
						<button type="submit" name="recommend"
							value="${cpOne.recommend}">추천
							${cpOne.recommend}</button>
						<input type="hidden" name="postNo"
							value="${cpOne.postNo}">
					</form>
				</td>
				<td colspan="3" align="left">
					<form action="/report/write?postNo=${cpOne.postNo}"
						method="get">
						<button>신고</button>
						<input type="hidden" name="postNo"
							value="${cpOne.postNo}">
					</form>
				</td>
			</tr>
		</table>
		<hr>
		<br>
		<!-- 댓글 출력 -->
		<table class="t__reply">
			<c:forEach items="${cpOne.clubReplies}" var="reply">
				<tr colspan="6" align="center">
					<td>${reply.replyUserId}</td>
					<td style="width: 60%;">${reply.replyContents}</td>
					<td>${reply.replyDate}</td>
					<c:if test="${userId eq reply.replyUserId}">
						<td><a href="javascript:void(0)"
							onclick="showModifyReply(this)" class="btn">수정</a>&nbsp;&nbsp; 
							<a href="/clubPostReply/delete?postNo=${reply.postNo}&replyNo=${reply.replyNo}&replyUser=${reply.replyUserId}"
							class="btn">삭제</a></td>
					</c:if>
				</tr>
				<tr style="display: none; width: 1500px;" colspan="6" align="center";>
					<td>${reply.replyUserId}</td>
					<td><input type="text" value="${reply.replyContents}"
						id="modifyReply" style="width: 800px; padding: 5px;"></td>
					<td><a href="javascript:void(0)"
						onclick="modifyReply(this,${reply.replyNo},${reply.postNo},'${reply.replyUserId }')"
						class="btn">등록</a>&nbsp;&nbsp; <a href="javascript:void(0)"
						onclick="hideModifyReply(this)" class="btn">취소</a></td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<!-- 댓글 입력 -->
		<table class="t__reply_write">
			<tr colspan="6" align="center">
				<form action="/clubPostReply/write" method="post">
					<input type="hidden" name="postNo"
						value="${cpOne.postNo}"> <input type="text"
						name="replyContents" placeholder="댓글을 입력하세요" class="t__reply"
						style="margin-left: 300px; width: 1200px; padding: 5px;">&nbsp;
					<input type="submit" value="등록" class="btn">
				</form>
			</tr>
		</table>
		<!-- 전송용 폼태그 -->
		<form action="/clubPostReply/modify" method="post" id="modifyForm">
			<input type="hidden" name="replyContents" id="modifyReplyContents">
			<input type="hidden" name="replyNo" id="modifyReplyNo"> 
			<input type="hidden" name="postNo" id="modifyPostNo"> 
			<input type="hidden" name="replyUser" id="modifyReplyUser">
		</form>
		
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
<!-- <script>
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
	</script> -->
	<script>
        function showModifyReply(obj) {
            $(obj).parents("tr").next().show();
            $(obj).parents("tr").hide();
        }
        function hideModifyReply(obj) {
            $(obj).parents("tr").prev().show();
            $(obj).parents("tr").hide();
        }

        function modifyReply(obj, replyNo, postNo, userId) {
			let contents = $(obj).parent().prev().find("input").val();
			$("#modifyReplyUser").val(userId);
			$("#modifyReplyContents").val(contents);
			$("#modifyReplyNo").val(replyNo);
			$("#modifyPostNo").val(postNo);
			$("#modifyForm").submit();
        }
    </script>
</html>