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
    <title>Santada ｜ 나무심기 캠페인</title>
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
            width:800px;
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
        <h1 style="text-align: center; font-size: 30px;">나무심기 캠페인</h1>
    </div>
    <form action="/treeCampaign/write" method="post" id="tree-form">
        <table class="t__contents">
            <tr>
                <th>
                    참여자 이름
                </th>
            </tr>
            <tr>
                <td>
                    <input type="text" name="tree-participant" placeholder="이름을 입력해주세요 (최대 8자)" style="width: 800px;">
                </td>
            </tr>
            <tr>
                <th>
                    팻말에 쓸 내용
                </th>
            </tr>
            <tr>
                <td>
                    <input type="text" name="tree-con" placeholder="내용을 입력해주세요 (최대 30자)" style="width: 800px;">
                </td>
            </tr>
            <tr>
                <td>
                    <p>※ 캠페인 진행 확정 여부는 '마이페이지 > 포인트 조회 > 나무 포인트'의 포인트 현황을 통하여 확인 가능합니다.
                        <br>가용 포인트를 초과하여 중복 참여할 경우, 최초 참여 내역으로 진행이 확정됩니다. (확정 시, 나무 포인트 500점 차감)
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="참여" class="btn" onclick="treeSubmit()">
                </td>
            </tr>
        </table>
        <input type="hidden" name="tree-point" id="camPoint" value="${member.treePoint}">
<!--         <input type="hidden" name="tree-participant">
        <input type="hidden" name="tree-con"> -->
    </form>
    <script>
        function treeSubmit() {
            alert("${userId}님의 나무 포인트 : ${member.treePoint}점 \n진행 하시겠습니까? \n* 참여 시, 나무 포인트 500점 차감");
            let result = document.getElementById('camPoint').value;
            if(result < 500) {
                alert("포인트가 부족하여 참여하실 수 없습니다 ;(");
                return false;
            } else {
                alert("나무심기 캠페인에 참여되었습니다 :)");
                $("#tree-form").submit();
                return true;
            }
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
                        <p>나무심기 캠페인 by Ahram-Jeong</p>
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