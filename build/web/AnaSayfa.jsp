<%-- 
    Document   : AnaSayfa
    Created on : 6 Haz 2021, 19:33:42
    Author     : Hamit Eren Açari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.jdbc.DatabaseOperations" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="style.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">


</head>

<body>

  <div class="header">
    <div class="logo">E-KÜTÜPHANE</div>

    <ul class="menu">
      <a href="AnaSayfa.jsp">Ana Sayfa</a>
      <%
            HttpSession sess=request.getSession();
            String LOGED_IN=(String)sess.getAttribute("LOGED_IN");

            if(LOGED_IN!=null&&LOGED_IN.equals("true")) {
                
                out.print("<a href=\"Kitaplarım.jsp\">Kitaplarım</a>");
            }
      %>
    </ul>

    <ul class="buttons">
        <%
            if(LOGED_IN!=null&&LOGED_IN.equals("true")) {
            
                out.print("<div class=\"row\"> <div class=\"col-md-5\"><button onClick=\"location.href='Hesabım.jsp'\" style=\"width: 100px; height: 35px;\">Hesabım</button> ");
                out.print("</div><div class=\"col-md-5\">");
                out.print("<form action=\"CikisIslemleri\" method=\"post\"><button type=\"submit\" style=\"width: 100px; height: 35px;\">ÇıkışYap</button></form></div></div>");
            }
            
            else {
                
                out.print("<button onClick=\"location.href='ÜyeOl.jsp'\" style=\"width: 100px; height: 35px;\">Üye Ol</button> ");
                out.print("<button onClick=\"location.href='GirişYap.jsp'\" style=\"width: 100px; height: 35px;\">Giriş Yap</button>");
            }
        %>
    </ul>

  </div>
  <br>




  <div class="float-none" style="width: 1500px">
    <div class="row">
      <div class="sidenav col-md-2">
          <form action="FiltrelemeIslemleri" method="post">
        <h5>Kategoriler</h5>
        <div class="row">
            
          <div class="col-md-1"></div>
          
          <div class="col-md-10">
            <ul style="list-style: none;">
              <li class="list-group-item"><input class="form-check-input" type="checkbox" value="Fantastik"
                  id="flexCheckDefault" name="CHECK_BOX_1">
                <label class="form-check-label" for="flexCheckDefault">
                  Fantastik
                </label>
              </li><br>
              <li class="list-group-item"><input class="form-check-input" type="checkbox" value="Gerilim"
                  id="flexCheckDefault" name="CHECK_BOX_2">
                <label class="form-check-label" for="flexCheckDefault">
                  Gerilim
                </label>
              </li><br>
              <li class="list-group-item"><input class="form-check-input" type="checkbox" value="Polisiye"
                  id="flexCheckDefault" name="CHECK_BOX_3">
                <label class="form-check-label" for="flexCheckDefault">
                  Polisiye
                </label>
              </li><br>
              <li class="list-group-item"><input class="form-check-input" type="checkbox" value="Romantik"
                  id="flexCheckDefault" name="CHECK_BOX_4">
                <label class="form-check-label" for="flexCheckDefault">
                  Romantik
                </label>
              </li>
            </ul>
          </div>
            
          
        </div>
        <h5>Yazar Adına Göre Ara</h5>
        <div class="row">
          <div class="search col-md-10">
            <input type="text" id="yazarAdi" name="SEARCH_BAR" /><button type="submit">Ara</button>
          </div>
        </div>
        <h5>Yayınevi</h5>
        <div class="row">
          <div class="col-md-1"></div>
          <div class="col-md-10">
            <ul style="list-style: none;">
              <li class="list-group-item"><input class="form-check-input" type="checkbox" value="Altın Kitaplar" name="CHECK_BOX_5">
                <label class="form-check-label" for="flexCheckDefault">
                  Altın Kitaplar
                </label>
              </li><br>
              <li class="list-group-item"><input class="form-check-input" type="checkbox" value="İthaki Yayınları" name="CHECK_BOX_6">
                <label class="form-check-label" for="flexCheckDefault">
                  İthaki
                </label>
              </li><br>
              <li class="list-group-item"><input class="form-check-input" type="checkbox" value="Pegasus" name="CHECK_BOX_7">
                <label class="form-check-label" for="flexCheckDefault">
                  Pegasus
                </label>
              </li>
              </li><br>
              <li class="list-group-item"><input class="form-check-input" type="checkbox" value="Martı Yayınları" name="CHECK_BOX_8">
                <label class="form-check-label" for="flexCheckDefault">
                  Martı
                </label>
              </li>
              </li><br>
              <li class="list-group-item"><input class="form-check-input" type="checkbox" value="Gollancz" name="CHECK_BOX_9">
                <label class="form-check-label" for="flexCheckDefault">
                  Gollancz
                </label>
              </li>
              </li><br>
              <li class="list-group-item"><input class="form-check-input" type="checkbox" value="Kyrhos Yayınları" name="CHECK_BOX_10">
                <label class="form-check-label" for="flexCheckDefault">
                  Kyrhos
                </label>
              </li>
            </ul>
          </div>
        </div>
        <button class="filtrele" type="submit">Filtrele</button>
        </form>
      </div>
      
            
      <div class="bookHistory col-md-9">

        <hr>
        <%
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
            
        %>
        </div>
      </div>
               
    </div>

</body>

</html>
