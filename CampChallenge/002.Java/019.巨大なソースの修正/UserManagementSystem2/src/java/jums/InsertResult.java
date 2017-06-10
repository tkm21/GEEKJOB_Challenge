
package jums;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
        UserDataDTO udd = new UserDataDTO();
        
        try{
            
            // 直リンク禁止
            if(request.getParameter("ac") == null || (Integer)session.getAttribute("ac") != Integer.parseInt(request.getParameter("ac"))){
                try {
                    request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
                    throw new Exception();
                } catch(Exception e) {
                    throw new Exception("不正なアクセスです");
                }
            }
            
            // uddに格納
            udd = JumsHelper.getInstance().uddSet(udd, udb);
            
            // データを追加
            udb = UserDataDAO.getInstance().insert(udd);
            session.setAttribute("udb", udb);
            
            // 更新禁止
            session.setAttribute("ac", (int)(Math.random() * 1000));
            
            // /insertresult.jspに遷移
            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
            
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
