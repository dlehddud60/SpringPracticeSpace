<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">회원제 게시판</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${contextPath}/">Home</a></li>
<%--                <li class="dropdown">--%>
<%--                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>--%>
<%--                    <ul class="dropdown-menu">--%>
<%--                        <li><a href="#">Page 1-1</a></li>--%>
<%--                        <li><a href="#">Page 1-2</a></li>--%>
<%--                        <li><a href="#">Page 1-3</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
                <li><a href="boardMain.do">게시판</a></li>
                <li><a href="#">Page 2</a></li>
            </ul>
            <c:if test="${empty mvo}">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="memLoginForm.do"><span class="glyphicon glyphicon-user"></span>로그인</a></li>
                    <li><a href="memJoin.do"><span class="glyphicon glyphicon-log-in"></span>회원가입</a></li>
                </ul>
            </c:if>

            <c:if test="${!empty mvo}">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="memUpdateForm.do"><span class="glyphicon glyphicon-user"></span> 회원정보수정</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>프로필사진등록</a></li>
                    <li><a href="memLogout.do"><span class="glyphicon glyphicon-log-in"></span>로그아웃</a></li>
                </ul>
            </c:if>
        </div>
    </div>
</nav>