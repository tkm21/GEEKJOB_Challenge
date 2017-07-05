package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Kagoyume.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"header\">\n");
      out.write("    <div class=\"header-left\">\n");
      out.write("        <ul>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"/EC-SITE/\" class=\"logo\">Kagoyume</a>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <form action=\"Search\" method=\"GET\">\n");
      out.write("                    <select name=\"category\">\n");
      out.write("                        ");

                            int category = 1;
                            if(request.getParameter("category") != null) {
                                category = Integer.parseInt(request.getParameter("category"));
                            }
                            String keyword = "";
                            if(request.getParameter("keyword") != null) {
                                keyword = request.getParameter("keyword");
                            }
                            for(Map.Entry<Integer, String> val: KagoyumeHelper.getInstance().category().entrySet()) {
                                if(val.getKey() == category) {
                        
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( val.getKey() );
      out.write("\" selected>");
      out.print( val.getValue() );
      out.write("</option>\n");
      out.write("                        ");

                                } else {
                        
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( val.getKey() );
      out.write('"');
      out.write('>');
      out.print( val.getValue() );
      out.write("</option>\n");
      out.write("                        ");

                                }
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                        <input type=\"text\" name=\"keyword\" value=\"");
      out.print( keyword );
      out.write("\" placeholder = \"商品を検索\" class=\"search-box\">\n");
      out.write("                        <input type=\"submit\" value=\"検索\" class=\"submit-btn\">\n");
      out.write("                </form>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"header-right\">\n");
      out.write("        <ul>\n");
      out.write("            <li>ログイン</li>\n");
      out.write("            <li>カート（０）</li>\n");
      out.write("        </ul>\n");
      out.write("    </div>            \n");
      out.write("</div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
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
