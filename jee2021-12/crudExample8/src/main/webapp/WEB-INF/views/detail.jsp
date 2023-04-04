<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table border="1" width="500">
    <tr>
        <th>번호</th>
        <td>${board.no}</td>
    </tr>

    <tr>
        <th>작성자</th>
        <td>${board.writer}</td>
    </tr>

    <tr>
        <th>제목</th>
        <td>${board.title}</td>
    </tr>

    <tr>
        <th height="300">내용</th>
        <td valign="top">${board.content}</td>
    </tr>

    <tr>
        <th>작성시간</th>
        <td>
            <fmt:formatDate value="${board.editTime}" pattern="y년 M월 d일 E a h시 m분 s초"></fmt:formatDate>
            </td>
    </tr>

    <tr>
        <th>조회수</th>
        <td>${board.readCount}</td>
    </tr>
</table>

<h2><a href="./">목록</a></h2>
<h2><a href="edit?no=${board.no}">수정</a></h2>
<h2><a href="delete?no=${board.no}">삭제</a></h2>