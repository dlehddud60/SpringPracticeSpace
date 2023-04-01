<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<form method="post">--%>
<%--    <input type="hidden" name="no" value="${board.no}">--%>
<%--    <input type="text" name="title" value="${board.title}" required><br><br>--%>
<%--    <input type="text" name="writer" value="${board.writer}" required><br><br>--%>
<%--    <textarea name="content" cols="60" rows="10">${board.content}</textarea><br><br>--%>
<%--    <button type="submit">수정</button>--%>
<%--</form>--%>

<form method="post">
    <input type="hidden" name="no" value="${board.no}">
    <input type="text" name="title" value="${board.title}" required><br><br>
    <input type="text" name="writer" value="${board.writer}" required><br><br>
    <textarea name="content" cols="60" rows="10">${board.content}</textarea><br><br>
    <button type="submit">수정</button>
</form>