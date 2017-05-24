<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Challenge01</title>
    </head>
    <body>

        <form action="./Challenge.jsp" method="post">
            名前<input type = "text" name = name><br>
            男性<input type = "radio" name = sex><br>
            女性<input type = "radio" name = sex><br>
            趣味<textarea name = "hobbytext"></textarea><br>
            <input type="submit" name="btnSubmit"><br>
        </form>

    </body>
</html>
