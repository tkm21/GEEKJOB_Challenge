
package jums;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SearchResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // セッション開始
        HttpSession session = request.getSession();
        
        // 直リンク禁止用
        session.setAttribute("ac", (int)(Math.random() * 1000));
        
        // 文字化け防止
        request.setCharacterEncoding("UTF-8");
        
        // 入力受け取り
        String name = request.getParameter("name");
        String year = request.getParameter("year");
        String type1 = request.getParameter("type1");
        String type2 = request.getParameter("type2");
        String type3 = request.getParameter("type3");
        
        try {
            
            // 情報取得
            UserDataBeans udb = UserDataDAO.getInstance().select(name, year, type1, type2, type3);
            
            // udb格納
            session.setAttribute("udb",udb);
            
            // /searchresult.jspに遷移
            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);
            
        } catch(Exception e) {
            
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            
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
