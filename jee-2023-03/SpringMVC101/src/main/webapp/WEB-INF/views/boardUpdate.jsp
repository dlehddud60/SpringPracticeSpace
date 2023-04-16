<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Spring MVC01</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Spring MVC01</h2>
    <div class="panel panel-default">
        <div class="panel-heading">BOARD</div>
        <div class="panel-body">
            <form action="/boardUpdate.do" method="post">
                <input type="hidden" name="idx" value="${vo.idx}">
                <table class="table table-bordered">
                    <tr>
                        <td>제목</td>
                        <td><input type="text" name="title" class="form-control" value="${vo.title}"></td>
                    </tr>

                    <tr>
                        <td>내용</td>
                        <td><textarea name="content" class="form-control"  rows="7">${vo.content}</textarea></td>
                    </tr>

                    <tr>
                        <td>작성자</td>
                        <td><input type="text" class="form-control" value="${vo.writer}" readonly></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-primary btn-sm">수정</button>
                            <button type="reset" class="btn btn-warning btn-sm">취소</button>
                            <a href="/boardList.do" type="button" class="btn btn-info btn-sm">목록</a>
                        </td>
                    </tr>


                </table>
            </form>


        </div>
        <div class="panel-footer">인프런_스프1탄_이동영</div>
    </div>
</div>

</body>
</html>
