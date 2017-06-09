
package jums;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //セッションスタート
        HttpSession session = request.getSession();
        UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
        
        try{
            
            UserDataDTO userdata = new UserDataDTO();
            
            // userdataにセット
            userdata.setUserID(udb.getID());
            userdata.setName(udb.getName());
            userdata.setBirthday(udb.getYear(), udb.getMonth(), udb.getDay());
            userdata.setType(udb.getType());
            userdata.setTell(udb.getTell());
            userdata.setComment(udb.getComment());
            
            // データの更新
            UserDataDAO.getInstance().update(userdata);
            
            // 編集結果に遷移
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
            
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
