
package jums;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResultDetail extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // IDの取得
        String id = request.getParameter("id");
        
        // セッションの開始
        HttpSession session = request.getSession();
        // 直リンク禁止用
        session.setAttribute("ac", (int)(Math.random() * 1000));
        
        try {
            
            // 直リンク防止用 id指定のない場合
            if(id == null) {
                throw new Exception("不正なアクセスです");
            }
            
            // IDから他の情報を取得
            UserDataBeans udb = UserDataDAO.getInstance().select(id);
            
            // year取り出し
            int year = Integer.parseInt(udb.getBirthday().substring(0,4));
            // month取り出し
            int month = Integer.parseInt(udb.getBirthday().substring(5, 7));
            // day取り出し
            int day = Integer.parseInt(udb.getBirthday().substring(8, 10));
        
           udb.setYear(year);
           udb.setMonth(month);
           udb.setDay(day);
            
            // セッションにudbを保存
            session.setAttribute("udb",udb);

            // resultdetail.jspに遷移
            request.getRequestDispatcher("/resultdetail.jsp").forward(request, response);
            
        } catch(SQLException error_sql) {
            
            request.setAttribute("error", error_sql.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            
        } catch(Exception e) {
            
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            
        } finally {
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
