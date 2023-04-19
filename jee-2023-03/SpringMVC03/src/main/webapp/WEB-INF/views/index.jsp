<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<jsp:include page="/WEB-INF/views/common/header.jsp"/>


    <script>

        $(document) .ready(function () {
            if (${!empty msgType}) {
                $("#messageType").attr("class","modal-content panel-success");
                $("#myMessage").modal("show");
            }
        });
    </script>

<div class="container">
    <c:if test="${empty mvo}">
        <h3>회원제 게시판</h3>
    </c:if>
    <c:if test="${!empty mvo}">
        <h3>[사진]${mvo.memName}님 방문을 환영합니다.</h3>
    </c:if>
    <p>In this example, the navigation bar is hidden on small screens and replaced by a button in the top right corner (try to re-size this window).
    <p>Only when the button is clicked, the navigation bar will be displayed.</p>
</div>

<%-- 로그인 성공--%>
<%--실패 메시지 출력(modal)--%>

<div id="myMessage" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div id="messageType" class="modal-content panel-info">
            <div class="modal-header panel-heading">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">${msgType}</h4>
            </div>
            <div class="modal-body">
                <p>${msg}</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

