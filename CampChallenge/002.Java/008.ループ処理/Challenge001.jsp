<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int num = 8;
    for(int i=0; i<20; i++){
        num = num * 8;
        out.print(num + "<br>");
    }
%>
