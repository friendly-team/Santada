<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Santada ｜ 등산인증</title>
<style>
    table {
        width: 60%;
        height: 300px;
    }
    img {
        width: 500px;
    }
</style>
</head>
<body>
    <div>
        <h1 style="text-align: center;">등산인증</h1>
    </div>
    <table>
        <tr>
            <td colspan="6" align="right">
                <a href="/mountainPost/list">목록</a>
                <a href="/mountainPost/modify?mountainPostNo=${mPostOne.mountainPostNo}">수정</a>
                <a href="/mountainPost/remove?mountainPostNo=${mPostOne.mountainPostNo}">삭제</a>
            </td>
        </tr>
        <tr>
            <th colspan="6">
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
            <td colspan="6" align="center">
                <a href="#">추천</a>
                <a href="#">신고</a>
            </td>
        </tr>
    </table>
<!-- 댓글 입력 -->
<!-- 댓글 출력 -->
<!-- 전송용 폼태그 -->
</body>
</html>