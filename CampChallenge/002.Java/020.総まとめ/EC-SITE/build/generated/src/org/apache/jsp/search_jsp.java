package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Kagoyume.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"cart.css\">\n");
      out.write("        <title>検索</title>\n");
      out.write("        ");

    // 商品情報
    ArrayList<SearchDataBeans> itemData = (ArrayList<SearchDataBeans>)session.getAttribute("itemData");
    
    // フォーム初期値設定
    int category = 1;
    if(request.getParameter("category") != null) {
        category = Integer.parseInt(request.getParameter("category"));
    }
    String keyword = "";
    if(request.getParameter("keyword") != null) {
        keyword = request.getParameter("keyword");
    }

      out.write("\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            for(Map.Entry<Integer, String> val: KagoyumeHelper.getInstance().category().entrySet()) {
                if(val.getKey() == category) {
        
      out.write("\n");
      out.write("                    <div class=\"search-header\">\n");
      out.write("                        検索結果 ×××件中 1-20件 \"<span>");
      out.print( keyword );
      out.write("</span>\"\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"search-main\">\n");
      out.write("                        ");

                            for (int i = 0; i < itemData.size(); i ++) {
                        
      out.write("\n");
      out.write("                                <div class=\"search-product\">\n");
      out.write("                                    <a href=\"Item?product_code=");
      out.print( itemData.get(i).getProductCode());
      out.write("\" target=\"_blank\"><img src=\"");
      out.print( itemData.get(i).getProductImage());
      out.write("\" class=\"search-product-image\"></a>\n");
      out.write("                                    <div class=\"search-product-detail\">\n");
      out.write("                                        <span class=\"search-product-name\"><a href=\"Item?product_code=");
      out.print( itemData.get(i).getProductCode());
      out.write("\" target=\"_blank\">");
      out.print( itemData.get(i).getProductName());
      out.write("</a><br></span>\n");
      out.write("                                        <span class=\"darkred\">");
      out.print( String.format("%,d", Integer.parseInt(itemData.get(i).getProductPrice())));
      out.write("円</span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("        ");

                }
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
