<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Santada ｜ 등산인증</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
    .t__contents {
        width: 60%;
        height: 300px;
    }
    .t__reply {
        width: 60%;
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
    <table border="1" class="t__contents">
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
            	<form action="/mountainPost/recommend" method="post">
                    <button type="submit" name="mountainRecommend" value="${mPostOne.mountainRecommend}">추천 ${mPostOne.mountainRecommend}</button>
                    <input type="hidden" name="mountainPostNo" value="${mPostOne.mountainPostNo}">
                </form>
                <form>
                    <button>신고</button>
                </form>
            </td>
        </tr>
    </table><br><br>
<!-- 댓글 입력 -->
    <form action="/mountainPostReply/write" method="post">
        <input type="hidden" name="m-post-no" value="${mPostOne.mountainPostNo}">
        Comment : <input type="text" name="reply-contents" placeholder="댓글을 입력하세요">
        <input type="submit" value="등록">
    </form>
<!-- 댓글 출력 -->
    <table class="t__reply">
       	<c:forEach items="${mPostOne.replies}" var="reply">
        <tr>
            <td>${reply.replyWriter}</td>
            <td>${reply.replyContents}</td>
            <td>${reply.replyDate}</td>
            <td>
                <a href="javascript:void(0)" onclick="showModifyReply(this)">수정</a>&nbsp;&nbsp;
                <a href="/mountainPostReply/delete?mountainPostNo=${reply.mountainPostNo}&replyNo=${reply.replyNo}">삭제</a>
            </td>
        </tr>
        <tr style="display: none;">
            <td><input type="text" value="${reply.replyContents}" id="modifyReply"></td>
            <td>
                <a href="javascript:void(0)" onclick="modifyReply(this, ${reply.replyNo}, ${reply.mountainPostNo})">등록</a>&nbsp;&nbsp;
                <a href="javascript:void(0)" onclick="hideModifyReply(this)">취소</a>
            </td>
        </tr>
        </c:forEach>
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
</body>
</html>