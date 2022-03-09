package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jdbc.DatabaseOperations;

public final class KitapBilgileri_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Kitap Detayı</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"detailStyle.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n");
      out.write("        integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t");

		HttpSession sess=request.getSession();
                String LOGED_IN=(String)sess.getAttribute("LOGED_IN");
	
      out.write("\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <div class=\"logo\">E-KÜTÜPHANE</div>\n");
      out.write("\n");
      out.write("        <ul class=\"menu\">\n");
      out.write("            <a href=\"AnaSayfa.jsp\">Ana Sayfa</a>\n");
      out.write("            ");

                if(LOGED_IN!=null&&LOGED_IN.equals("true"))
                    out.print("<a href\"Kitaplarım.jsp\">Kitaplarım</a>");
            
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <ul class=\"buttons\">\n");
      out.write("\t\t       ");

            if(LOGED_IN!=null&&LOGED_IN.equals("true")) {
            
                out.print("<div class=\"row\"> <div class=\"col-md-5\"><button onClick=\"location.href='Hesabım.jsp'\" style=\"width: 100px; height: 35px;\">Hesabım</button> ");
                out.print("</div><div class=\"col-md-5\">");
                out.print("<form action=\"CikisIslemleri\" method=\"post\"><button type=\"submit\" style=\"width: 100px; height: 35px;\">ÇıkışYap</button></form></div></div>");
            }
            
            else {
                
                out.print("<button onClick=\"location.href='ÜyeOl.jsp'\" style=\"width: 100px; height: 35px;\">Üye Ol</button> ");
                out.print("<button onClick=\"location.href='GirişYap.jsp'\" style=\"width: 100px; height: 35px;\">Giriş Yap</button>");
            }
        
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    ");

    		String str[]=DatabaseOperations.getBookInfo(1/*(int)sess.getAttribute("BOOK_ID")*/);
    
      out.write("\n");
      out.write("    <div class=\"book\">\n");
      out.write("    \t");

    		out.print("<img src=\"Assets/BookCovers/"+str[0]+"\">");
    	
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"bookDetails\">\n");
      out.write("        <ul>\n");
      out.write("            <hr>\n");
      out.write("            <li><h4>Kitap ismi :</h4> <h5>");
      out.print( str[1] );
      out.write("</h5></li>\n");
      out.write("            <hr>\n");
      out.write("            <li><h4>Yazar Adı :</h4> <h5>");
      out.print( str[2] );
      out.write("</h5></li>\n");
      out.write("            <hr>\n");
      out.write("            <li><h4>Yayınevi :</h4> <h5>");
      out.print( str[3] );
      out.write("</h5></li>\n");
      out.write("            <hr>\n");
      out.write("            <li><h4>Kategori :</h4> <h5>");
      out.print( str[4] );
      out.write("</h5></li>\n");
      out.write("            <hr>\n");
      out.write("            <li><h4>Sayfa sayısı :</h4> <h5>");
      out.print( str[5] );
      out.write("</h5></li>\n");
      out.write("            <hr>\n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <form action=\"LogIO\"><button style=\"width: 100px; height: 35px;\" type=\"submit\">Kirala</button></form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"autor\">\n");
      out.write("        <h5> Kitap Hakkında</h5> \n");
      out.write("        <hr> \n");
      out.write("        <p>\n");
      out.write("        \t");
      out.print( str[6] );
      out.write("\n");
      out.write("        </p> \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"autor\">\n");
      out.write("        <h5> Bu Yazarın benzer kitapları</h5> \n");
      out.write("        <hr>  \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"extraBook\">\n");
      out.write("        <img src=\"sefiller.jpg\" onClick=\"location.href='#'\">\n");
      out.write("        <img src=\"sefiller.jpg\" onClick=\"location.href='#'\">\n");
      out.write("        <img src=\"sefiller.jpg\" onClick=\"location.href='#'\">\n");
      out.write("        <img src=\"sefiller.jpg\" onClick=\"location.href='#'\">\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
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
