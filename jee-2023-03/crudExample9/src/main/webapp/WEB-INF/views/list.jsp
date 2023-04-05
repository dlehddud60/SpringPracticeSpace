<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>자유게시판</h1>
<table border="1" width="500">
    <thead>
        <tr>
            <th>번호</th>
            <th width="40%">제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
    </thead>


    <tbody align="center">
        <c:forEach var="board" items="${list}">
            <tr>
                <td>${board.no}</td>
                <td align="left">
                    <a href="detail?no=${board.no}">${board.title}</a>
                </td>
                <td>${board.writer}</td>
                <td>
                    <fmt:formatDate value="${board.writeTime}" pattern="y년 MM월 dd일"></fmt:formatDate>

                </td>
                <td>${board.readCount}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="write" type="button">글쓰기</a>