
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Kagoyume.*"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kagoyume</title>
    </head>
    
    
    <body>
        <%
            // JavaBeans取得
            JavaBeans jb = (JavaBeans)session.getAttribute("jb");
            if(jb == null) {
                jb = new JavaBeans();
                session.setAttribute("jb", jb);
            }
        %>
            <jsp:include page="header.jsp" />
        <%
            if(jb.getSearchFlag()) {
        %>
                <jsp:include page="search.jsp" />
        <% 
            } else if(jb.getItemDisplay()) {
        %>
                <jsp:include page="item.jsp" />
        <%
            } else if(jb.getCartDisplay()) {
        %>
                <jsp:include page="cart.jsp" />
        <%
            } else if(jb.getBuyDisplay())  {
        %>
                <jsp:include page="buy.jsp" />
        <%
            } else if(jb.getBuyCompleteDisplay())  {
        %>
                <jsp:include page="buycomplete.jsp" />
        <%
            } else if(jb.getMyHistoryDisplay()) {
        %>
                <jsp:include page="myhistory.jsp" />
        <%
            } else if(jb.getAccountDisplay()) {
        %>
                <jsp:include page="account.jsp" />
        <%
            }  else if(jb.getUpdateDisplay()) {
        %>
                <jsp:include page="update.jsp" />
        <%
            } else {
        %>
                <jsp:include page="top.jsp" />
        <%
            }
        %>
     
                
    </body>
</html>
