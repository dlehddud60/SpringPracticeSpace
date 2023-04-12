<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>자유게시판 리스트</title>

    <style>
        *{
            margin: 0 auto;
            padding: 0;
            overflow: hidden;
        }
        td, h2 {
            text-align: center;
        }
    </style>
    <script>
        window.onpageshow = function (event) {
            if(event.persisted) {
                document.location.reload();
            }
        };

    </script>


</head>
<body>
<h2>자유게시판</h2>

    <table width="500" cellspacing="0" cellpadding="0" border="1">
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
                    <fmt:formatDate value="${dto.board_date}" pattern="yyyy-MM-dd"/>
                </td>
                <td>${dto.board_hit}</td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="5"><a href="writeForm">글작성</a></td>
        </tr>
    </table>




</body>
</html>
