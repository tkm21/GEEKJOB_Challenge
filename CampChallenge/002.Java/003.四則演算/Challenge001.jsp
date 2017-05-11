<%
    int num1 = 1;
    int num2 = 2;
    int num3 = 3;
    int num4 = 4;

    int tasu = num1 + num2;
    int hiku = num4 - num1;
    int kake = num1 * num3;
    int waru = num4 / num3;
    int amari = num4 % num3;

    out.print(num1 + "+" + num2 + "=" + tasu + "<br>");
    out.print(num4 + "-" + num1 + "=" + hiku + "<br>");
    out.print(num1 + "*" + num3 + "=" + kake + "<br>");
    out.print(num4 + "/" + num3 + "=" + waru + "余り" + amari + "<br>");
%>
