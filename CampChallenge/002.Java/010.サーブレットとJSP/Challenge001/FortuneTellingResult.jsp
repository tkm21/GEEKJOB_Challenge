
<%@page import="org.camp.sample.ResultData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultData data = (ResultData)request.getAttribute("DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
        <%
           if (data != null) {
               out.print("今日、最も良い運勢なのは...<br><br>" + data.getLuck() + "のあなた！");
           }
        %>
        </h1>
    </body>
</html>
