<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Santada ｜ 등산인증</title>
</head>
<body>
    <h1 style="text-align: center;">등산인증</h1>
    <table border="1">
        <tr>
            <th>No.</th>
            <th>제목</th>
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
                    <input type="text" name="m-search-keyword" id="">
                    <input type="submit" value="검색">
                </form>
            </td>
            <td>
                <form action="/mountainPost/write" method="get">
                    <input type="submit" value="글쓰기">
                </form>
            </td>
        </tr>
        <tr>
            <td colspan="5" align="center">
                ${pageNavi}
            </td>
        </tr>
    </table>
</body>
</html>