<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import=""%>--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Challenge01</title>
    </head>
    <body>
        <form action="./Challenge007.jsp" method="post">
            名前：<input type = "text" name = name><br>
            性別：男性<input type = "radio" name = sex value = 男性>
            女性<input type = "radio" name = sex value = 女性><br>
            趣味：<textarea name = "hobby"></textarea><br>
            <input type="submit" name="btnSubmit"><br>
        </form>
        <%


            request.setCharacterEncoding("UTF-8");

            String a = request.getParameter("name");
            String b = request.getParameter("sex");
            String c = request.getParameter("hobby");

            HttpSession hs = request.getSession();
            hs.setAttribute("name", a);
            hs.setAttribute("sex", b);
            hs.setAttribute("hobby", c);


            String name = (String)hs.getAttribute("name");
            out.print("名前：");
            out.print(name + "<br>");



            String sex = (String)hs.getAttribute("sex");
            out.print("性別：");
            if(sex != null) {
                out.print(sex + "<br>");
            } else {
                out.print("<br>");
            }




            String hobby = (String)hs.getAttribute("hobby");
            out.print("趣味：");
            out.print(hobby + "<br>");


        %>

    </body>
</html>
