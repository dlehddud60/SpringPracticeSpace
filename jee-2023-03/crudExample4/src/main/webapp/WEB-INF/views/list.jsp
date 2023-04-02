<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>자유게시판</h1>

<table border="1" width="600">
    <thead>
    <tr>
        <td>번호</td>
        <td width="40%">제목</td>
        <td>작성자</td>
        <td>작성일</td>
        <td>조회수</td>
    </tr>
    </thead>

    <thead align="center">
    <c:forEach var="board" items="${list}">
        <tr>
            <td>${board.no}</td>
            <td align="left">
                <a href="detail?no=${board.no}">
                        ${board.title}
                </a>
            </td>
            <td>${board.writer}</td>
            <td>
                <fmt:formatDate value="${board.writeTime}" pattern="y-mm-dd"></fmt:formatDate>
            </td>
            <td>${board.readCount}</td>
        </tr>
    </c:forEach>

    </thead>
</table>

<a href="write"><input type="button" value="글쓰기"></a>
