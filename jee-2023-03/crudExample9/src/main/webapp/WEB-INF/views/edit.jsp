<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <form method="post">
        <input type="hidden" name="no" value="${board.no}">
        <input type="text" name="title" placeholder="제목" value="${board.title}"><br><br>
        <input type="text" name="writer" placeholder="작성자" value="${board.writer}"><br><br>
        <textarea name="content" cols="60" rows="5">${board.content}</textarea><br><br>
        <input type="password" name="password" placeholder="비밀번호" required><br><br>
        <button type="submit">작성하기</button>
        <a href="./"><button>목록</button></a>
    </form>
</div>