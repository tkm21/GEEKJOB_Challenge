package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Kagoyume.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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

        // JavaBeans
        JavaBeans jb = (JavaBeans)session.getAttribute("jb");
        SearchDataBeans sdb;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"cart.css\">\n");
      out.write("        <title>ショッピングカート</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"title\">ショッピングカート<br></div>\n");
      out.write("        ");

            for(int i = 0; i < jb.getCart().size(); i ++) {
                sdb = jb.getCart().get(i);
        
      out.write("\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                <a href=\"Item?product_code=");
      out.print( sdb.getProductCode());
      out.write("\" target=\"_blank\">\n");
      out.write("                        <img src=\"");
      out.print( sdb.getProductImage());
      out.write("\">\n");
      out.write("                </a>\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                <span class=\"name\"><a href=\"Item?product_code=");
      out.print( sdb.getProductCode());
      out.write("\" target=\"_blank\">");
      out.print( sdb.getProductName());
      out.write("</a></span>\n");
      out.write("                <span class=\"darkred\">");
      out.print( String.format("%,d", Integer.parseInt(sdb.getProductPrice())));
      out.write("円</span>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
