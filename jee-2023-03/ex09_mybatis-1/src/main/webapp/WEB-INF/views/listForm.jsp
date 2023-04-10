<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>게시판</title>
    <style>
        *{
            margin: 0 auto;
            padding: 0;
            overflow: hidden;
        }

        td,h2 {
            text-align: center;
        }
    </style>
</head>
<body>
<h2>게시판 글목록</h2>
<table width="500" cellpadding="0" cellspacing="0" border="1">
    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>제목</th>
        <th>날짜</th>
        <th>조회수</th>
    </tr>


    <c:forEach var="dto" items="${list}">
        <tr>
            <td>${dto.board_idx}</td>
            <td>${dto.board_name}</td>
            <td>
                <a href="contentForm?board_idx=${dto.board_idx}">${dto.board_title}</a>
            </td>

            <td>
                <c:set var="dateVar" value="${dto.board_date}"/>
                <fmt:formatDate value="${dateVar}" pattern="yyyy-MM-dd"/>
            </td>
            <td>${dto.board_hit}</td>
        </tr>
    </c:forEach>


    <tr>
        <td colspan="5"><a href="writeForm">글작성</a></td>
    </tr>

</table>
<script>
    //웹 브라우저 back키 누를 때, 페이지 재 로딩
    window.onpageshow = function (event) {
        if(event.persisted) {
            document.location.reload();
        }
    };
</script>


</body>
</html>
