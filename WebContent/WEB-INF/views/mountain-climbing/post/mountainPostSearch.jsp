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
            border: 1px solid white;
            align-items: center;
            width:1500px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 30px;
            margin-bottom: 50px;
            border-collapse: separate;
		    border-spacing: 1px;
		    line-height: 1.5;
        }
        .t__contents tr {
            height: 50px;
        }
        .t__head {
            background: #b2dfdb;
            color: white;
            font-size: 1.2em;
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
                                <li><a href="#">나무심기 캠페인</a></li>
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
        <tr class="t__head" align="center">
            <th>No.</th>
            <th style="width: 60%;">제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>인증상태</th>
        </tr>
        <c:forEach items="${requestScope.mList}" var="mPost">
        <tr align="center">
            <td>${mPost.mountainPostNo}</td>
            <td><a href="/mountainPost/detail?mountainPostNo=${mPost.mountainPostNo}">${mPost.mountainPostSubject}</a></td>
            <td>${mPost.mountainPostWriter}</td>
            <td>${mPost.mountainPostDate}</td>
            <td>${mPost.mountainPostState}</td>
        </tr>
        </c:forEach>
<!-- 검색, 글쓰기, 네비게이터 -->
        <tr>
            <td colspan="4" align="center">
                <form action="/mountainPost/search" method="get">
                    <input type="text" name="m-search-keyword" style="width: 80%; padding: 5px;">
                    <input type="submit" value="검색" class="btn">
                </form>
            </td>
            <td align="center">
                <form action="/mountainPost/write" method="get">
                    <input type="submit" value="글쓰기" class="btn">
                </form>
            </td>
        </tr>
        <tr>
            <td colspan="5" align="center">
                ${pageNavi}
            </td>
        </tr>
    </table>
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