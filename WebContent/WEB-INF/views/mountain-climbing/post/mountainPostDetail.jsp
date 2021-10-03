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
    <title>Santada ｜ 등산인증</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=PT+Sans:400,700&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <style>
        .t__contents {
            align-items: center;
            text-align: center;
            width:1500px;
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
    <!-- Page Preloder -->

<!-- Header Section Begin -->
    <header class="header-section-other">
        <div class="container-fluid">
            <div class="logo" style="height: 100%; width: 25%;">
                <a href="${pageContext.request.contextPath}/index.jsp">
                    <img src="${pageContext.request.contextPath}/imgs/로고6.png" style="height: 100%; width: 60%;" alt="">
                </a>
            </div>
            <div class="nav-menu">
                <nav class="main-menu mobile-menu">
                    <ul>
                        <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                        <li><a href="/mountainPost/list">등산인증</a>
                            <ul class="sub-menu">
                                <li><a href="/mountainPost/list">등산인증</a></li>
                                <li><a href="/treeCampaign/write">나무심기 캠페인</a></li>
                                <li><a href="#">랭킹</a></li>
                            </ul>
                        </li>
                        <li><a href="#">추천코스</a></li>
                        <li><a href="#">소모임</a>
                            <ul class="sub-menu">
                                <li><a href="#">소모임가입</a></li>
                                <li><a href="#">소모임생성</a></li>
                            </ul>
                        </li>
                        <li><a href="#">쪽지</a>
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

<!-- Contents Begin-->
    <div style="margin-top: 100px;">
        <h1 style="text-align: center; font-size: 30px;">등산인증</h1>
    </div>
    <table class="t__contents">
        <tr>
            <td colspan="6" align="right">
                <a href="/mountainPost/list" class="btn">목록</a>
                <a href="/mountainPost/modify?mountainPostNo=${mPostOne.mountainPostNo}" class="btn">수정</a>
                <a href="/mountainPost/remove?mountainPostNo=${mPostOne.mountainPostNo}" class="btn">삭제</a>
            </td>
        </tr>
        <tr>
            <th colspan="6" style="background-color: transparent; text-align: left; font-weight: bolder;">
                <h2>${requestScope.mPostOne.mountainPostSubject}</h2>
            </th>
        </tr>
        <tr>
            <td colspan="6" align="left">
                <h5>${mPostOne.mountainPostWriter}  ｜  ${mPostOne.mountainPostDate}  ｜  추천 ${mPostOne.mountainRecommend}</h5>
            </td>
        </tr>
        <tr>
            <th>지역</th>
            <th>산</th>
            <th>등산코스</th>
            <th>소요시간</th>
            <th>일행</th>
            <th>난이도</th>
        </tr>
        <tr align="center">
            <td>${mPostOne.mountainRegion}</td>
            <td>${mPostOne.mountainName}</td>
            <td>${mPostOne.mountainCourse}</td>
            <td>${mPostOne.mountainTime}시간</td>
            <td>${mPostOne.mountainParty}명</td>
            <td>${mPostOne.mountainLevel}</td>
        </tr>
        <tr>
            <th colspan="3">주의사항</th>
            <th colspan="3">준비물</th>
        </tr>
        <tr align="center">
            <td colspan="3">${mPostOne.mountainCaution}</td>
            <td colspan="3">${mPostOne.mountainNeed}</td>
        </tr>
        <tr>
            <th colspan="6" align="center">
                내용
            </th>
        </tr>
        <tr>
            <td colspan="6" align="center">
                ${mPostOne.mountainPostContents}
            </td>
        </tr>
        <tr>
            <th colspan="6" align="center">
                인증사진
            </th>
        </tr>
        <tr>
            <td colspan="6" align="center">
            	<img src="${pageContext.request.contextPath}/mtUpload/${mFileOne.fileName}" alt="">
            </td>
        </tr>
        <tr>
            <td colspan="3" align="right" style="width: 50%;">
            	<form action="/mountainPost/recommend" method="post">
                    <button type="submit" name="mountainRecommend" value="${mPostOne.mountainRecommend}">추천 ${mPostOne.mountainRecommend}</button>
                    <input type="hidden" name="mountainPostNo" value="${mPostOne.mountainPostNo}">
                </form>
            </td>
            <td colspan="3" align="left">
                <form action="/report/write">
                    <button>신고</button>
                </form>
            </td>
        </tr>
    </table><hr><br>
    <!-- 댓글 출력 -->
    <table class="t__reply">
        <c:forEach items="${mPostOne.replies}" var="reply">
            <tr colspan="6" align="center">
                <td>${reply.replyWriter}</td>
                <td style="width: 60%;">${reply.replyContents}</td>
                <td>${reply.replyDate}</td>
                <td>
                    <a href="javascript:void(0)" onclick="showModifyReply(this)" class="btn">수정</a>&nbsp;&nbsp;
                    <a href="/mountainPostReply/delete?mountainPostNo=${reply.mountainPostNo}&replyNo=${reply.replyNo}" class="btn">삭제</a>
                </td>
            </tr>
            <tr style="display: none; width: 1500px;" colspan="6" align="center";>
                <td>${reply.replyWriter}</td>
                <td>
                    <input type="text" value="${reply.replyContents}" id="modifyReply" style="width: 800px; padding: 5px;">
                </td>
                <td>
                    <a href="javascript:void(0)" onclick="modifyReply(this, ${reply.replyNo}, ${reply.mountainPostNo})" class="btn">등록</a>&nbsp;&nbsp;
                    <a href="javascript:void(0)" onclick="hideModifyReply(this)" class="btn">취소</a>
                </td>
            </tr>
        </c:forEach>
    </table><hr>
    <!-- 댓글 입력 -->
    <table class="t__reply_write">
        <tr colspan="6" align="center">
            <form action="/mountainPostReply/write" method="post">
                <input type="hidden" name="m-post-no" value="${mPostOne.mountainPostNo}">
                <input type="text" name="reply-contents" placeholder="댓글을 입력하세요" class="t__reply" style="margin-left: 300px; width: 1200px; padding: 5px;">&nbsp;
                <input type="submit" value="등록" class="btn">
            </form>
        </tr>
    </table>
<!-- 전송용 폼태그 -->
    <form action="/mountainPostReply/modify" method="post" id="modifyForm">
        <input type="hidden" name="replyContents" id="modifyReplyContents">
        <input type="hidden" name="replyNo" id="modifyReplyNo">
        <input type="hidden" name="mountainPostNo" id="modifyMountainPostNo">
    </form>
    <script>
        function showModifyReply(obj) {
            $(obj).parents("tr").next().show();
            $(obj).parents("tr").hide();
        }
        function hideModifyReply(obj) {
            $(obj).parents("tr").prev().show();
            $(obj).parents("tr").hide();
        }

        function modifyReply(obj, replyNo, mountainPostNo) {
            let contents = $(obj).parent().prev().find("input").val();
            $("#modifyReplyContents").val(contents);
            $("#modifyReplyNo").val(replyNo);
            $("#modifyMountainPostNo").val(mountainPostNo);
            $("#modifyForm").submit();
        }
    </script>
    <!-- Contents End-->

<!-- Footer Section Begin -->
    <footer class="footer-section" style="text-align: center;">
        <div class="container">
            <div>
                <div>
                    <div class="logo">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            <img src="${pageContext.request.contextPath}/imgs/로고6.png" alt="">
                        </a>
                        <p>등산인증 by Ahram-Jeong</p>
                    </div>
                </div>
                <div class="col-lg-6 offset-lg-1">
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="copyright-text">
    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
        </div>
    </footer>
<!-- Footer Section End -->

<!-- Js Plugins -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.slicknav.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/mixitup.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>