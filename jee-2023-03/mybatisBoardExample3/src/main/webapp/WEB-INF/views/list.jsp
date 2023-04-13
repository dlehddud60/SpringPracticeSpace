<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table border="1" width="500" cellspacing="0" cellpadding="0">
    <h2>자유게시판</h2>
    <tr>
        <td>번호</td>
        <td>이름</td>
        <td>제목</td>
        <td>날자</td>
        <td>조회수</td>
    </tr>
    <c:forEach var="board" items="${list}">
        <tr>
            <td>${board.board_idx}</td>
            <td>${board.board_name}</td>
            <td>
                <a href="content?board_idx=${board.board_idx}">${board.board_title}</a>
            </td>
            <td>
                <fmt:formatDate value="${board.board_date}" pattern="yyyy-MM-dd"/>

            </td>
            <td>${board.board_hit}</td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="write"><input type="button" value="글쓰기"></a></td>
    </tr>
</table>


</body>
</html>
