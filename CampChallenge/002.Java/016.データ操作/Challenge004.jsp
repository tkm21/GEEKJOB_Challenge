<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Challenge01</title>
    </head>
    <body>
        
        <%
            
            String x = request.getParameter("num");

            int num = Integer.parseInt(x);
            int[] primes = {2,3,5,7,9};
            
            ArrayList<Integer> result = new ArrayList();
            
            for(int i = 0; i < primes.length; i ++) {
                if(num % primes[i] == 0) {
                    num = num / primes[i];
                    result.add(primes[i]);
                    if(num % primes[i] == 0){
                        i --;
                    }
                }
            }
            
            int size = result.size();
            
            out.print(x + " = ");
            for(int i = 0; i < size; i++) {
                if(result.get(i) != null) {
                    out.print(result.get(i));
                    if(i != size-1) {
                        out.print(" × ");
                    }
                }
            }
            
        %>
        
    </body>
</html>