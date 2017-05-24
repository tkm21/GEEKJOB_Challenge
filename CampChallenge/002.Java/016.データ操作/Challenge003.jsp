<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Challenge01</title>
    </head>
    <body>

        <%
            String a = request.getParameter("type");
            String b = request.getParameter("count");
            String c = request.getParameter("total");

            int type = Integer.parseInt(a);
            int count = Integer.parseInt(b);
            int total = Integer.parseInt(c);

            // 商品種別解析
            if(type == 1) {
                out.print("雑貨<br>");
            } else if(type == 2) {
                out.print("生鮮食品<br>");
            } else if (type == 3) {
                out.print("その他<br>");
            } else {
                out.print("未指定<br>");
            }

            // 表示
            out.print(count + "点で");
            out.print("合計" + total + "円<br>");

            // １点あたりの値段
            out.print("１点あたり" + total/count + "円<br>");

            // ポイントの計算
            double point = 0;
            if(total > 5000) {
                point = total * 0.05;
            } else if(total > 3000) {
                point = total * 0.04;
            }
            out.print((int)point + "ポイント");
        %>

    </body>
</html>
