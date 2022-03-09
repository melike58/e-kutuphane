package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.jdbc.DatabaseOperations;

public final class AnaSayfa_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <title>Document</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n");
      out.write("    integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/all.css\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  <div class=\"header\">\n");
      out.write("    <div class=\"logo\">E-KÜTÜPHANE</div>\n");
      out.write("\n");
      out.write("    <ul class=\"menu\">\n");
      out.write("      <a href=\"AnaSayfa.jsp\">Ana Sayfa</a>\n");
      out.write("      ");

            HttpSession sess=request.getSession();
            String LOGED_IN=(String)sess.getAttribute("LOGED_IN");

            if(LOGED_IN!=null&&LOGED_IN.equals("true")) {
                
                out.print("<a href=\"Kitaplarım.jsp\">Kitaplarım</a>");
            }
      
      out.write("\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    <ul class=\"buttons\">\n");
      out.write("        ");

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
      out.write("    </ul>\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <div class=\"float-none\" style=\"width: 1500px\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"sidenav col-md-2\">\n");
      out.write("          <form action=\"FiltrelemeIslemleri\" method=\"post\">\n");
      out.write("        <h5>Kategoriler</h5>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            \n");
      out.write("          <div class=\"col-md-1\"></div>\n");
      out.write("          \n");
      out.write("          <div class=\"col-md-10\">\n");
      out.write("            <ul style=\"list-style: none;\">\n");
      out.write("              <li class=\"list-group-item\"><input class=\"form-check-input\" type=\"checkbox\" value=\"Fantastik\"\n");
      out.write("                  id=\"flexCheckDefault\" name=\"CHECK_BOX_1\">\n");
      out.write("                <label class=\"form-check-label\" for=\"flexCheckDefault\">\n");
      out.write("                  Fantastik\n");
      out.write("                </label>\n");
      out.write("              </li><br>\n");
      out.write("              <li class=\"list-group-item\"><input class=\"form-check-input\" type=\"checkbox\" value=\"Gerilim\"\n");
      out.write("                  id=\"flexCheckDefault\" name=\"CHECK_BOX_2\">\n");
      out.write("                <label class=\"form-check-label\" for=\"flexCheckDefault\">\n");
      out.write("                  Gerilim\n");
      out.write("                </label>\n");
      out.write("              </li><br>\n");
      out.write("              <li class=\"list-group-item\"><input class=\"form-check-input\" type=\"checkbox\" value=\"Polisiye\"\n");
      out.write("                  id=\"flexCheckDefault\" name=\"CHECK_BOX_3\">\n");
      out.write("                <label class=\"form-check-label\" for=\"flexCheckDefault\">\n");
      out.write("                  Polisiye\n");
      out.write("                </label>\n");
      out.write("              </li><br>\n");
      out.write("              <li class=\"list-group-item\"><input class=\"form-check-input\" type=\"checkbox\" value=\"Romantik\"\n");
      out.write("                  id=\"flexCheckDefault\" name=\"CHECK_BOX_4\">\n");
      out.write("                <label class=\"form-check-label\" for=\"flexCheckDefault\">\n");
      out.write("                  Romantik\n");
      out.write("                </label>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("            \n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("        <h5>Yazar Adına Göre Ara</h5>\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"search col-md-10\">\n");
      out.write("            <input type=\"text\" id=\"yazarAdi\" name=\"SEARCH_BAR\" /><button type=\"submit\">Ara</button>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <h5>Yayınevi</h5>\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-md-1\"></div>\n");
      out.write("          <div class=\"col-md-10\">\n");
      out.write("            <ul style=\"list-style: none;\">\n");
      out.write("              <li class=\"list-group-item\"><input class=\"form-check-input\" type=\"checkbox\" value=\"Altın Kitaplar\" name=\"CHECK_BOX_5\">\n");
      out.write("                <label class=\"form-check-label\" for=\"flexCheckDefault\">\n");
      out.write("                  Altın Kitaplar\n");
      out.write("                </label>\n");
      out.write("              </li><br>\n");
      out.write("              <li class=\"list-group-item\"><input class=\"form-check-input\" type=\"checkbox\" value=\"İthaki Yayınları\" name=\"CHECK_BOX_6\">\n");
      out.write("                <label class=\"form-check-label\" for=\"flexCheckDefault\">\n");
      out.write("                  İthaki\n");
      out.write("                </label>\n");
      out.write("              </li><br>\n");
      out.write("              <li class=\"list-group-item\"><input class=\"form-check-input\" type=\"checkbox\" value=\"Pegasus\" name=\"CHECK_BOX_7\">\n");
      out.write("                <label class=\"form-check-label\" for=\"flexCheckDefault\">\n");
      out.write("                  Pegasus\n");
      out.write("                </label>\n");
      out.write("              </li>\n");
      out.write("              </li><br>\n");
      out.write("              <li class=\"list-group-item\"><input class=\"form-check-input\" type=\"checkbox\" value=\"Martı Yayınları\" name=\"CHECK_BOX_8\">\n");
      out.write("                <label class=\"form-check-label\" for=\"flexCheckDefault\">\n");
      out.write("                  Martı\n");
      out.write("                </label>\n");
      out.write("              </li>\n");
      out.write("              </li><br>\n");
      out.write("              <li class=\"list-group-item\"><input class=\"form-check-input\" type=\"checkbox\" value=\"Gollancz\" name=\"CHECK_BOX_9\">\n");
      out.write("                <label class=\"form-check-label\" for=\"flexCheckDefault\">\n");
      out.write("                  Gollancz\n");
      out.write("                </label>\n");
      out.write("              </li>\n");
      out.write("              </li><br>\n");
      out.write("              <li class=\"list-group-item\"><input class=\"form-check-input\" type=\"checkbox\" value=\"Kyrhos Yayınları\" name=\"CHECK_BOX_10\">\n");
      out.write("                <label class=\"form-check-label\" for=\"flexCheckDefault\">\n");
      out.write("                  Kyrhos\n");
      out.write("                </label>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <button class=\"filtrele\" type=\"submit\">Filtrele</button>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("            \n");
      out.write("      <div class=\"bookHistory col-md-9\">\n");
      out.write("\n");
      out.write("        <hr>\n");
      out.write("        ");

            String str0[][];
            
            if(sess.getAttribute("FILTERED")!=null&&sess.getAttribute("FILTERED").equals("true")) {
            
                str0=DatabaseOperations.getFilteredHomePage((String[])sess.getAttribute("FILTERED_RESULTS"));
                sess.setAttribute("FILTERED", "false");
            }
            
            else {
            
                str0=DatabaseOperations.getDefaultHomePage();
            }

                for(int i=0;i<str0.length;i++) {

                    out.print("<div class='books'>");
                    out.print("<img src='Assets/BookCovers/"+str0[i][0]+"'>");
                    out.print("<ul>");
                    out.print("<li><h6>Kitap: </h6><h5>"+str0[i][1]+"</h5></li>");
                    out.print("<li><h6>Yazar: </h6><h5>"+str0[i][2]+"</h5></li>");
                    out.print("<li><form action=\"FiltrelemeIslemleri\" method=\"get\"><button type=\"submit\" value=\""+str0[i][3]+"\" name=\"DISPLAY\">Görüntüle</button></form></li>");
                    out.print("</ul>");
                    out.print("</div>");
                }
            
        
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("               \n");
      out.write("    </div>\n");
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
