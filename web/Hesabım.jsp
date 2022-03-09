<%-- 
    Document   : Hesabım
    Created on : 5 Haz 2021, 14:43:40
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
    <title>Document</title>
    <link rel="stylesheet" href="detailStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
    <div class="header">
        <div class="logo">E-KÜTÜPHANE</div>

        <ul class="menu">
            <a href="AnaSayfa.jsp">Ana Sayfa</a>
            <a href="Kitaplarım.jsp">Kiralanan Kitaplar</a>
        </ul>
    </div>



    <div class="profil">
        <img src="Assets/DefaultProfilePic.jpg">
    </div>
   
    <div class="userDetails">
        <ul>
        <%
            HttpSession sess=request.getSession();
            
        	String str[]=DatabaseOperations.getUserInfo((int)sess.getAttribute("USER_ID"));
        %>
            <hr>
            <li><h4>Kullanıcı Adı :</h4> <h5><%= str[0] %></h5></li>
            <hr>
            <li><h4>Ad :</h4> <h5><%= str[1] %></h5></li>
            <hr>
            <li><h4>Soyad :</h4> <h5><%= str[2] %></h5></li>
            <hr>
            <li><h4>Email :</h4> <h5><%= str[3] %></h5></li>
            <hr>
            <li><h4>Telefon Numarası :</h4> <h5><%= str[4] %></h5></li>
            <hr>
        </ul>
        <form action="HesabimiDuzenle"><button  type="submit" style="width: 100px; height: 35px;">Düzenle</button></form>
    </div>
</body>

</html>
