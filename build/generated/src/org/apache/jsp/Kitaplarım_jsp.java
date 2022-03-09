package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jdbc.DatabaseOperations;

public final class Kitaplarım_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Document</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"detailStyle.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n");
      out.write("        integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" crossorigin=\"anonymous\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <div class=\"logo\">E-KÜTÜPHANE</div>\n");
      out.write("\n");
      out.write("        <ul class=\"menu\">\n");
      out.write("            <a href=\"AnaSayfa.jsp\">Ana Sayfa</a>\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("        <ul class=\"buttons\">\n");
      out.write("            <div class=\"row\"> <div class=\"col-md-5\"><button onClick=\"location.href='Hesabım.jsp'\" style=\"width: 100px; height: 35px;\">Hesabım</button>\n");
      out.write("                </div><div class=\"col-md-5\">\n");
      out.write("                <form action=\"CikisIslemleri\" method=\"post\"><button type=\"submit\" style=\"width: 100px; height: 35px;\">ÇıkışYap</button></form></div></div>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    ");

        HttpSession sess=request.getSession();
    
      out.write("\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <form action=\"CezaIslemleri\" method=\"post\">\n");
      out.write("        \n");
      out.write("            <div class=\"ceza\">");
 out.print(DatabaseOperations.getUserPENALTY((int)sess.getAttribute("USER_ID"))); 
      out.write("₺</div><br>\n");
      out.write("        <h4>Ceza Miktarı</h4>\n");
      out.write("        <hr>\n");
      out.write("        <button type=\"submit\" style=\"margin-top: 0px;\">Cezayı Öde</button>\n");
      out.write("        </form>\n");
      out.write("            \n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"vr\"></div>\n");
      out.write("    \n");
      out.write("    <div class=\"bookHistory\">\n");
      out.write("        <h5>Kitaplarım</h5>\n");
      out.write("        <hr>\n");
      out.write("        ");

            String str[][]=DatabaseOperations.getBooksInUsageInfo((int)sess.getAttribute("USER_ID"));
            
            if(str!=null) {
            
                for(int i=0;i<str.length;i++) {

                    out.print("<div class=\"books\">");
                    out.print("<img src=\"Assets/BookCovers/"+str[i][0]+"\">");
                    out.print("<ul>");
                    out.print("<li><h6>Kitap: </h6> <h5>"+str[i][1]+"</h5></li>");
                    out.print("<li><h6>Yazar: </h6> <h5>"+str[i][2]+"</h5></li>");
                    out.print("<li><button >Oku</button></li>");
                    out.print("<li><form action=\"KullanimdakiKitaplarIslemleri\" method=\"post\"><button type=\"submit\" value=\""+str[i][3]+"\" name=\"ISUBMIT\">Teslim Et</button></form></li>");
                    out.print("</ul>");
                    out.print("</div>");
                }
            }
        
      out.write("\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("\n");
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
