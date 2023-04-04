<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>글작성</h1>
<form method="post">
    <input type="hidden" name="no">
    <input type="text" name="title" placeholder="제목" value="${board.title}"><br><br>
    <input type="text" name="writer" placeholder="작성자" value="${board.writer}"><br><br>
    <textarea name="content" cols="60" rows="5">${board.content}</textarea><br><br>
    <button type="submit">글쓰기</button>
</form>

