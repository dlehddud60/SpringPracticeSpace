<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>비밀번호 확인</h1>
<form method="post">
<input type="password" name="password" placeholder="비밀번호" required><br><br>
<label>게시글 비밀번호</label>
<h1><a href="${pageContext.request.contextPath}/detail?no=${no}">이전</a></h1>
<button type="submit">확인</button>
</form>
<c:if test="${param.error != null}">
    <h2 style="color: red">비밀번호가 맞지 않습니다.</h2>
</c:if>