<%-- 
    Document   : KodDoğrulama
    Created on : 5 Haz 2021, 14:42:31
    Author     : Hamit Eren Açari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"> <meta http-equiv="X-UA-Compatible" content="IE=edge"> <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Sifremi Degistir</title>
    
    <link rel="stylesheet" type="text/css" href="giris_uye.css"> <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <form class="giris" action="MailIslemleri" method="get">
            <p>Email adresine, hesabına yeniden girebilmeni sağlayacak kodu içeren bir e-posta gönderdik. Lütfen kodu giriniz.</p>
            
            <i class="fas fa-check-circle"></i>
            
            <input type="text" placeholder="Onay Kodu" name="VERIFY_IN">
            
            <button type="submit" value="Kodu yolla">Kodu Yolla</button>
                
            <button onClick="location.href='GirişYap.jsp'" style="width: 100px; height: 35px;" type="button">Giriş Yap</button>
            <button onClick="location.href='ÜyeOl.jsp'" style="width: 100px; height: 35px;" type="button">Üye Ol</button>
        </form>
    </div>
</body>

</html>