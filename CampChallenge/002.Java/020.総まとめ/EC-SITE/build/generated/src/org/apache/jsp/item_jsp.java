package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Kagoyume.*;

public final class item_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");

    // sdb
    SearchDataBeans sdb = (SearchDataBeans)session.getAttribute("usd");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"item.css\">\n");
      out.write("        <title>商品詳細</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"title\">\n");
      out.write("            商品詳細\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("            <div class=\"item-image\">\n");
      out.write("                <img src=\"");
      out.print( sdb.getProductImage());
      out.write("\" class=\"ProductImage\">\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"item-product\">\n");
      out.write("                <div class=\"item-product-top\">\n");
      out.write("                    <span class=\"item-product-name\">");
      out.print( sdb.getProductName());
      out.write("</span><br>\n");
      out.write("                    <span class=\"item-product-rate\">評価：");
      out.print( sdb.getProductRate());
      out.write("</span>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"item-product-bottom\">\n");
      out.write("                    <div class=\"item-product-price\">\n");
      out.write("                        価格：<span class=\"darkred\">");
      out.print( String.format("%,d", Integer.parseInt(sdb.getProductPrice())));
      out.write("円</span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"item-product-instruction\">\n");
      out.write("                        商品説明：<br>\n");
      out.write("                        <span>");
      out.print( sdb.getProductDescrition());
      out.write("</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                   \n");
      out.write("                    \n");
      out.write("            <div class=\"add-cart\">\n");
      out.write("                <form action=\"AddCart?product_code=");
      out.print( sdb.getProductCode() );
      out.write("\" method=\"POST\">\n");
      out.write("                    <input type=\"hidden\" name=\"productCode\" value=\"");
      out.print( sdb.getProductCode());
      out.write("\">\n");
      out.write("                    <input type=\"submit\" value=\"カートに追加\" class=\"add-cart-btn\">\n");
      out.write("                </form> \n");
      out.write("            </div>\n");
      out.write("               \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("                    \n");
      out.write("                 \n");
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
