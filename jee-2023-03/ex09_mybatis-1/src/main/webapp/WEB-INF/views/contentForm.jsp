<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>글 내용</title>
</head>
<body>
    <h2>글 내용</h2>
    <form action="updateAction" method="post">
        <table width="500" cellpadding="0" cellspacing="0" border="1">
            <input type="hidden" name="board_idx" value="${dto.board_idx}">
            <tr>
                <td>번호</td>
                <td>${dto.board_idx}</td>
            </tr>
            <tr>
                <td>조회수</td>
                <td>${dto.board_hit}</td>
            </tr>

            <tr>
                <td>이름</td>
                <td><input type="text" name="board_name" value="${dto.board_name}" size="50"></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" name="board_title" value="${dto.board_title}" size="50"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea name="board_content" cols="40" rows="10">${dto.board_content}</textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    &nbsp;&nbsp;<input type="submit" value="글">&nbsp;&nbsp;
                    <a href="listForm"><input type="button" value="목록보기"></a>&nbsp;&nbsp;
                    <a href="deleteAction?board_idx=${dto.board_idx}"><input type="button" value="삭제하기"></a>&nbsp;&nbsp;
                </td>
            </tr>

        </table>
    </form>
    <br>
    <form action="writeReplyAction" method="post">
        <table width="500" cellpadding="0" cellspacing="0" border="1">
            <tr>
                <td colspan="2">
                    <input type="hidden" name="reply_board_index" value="${dto.board_idx}">
                    <label>댓글</label><textarea name="reply_content" cols="50" rows="2"></textarea><br>
                    <label>별명</label><input type="text" name="reply_name" value=""><br>
                    <input type="submit" value="댓글달기">
                </td>
            </tr>
        </table>
    </form>



    <br>

    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <tr>
            <th>별명</th>
            <th>내용</th>
            <th>날짜</th>
            <th>삭제</th>
        </tr>

        <c:forEach var="reply_dto" items="${reply_list}">
            <tr>
                <td>${reply_dto.reply_name}</td>
                <td>${reply_dto.reply_content}</td>
                <td>
                    <fmt:formatDate value="${reply_dto.reply_date}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </td>
                <td><a href="deleteReplyAction?reply_idx=${reply_dto.reply_idx}&board_idx=${dto.board_idx}"><button>삭제</button></a></td>
            </tr>
        </c:forEach>

    </table>


</body>
</html>
