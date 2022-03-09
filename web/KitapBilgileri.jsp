<%-- 
    Document   : KitapBilgileri
    Created on : 5 Haz 2021, 14:43:29
    Author     : Hamit Eren Açari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.jdbc.DatabaseOperations" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kitap Detayı</title>
    <link rel="stylesheet" href="detailStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
	<%
		HttpSession sess=request.getSession();
                String LOGED_IN=(String)sess.getAttribute("LOGED_IN");
	%>
    <div class="header">
        <div class="logo">E-KÜTÜPHANE</div>

        <ul class="menu">
            <a href="AnaSayfa.jsp">Ana Sayfa</a>
            <%
                if(LOGED_IN!=null&&LOGED_IN.equals("true"))
                    out.print("<a href\"Kitaplarım.jsp\">Kitaplarım</a>");
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
    <%
    		String str[]=DatabaseOperations.getBookInfo((int)sess.getAttribute("BOOK_ID"));
    %>
    <div class="book">
    	<%
    		out.print("<img src=\"Assets/BookCovers/"+str[0]+"\">");
    	%>
    </div>

    <div class="bookDetails">
        <ul>
            <hr>
            <li><h4>Kitap ismi :</h4> <h5><%= str[1] %></h5></li>
            <hr>
            <li><h4>Yazar Adı :</h4> <h5><%= str[2] %></h5></li>
            <hr>
            <li><h4>Yayınevi :</h4> <h5><%= str[3] %></h5></li>
            <hr>
            <li><h4>Kategori :</h4> <h5><%= str[4] %></h5></li>
            <hr>
            <li><h4>Sayfa sayısı :</h4> <h5><%= str[5] %></h5></li>
            <hr>

        </ul>
        <form action="KiralamaIslemleri" method="post"><button style="width: 100px; height: 35px;" type="submit">Kirala</button></form>
    </div>

    <div class="autor">
        <h5> Kitap Hakkında</h5> 
        <hr> 
        <p>
        	<%= str[6] %>
        </p> 
    </div>

        <!--<div class="autor">
        <h5> Bu Yazarın benzer kitapları</h5> 
        <hr>  
    </div>

    <div class="extraBook">
        <img src="sefiller.jpg" onClick="location.href='#'">
        <img src="sefiller.jpg" onClick="location.href='#'">
        <img src="sefiller.jpg" onClick="location.href='#'">
        <img src="sefiller.jpg" onClick="location.href='#'">
    </div>-->

    

</body>

</html>
