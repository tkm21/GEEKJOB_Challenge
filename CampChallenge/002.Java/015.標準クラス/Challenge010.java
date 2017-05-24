
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.io.*;


public class CampChallenge extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>課題</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>");
            
            
            // 余弦定理により一辺の長さを求める。ただし、小数点第1位までとする。
            
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            
            File f = new File("test.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            
            HashMap<Integer, Double> angle = new HashMap<Integer, Double>();
            angle.put(0, 1.0); //cos0° = 1
            angle.put(30, Math.pow(3, 0.5)/2); //cos0° = √3/2
            angle.put(45, 1/Math.pow(2, 0.5)); //cos0° = 1/√2
            angle.put(60, 1/2.0); //cos0° = 1/2
            angle.put(90, 0.0); //cos0° = 0
            angle.put(120, -1/2.0); //cos0° = -1/2
            angle.put(135, -1/Math.pow(2, 0.5)); //cos0° = -1/√2
            angle.put(150, Math.pow(3, 0.5)/-2); //cos0° = -√3/2
            angle.put(180, -1.0); //cos0° = -1
            
            bw.write(sdf.format(now) + "　タイトルの表示　　　開始<br>");
            out.print("***余弦定理計算プログラム***<br>");
            bw.write(sdf.format(now) + "　タイトルの表示　　　終了<br>");
            
            
            bw.write(sdf.format(now) + "　パラメーターの表示　開始<br>");
            double a = 3.0;
            out.print("a = " + a);
            double a2 = Math.pow(a, 2); // a^2
            double b = 4.0;
            out.print(" b = " + b);
            double b2 = Math.pow(b, 2); // b^2
            Integer C = 90;
            out.print(" ∠C = " + C + "°");
            bw.write(sdf.format(now) + "　パラメーターの表示　終了<br>");
            
            
            bw.write(sdf.format(now) + "　計算　　　　　　　　開始<br>");
            double cosC = angle.get(C);
            double c = Math.pow(a2 + b2 - (2 * a * b * cosC),0.5); // c = (a^2 + b^2 -2abcosC)^0.5
            bw.write(sdf.format(now) + "　計算　　　　　　　　終了<br>");
            
            
            bw.write(sdf.format(now) + "　計算結果の表示　　　開始<br>");
            out.print(" のとき<br>");
            out.print("c = " + String.format("%.1f", c) + "<br>");
            bw.write(sdf.format(now) + "　計算結果の表示　　　終了<br>");
            
            bw.close();
            
            out.print("<br>***ログの表示***<br>");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            while(str != null) {
                out.print(str + "<br>");
                str = br.readLine();
            }
            
            br.close();
            
            
            out.println("</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
