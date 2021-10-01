<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Santada ｜ 게시글 수정</title>
</head>
<body>
    <h1 style="text-align: center;">등산인증</h1>
    <form action="/mountainPost/modify" method="post">
        <div>
            <input type="text" name="post-sub" size="100%" value="${requestScope.mPostOne.mountainPostSubject}">
        </div>
        <div>
            <b>지역</b>
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
            <b>산</b>
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
            <b>코스</b>
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
            <b>소요 시간</b>
            <input type="number" name="mountain-time" value="${mPostOne.mountainTime}">시간
            <b>일행</b>
            <input type="number" name="mountain-party" value="${mPostOne.mountainParty}">명
            <b>난이도</b>
            <select name="mountain-level" id="">
                <option value="1">★</option>
                <option value="2">★★</option>
                <option value="3">★★★</option>
                <option value="4">★★★★</option>
                <option value="5">★★★★★</option>
            </select>
        </div>
        <div>
            <b>주의사항</b><br>
            <textarea name="mountain-caution" id="" cols="60" rows="5">${mPostOne.mountainCaution}</textarea><br>
        </div>
        <div>
            <b>준비물</b><br>
            <textarea name="mountain-need" id="" cols="60" rows="5">${mPostOne.mountainNeed}</textarea><br>
        </div>
        <div>
            <b>내용</b><br>
            <textarea name="post-con" id="" cols="140" rows="10">${mPostOne.mountainPostContents}</textarea>
        </div>
        <div>
            <b>첨부된 이미지 : </b>${mFileOne.fileName}
        </div><br>
        <input type="hidden" name="m-post-no" value="${mPostOne.mountainPostNo}">
        <input type="submit" value="등록">
        <input type="reset" value="취소">
    </form>
</body>
</html>