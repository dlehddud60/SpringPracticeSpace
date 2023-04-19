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
    <div class="panel panel-default">
        <div class="panel-heading">
            <img src="${contextPath}/resources/images/main.jpg" style="width: 100%; height: 600px">
        </div>
        <div class="panel-body">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                <li><a data-toggle="tab" href="#menu1">게시판</a></li>
                <li><a data-toggle="tab" href="#menu2">공지사항</a></li>
            </ul>

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <h3>HOME</h3>
                    <p>Some content.</p>
                </div>
                <div id="menu1" class="tab-pane fade">
                    <h3>게시판</h3>
                    <p>Some content in menu 1.</p>
                </div>
                <div id="menu2" class="tab-pane fade">
                    <h3>공지사항</h3>
                    <p>Some content in menu 2.</p>
                </div>
            </div>
        </div>
        <div class="panel-footer">회원제게시판_이동영</div>
    </div>
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

