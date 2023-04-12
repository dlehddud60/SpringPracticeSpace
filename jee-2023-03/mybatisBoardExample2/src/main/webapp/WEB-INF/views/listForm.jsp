<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
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
    <h2>자유게시판</h2>
    <table width="500" border="1" cellspacing="0" cellpadding="0">
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>제목</th>
            <th>날짜</th>
            <th>조회수</th>
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
        <tr><td colspan="5"><a href="write">글작성</a></td></tr>
    </table>
</body>
</html>
