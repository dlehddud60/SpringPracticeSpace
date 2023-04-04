<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>게시글 작성</h1>
<form method="post">
    <input type="text" name="title" placeholder="제목" required><br><br>
    <input type="text" name="write" placeholder="작성자" required><br><br>
    <textarea name="content" cols="60" rows="5"></textarea><br><br>
    <button type="submit">작성하기</button>
</form>