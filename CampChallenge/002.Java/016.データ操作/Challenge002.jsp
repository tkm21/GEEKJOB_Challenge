<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Challenge01</title>
    </head>
    <body>

        <form action="./Challenge002.jsp" method="post">
            名前<input type = "text" name = name><br>
            男性<input type = "radio" name = sex value = 1>
            女性<input type = "radio" name = sex value = 2><br>
            趣味<textarea name = "hobby"></textarea><br>
            <input type="submit" name="btnSubmit"><br>
        </form>

        <%

            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String hobby = request.getParameter("hobby");

            out.print("<br>名前：");
            if(name != "") {
                out.print(name);
            }

            out.print("<br>性別：");
            if(sex != null) {
                if(sex.equals("1")) {
                    out.print("男性");
                } else if(sex.equals("2")) {
                    out.print("女性");
                }
            }

            out.print("<br>趣味：");
            if(hobby != "") {
                out.print(hobby);
            }

        %>

    </body>
</html>
