<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>게시글 작성</h1>

<form method="post">
    <input type="text" name="writer" placeholder="작성자" required><br><br>
    <input type="text" name="title" placeholder="재목" required><br><br>
    <textarea name="content" placeholder="내용" rows="5" cols="60" required></textarea><br><br>
    <button type="submit">등록</button>
</form>
