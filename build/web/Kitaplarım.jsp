<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.jdbc.DatabaseOperations"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Kütüphane</title>
    <link rel="stylesheet" href="detailStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
</head>

<body>

    <div class="header">
        <div class="logo">E-KÜTÜPHANE</div>

        <ul class="menu">
            <a href="AnaSayfa.jsp">Ana Sayfa</a>
        </ul>

        <ul class="buttons">
            <div class="row"> <div class="col-md-5"><button onClick="location.href='Hesabım.jsp'" style="width: 100px; height: 35px;">Hesabım</button>
                </div><div class="col-md-5">
                <form action="CikisIslemleri" method="post"><button type="submit" style="width: 100px; height: 35px;">ÇıkışYap</button></form></div></div>
        </ul>
    </div>
    <%
        HttpSession sess=request.getSession();
    %>
    <div class="sidebar">
        <form action="CezaIslemleri" method="post">
        
            <div class="ceza"><% out.print(DatabaseOperations.getUserPENALTY((int)sess.getAttribute("USER_ID"))); %>₺</div><br>
        <h4>Ceza Miktarı</h4>
        <hr>
        <button type="submit" style="margin-top: 0px;">Cezayı Öde</button>
        </form>
            
    </div>
    
    <div class="vr"></div>
    
    <div class="bookHistory">
        <h5>Kitaplarım</h5>
        <hr>
        <%
            String str[][]=DatabaseOperations.getBooksInUsageInfo((int)sess.getAttribute("USER_ID"));
            
            if(str!=null) {
            
                for(int i=0;i<str.length;i++) {

                    out.print("<div class=\"books\">");
                    out.print("<img src=\"Assets/BookCovers/"+str[i][0]+"\">");
                    out.print("<ul>");
                    out.print("<li><h6>Kitap: </h6> <h5>"+str[i][1]+"</h5></li>");
                    out.print("<li><h6>Yazar: </h6> <h5>"+str[i][2]+"</h5></li>");
                    out.print("<li><button onClick=\"location.href='Assets/PDF/"+str[i][4]+"'\">Oku</button></li>");
                    out.print("<li><form action=\"KullanimdakiKitaplarIslemleri\" method=\"post\"><button type=\"submit\" value=\""+str[i][3]+"\" name=\"ISUBMIT\">Teslim Et</button></form></li>");
                    out.print("</ul>");
                    out.print("</div>");
                }
            }
        %>
    </div>
</body>

</html>
