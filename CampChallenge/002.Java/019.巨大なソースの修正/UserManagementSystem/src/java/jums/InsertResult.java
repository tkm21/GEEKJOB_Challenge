
package jums;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertResult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
        
        try{
            // 直リンク防止用(エラーをキャッチした場合"/error.jsp"へ移動)
            if(request.getParameter("ac") == null || (Integer)session.getAttribute("ac") == null || (Integer)session.getAttribute("ac") != Integer.parseInt(request.getParameter("ac"))){
                throw new Exception("不正なアクセスです");
            }
            
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            UserDataDTO userdata = new UserDataDTO();
            
            // nameの格納
            userdata.setName(udb.getName());
            
            // Dateに変換
            Calendar birthday = Calendar.getInstance();
            birthday.set(udb.getYear(), udb.getMonth() - 1, udb.getDay());
            
            // birthdayの格納
            userdata.setBirthday(udb.getYear(),udb.getMonth(),udb.getDay());
            
            // タイプ番号の格納
            userdata.setType(udb.getType());
            
            // 電話番号の格納
            userdata.setTell(udb.getTell());
            
            // コメントの格納
            userdata.setComment(udb.getComment());
            
            //DBへデータの挿入
            UserDataDAO.getInstance().insert(userdata);
            
            // 二重登録防止のためにリセット
            session.setAttribute("ac", (int)(Math.random() * 1000));
            
            // 登録結果に遷移
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
