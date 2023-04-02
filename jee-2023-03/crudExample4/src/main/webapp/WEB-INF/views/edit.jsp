<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>수정</h1>
<form method="post">
    <input type="hidden" name="no" value="${board.no}"><br><br>
    <input type="text" name="title" value="${board.title}"><br><br>
    <input type="text" name="writer" value="${board.writer}"><br><br>
    <textarea name="content" cols="60" rows="5">${board.content}</textarea><br><br>
    <button type="submit">수정</button>
</form>

