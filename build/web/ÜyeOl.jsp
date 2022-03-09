<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Üye Ol</title>
    <link rel="stylesheet" type="text/css" href="giris_uye.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <form class="uyeOl" action="GirisIslemleri" method="post">
            <h1>Üye Ol</h1>
            <div>
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Kullanıcı Adı" name="USER_NICK">
            </div>
            <div>
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Ad" name="USER_NAME">
            </div>
            <div>
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Soyadı" name="USER_LNAME">
            </div>
            <div>
                <i class="fas fa-envelope"></i>
                <input type="email" placeholder="Email" name="USER_MAIL">
            </div>
            <div>
                <i class="fas fa-key"></i>
                <input type="password" placeholder="Parola" name="USER_PASS">
            </div>
            <div>
                <i class="fas fa-key"></i>
                <input type="password" placeholder="Parola Tekrar" name="VERIFY">

            </div>
            <div>
                <i class="fas fa-phone"></i>
                <input type="text" placeholder="Telefon Numarası" name="USER_PHONE">
            </div>
            <div>
                <button type="submit">Üye Ol</button>
            </div>
            <br><hr>
            <p> Eğer bir hesabın varsa,
                <button onClick="location.href='GirişYap.jsp'"
                style="width: 100px; height: 35px;" type="button">Giriş Yap</button></p>
        </form>
    </div>
</body>

</html>
