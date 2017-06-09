
package jums;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InsertConfirm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            
            // セッションの開始
            HttpSession session = request.getSession();
            
            // セッションに格納する文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");
            
            // 直リンク防止用 acが一致しない場合
            if(request.getParameter("ac") == null || (Integer)session.getAttribute("ac") != Integer.parseInt(request.getParameter("ac"))){
                throw new Exception("不正なアクセスです");
            }
            
            //フォームからの入力を取得
            // name
            String name = request.getParameter("name");
            // year
            int year = 0;
            if(!request.getParameter("year").equals("")) {
                year = Integer.parseInt(request.getParameter("year"));
            }
            // month
            int month = 0;
            if(!request.getParameter("month").equals("")) {
                month = Integer.parseInt(request.getParameter("month"));
            }
            // day
            int day = 0;
            if(!request.getParameter("day").equals("")) {
                day = Integer.parseInt(request.getParameter("day"));
            }
            // type
            int type = Integer.parseInt(request.getParameter("type"));
            // tell
            String tell = request.getParameter("tell");
            // comment
            String comment = request.getParameter("comment");
            
            // udbにデータを格納
            UserDataBeans udb = new UserDataBeans();
            
            udb.setName(name);
            udb.setYear(year);
            udb.setMonth(month);
            udb.setDay(day);
            if(year != 0 && month != 0 && day != 0){
                udb.setBirthday(year, month, day);
            }
            udb.setType(type);
            udb.setTell(tell);
            udb.setComment(comment);
            udb.setCount(true);
            
            // udbをセッションに格納
            session.setAttribute("udb", udb);
            
            // 入力不足確認
            if(!udb.getName().equals("") && udb.getYear() != 0 && udb.getMonth() != 0 && udb.getDay() != 0 && udb.getType() != 0 && !udb.getTell().equals("") && !udb.getComment().equals("")) {
                // "insertcomfilm.jsp"へ移動
                request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
            } else {
                // "insert.jsp"へ移動
                request.getRequestDispatcher("/insert.jsp").forward(request, response);
            } 
            
            
            
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
