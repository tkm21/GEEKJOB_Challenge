
package Kagoyume;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;


public class Search extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        // session
        HttpSession session = request.getSession();
        
        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        
        // API
        API api = new API();
        
        // SearchDataBeans
        SearchDataBeans sdb = new SearchDataBeans();
        
        // 直リンク禁止用
        session.setAttribute("ac", (int)(Math.random() * 1000));
        
        try {
            
        // keyword取得
        String keyword;
        if(!request.getParameter("keyword").isEmpty()) {
            keyword = request.getParameter("keyword");
        } else {
            keyword = "";
        }
        
        // category取得
        String category;
        if(!request.getParameter("category").isEmpty()) {
            category = request.getParameter("category");
        } else {
            category = "1";
        }
        
        // 商品取得
        ArrayList<SearchDataBeans> itemData = api.getResult(keyword, category);
        session.setAttribute("itemData", itemData);
        
        // 検索結果の表示
        jb.setSearchFlag(true);
        session.setAttribute("jb", jb);
        
        // /index.jspに遷移
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        } catch(Exception e) {
            
            // /index.jspに遷移
            request.getRequestDispatcher("Top").forward(request, response);
            
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
