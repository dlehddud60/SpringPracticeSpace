<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>글작성</title>
</head>
<body>
<form action="writeAction" method="post">
    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <tr>
            <td>이름</td>
            <td><input type="text" name="board_name" size="50"></td>
        </tr>

        <tr>
            <td>제목</td>
            <td><input type="text" name="board_title" size="50"></td>
        </tr>

        <tr>
            <td>내용</td>
            <td><textarea name="board_content" id="" cols="40" rows="10"></textarea></td>
        </tr>

        <tr>
            <td colspan="2">
                &nbsp;&nbsp;<input type="submit" value="글쓰기">&nbsp;&nbsp;
                <a href="list"><input type="button" value="목록보기"></a>
        </td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
