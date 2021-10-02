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
    <form action="/mountainPost/write" method="post" enctype="multipart/form-data">
        <table class="t__contents">
            <tr>
                <th colspan="6">
                    제목
                </th>
            </tr>
            <tr>
                <td colspan="6">
                    <input type="text" name="post-sub" style="width: 1500px;" placeholder="제목을 입력해주세요">
                </td>
            </tr>
            <tr align="center">
                <th>지역</th>
                <th>산</th>
                <th>등산코스</th>
                <th>소요시간</th>
                <th>일행</th>
                <th>난이도</th>
            </tr>
            <tr align="center">
                <td>
                    <select name="mountain-region" id="">
                        <option>선택</option>
                        <option value="서울">서울</option>
                        <option value="경기도">경기도</option>
                        <option value="충청도">충청도</option>
                        <option value="전라도">전라도</option>
                        <option value="경상도">경상도</option>
                        <option value="강원도">강원도</option>
                        <option value="제주도">제주도</option>
                    </select>
                </td>
                <td>
                    <select name="mountain-name" id="">
                        <option>선택</option>
                        <option>====서울====</option>
                        <option value="북한산">북한산</option>
                        <option>===경기도===</option>
                        <option value="검단산">검단산</option>
                        <option>===충청도===</option>
                        <option value="월악산">월악산</option>
                        <option value="속리산">속리산</option>
                        <option value="계룡산">계룡산</option>
                        <option>===전라도===</option>
                        <option value="마이산">마이산</option>
                        <option value="내장산">내장산</option>
                        <option>===경상도===</option>
                        <option value="대야산">대야산</option>
                        <option value="지리산">지리산</option>
                        <option value="팔공산">팔공산</option>
                        <option>===강원도===</option>
                        <option value="두타산">두타산</option>
                        <option value="설악산">설악산</option>
                        <option>===제주도===</option>
                        <option value="한라산">한라산</option>
                    </select>
                </td>
                <td>
                    <select name="mountain-course" id="">
                        <option>선택</option>
                        <option>====북한산====</option>
                        <option value="백운대 코스">백운대 코스</option>
                        <option value="신선대 코스">신선대 코스</option>
                        <option value="우이암 코스">우이암 코스</option>
                        <option value="비봉 코스">비봉 코스</option>
                        <option>====검단산====</option>
                        <option value="현충탑 코스">현충탑 코스</option>
                        <option>====월악산====</option>
                        <option value="영봉 보덕암 코스">영봉 보덕암 코스</option>
                        <option value="구담봉 코스">구담봉 코스</option>
                        <option value="백두대간 코스">백두대간 코스</option>
                        <option>====속리산====</option>
                        <option value="천왕봉 왕복 코스">천왕봉 왕복 코스</option>
                        <option value="문장대 코스">문장대 코스</option>
                        <option>====계룡산====</option>
                        <option value="동학사 왕복 코스">동학사 왕복 코스</option>
                        <option value="수통골 왕복 코스">수통골 왕복 코스</option>
                        <option>====마이산====</option>
                        <option value="암마이봉 코스">암마이봉 코스</option>
                        <option>====내장산====</option>
                        <option value="신성봉 코스">신성봉 코스</option>
                        <option value="백양사 종주 코스">백양사 종주 코스</option>
                        <option>====대야산====</option>
                        <option value="밀재 코스">밀재 코스</option>
                        <option>====지리산====</option>
                        <option value="노고단 코스">노고단 코스</option>
                        <option value="구룡 계곡 코스">구룡 계곡 코스</option>
                        <option value="뱀사골 계곡 코스">뱀사골 계곡 코스</option>
                        <option>====팔공산====</option>
                        <option value="비로봉 코스">비로봉 코스</option>
                        <option>====두타산====</option>
                        <option value="베틀바위 코스">베틀바위 코스</option>
                        <option>====설악산====</option>
                        <option value="공룡능선 코스">공룡능선 코스</option>
                        <option value="한계령 코스">한계령 코스</option>
                        <option value="오색 코스">오색 코스</option>
                        <option value="백담사 코스">백담사 코스</option>
                        <option>====한라산====</option>
                        <option value="성판악 코스">성판악 코스</option>
                        <option value="관음사 코스">관음사 코스</option>
                    </select>
                </td>
                <td>
                    <input type="number" name="mountain-time">시간
                </td>
                <td>
                    <input type="number" name="mountain-party">명
                </td>
                <td>
                    <select name="mountain-level" id="">
                        <option value="1">★</option>
                        <option value="2">★★</option>
                        <option value="3">★★★</option>
                        <option value="4">★★★★</option>
                        <option value="5">★★★★★</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th colspan="3">주의사항</th>
                <th colspan="3">준비물</th>
            </tr>
            <tr align="center">
                <td colspan="3">
                    <textarea name="mountain-caution" id="" cols="60" rows="5" placeholder="내용을 입력해주세요"></textarea>
                </td>
                <td colspan="3">
                    <textarea name="mountain-need" id="" cols="60" rows="5" placeholder="내용을 입력해주세요"></textarea>
                </td>
            </tr>
            <tr>
                <th colspan="6" align="center">
                    내용
                </th>
            </tr>
            <tr>
                <td colspan="6" align="center">
                    <textarea name="post-con" id="" cols="150" rows="10" placeholder="내용을 입력해주세요"></textarea>
                </td>
            </tr>
            <tr>
                <th colspan="6" align="center">
                    이미지 업로드
                </th>
            </tr>
            <tr>
                <td colspan="6" align="center">
                    <input type="file" name="m-post-file">
                </td>
            </tr>
            <tr>
                <td colspan="3" align="right" style="width: 50%;">
                    <input type="submit" value="등록" class="btn">
                </td>
                <td colspan="3" align="left">
                    <input type="reset" value="취소" class="btn">
                </td>
            </tr>
        </table>
    </form>
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