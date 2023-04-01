<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>SEOULLIVE</title>
    <!-- layout css -->
    <link rel="stylesheet" href="/css/layout/layout.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>

</head>
<body>
    <%-- header --%>
    <jsp:include page="/layout/header.jsp"/>
    
    <div id="container">

        <div class="table_wrap">
            <table summary="번호, 제목, 작성자, 등록일, 조회, 첨부파일로 구성된 공지사항을 보여주는 표">
                <caption class="hide">공지사항</caption>
                <colgroup>
                    <col class="b_col01">
                    <col class="b_col02">
                    <col class="b_col03">
                    <col class="b_col04">
                    <col class="b_col05">
                    <col class="b_col06">
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">NO.</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">등록일</th>
                        <th scope="col">조회</th>
                        <th scope="col">파일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>
                            <a href="#" title="자세히 보기">제목영역</a>
                        </td>
                        <td>작성자임</td>
                        <td>2022-12-20</td>
                        <td>50</td>
                        <td>첨부파일</td>
                    </tr>
                    
                </tbody>
            </table>
        </div>

    </div>


    <%-- quickmenu footer--%>
    <jsp:include page="/layout/footer.jsp"/>
</body>

</html>