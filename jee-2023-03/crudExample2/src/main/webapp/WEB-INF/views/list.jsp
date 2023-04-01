<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>자유 게시판</h1>
<table border="1" width="600">
    <thead>
    <tr>
        <th>번호</th>
        <th width="40%">제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="board" items="${list}">
        <tr align="center">
            <td>${board.no}</td>
            <td width="40%" align="left">
                <a href="detail?no=${board.no}">
                        ${board.title}
                </a>
            </td>
            <td>${board.writer}</td>
            <td>
                <fmt:formatDate value="${board.writeTime}" pattern="y-MM-dd"></fmt:formatDate>

            </td>
            <td>${board.readCount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button><a href="write">글쓰기</a></button>