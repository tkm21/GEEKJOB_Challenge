
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<%@ page import = "jums.*" %>

<!DOCTYPE html>
<html>
    
    
    <head>
        <meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">
        <title>エラー</title>
    </head>
    
    
    <body>
        
        <div align = "center">
            
            <h1>エラー</h1>
            
            エラーが発生しました。<br>
            
            <br>
            
            <!-- エラーメッセージ表示 -->
            <%= request.getAttribute("error") %><br>
            
            <br>
        
            <!-- トップリンク表示 -->
            <%= JumsHelper.getInstance().home() %>
        
        </div>
        
    </body>
    
    
</html>
