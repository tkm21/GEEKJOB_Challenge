
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<%@ page import = "Kagoyume.*" %>

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
            
        
        </div>
        
    </body>
    
    
</html>
