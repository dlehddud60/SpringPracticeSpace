<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table border="1" width="500">
    <tr>
        <th width="25%">번호</th>
        <td>${board.no}</td>
    </tr>
    <tr>
        <th>제목</th>
        <td>${board.title}</td>
    </tr>
    <tr>
        <th>작성자</th>
        <td>${board.writer}</td>
    <tr height="200" valign="top">
        <th>내용</th>
        <td>
            <pre>${board.content}</pre>
        </td>
    </tr>
    <tr>
        <th>조회수</th>
        <td>${board.readCount}</td>
    </tr>
    <tr>
        <th>작성일</th>
        <td>
            <fmt:formatDate value="${board.writeTime}" pattern="y년  M월 d일 E a h시 m분 s초"/>
        </td>
    </tr>

</table>

<h2><a href="./">몰록으로</a></h2>
<h2><a href="edit?no=${board.no}">수정하기</a></h2>
<h2><a href="delete?no=${board.no}">삭제하기</a></h2>