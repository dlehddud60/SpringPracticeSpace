<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="writeAction" method="post">
    <table>
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
            <td><textarea name="board_content"  cols="50" rows="10"></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="글쓰기">
                <a href="list"><input type="button" value="목록"></a>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
