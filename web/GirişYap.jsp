<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"> <meta http-equiv="X-UA-Compatible" content="IE=edge"> <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Giriş Yap</title>
    
    <link rel="stylesheet" type="text/css" href="giris_uye.css"> <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" crossorigin="anonymous">
</head>

<body>
    <div class="container">
    	
        <form class="giris" action="GirisIslemleri" method="get">
            <h1>Giriş Yap</h1>
            
            <div>
                <i class="fas fa-envelope"></i>
                <input type="email" placeholder="Email" name="USER_MAIL" 
                <%
                  if(request.getParameter("USER_MAIL")!=null) {
                	  
                	  out.print("value="+request.getParameter("USER_MAIL"));
                  }
                %>>
            </div>
            
            <div>
                <i class="fas fa-key"></i>
                <input type="password" placeholder="Parola" name="USER_PASS">
            </div>
            
            <div>
                <button type="submit">Giriş Yap</button>
            </div>
            
            <br><hr>
                <p><a href="ŞifremiUnuttum.jsp">Şifreni mi unuttun?</a></p>
            <br><hr>
            
            <p> Eğer bir hesabın yoksa,
                <button onClick="location.href='ÜyeOl.jsp'"
                style="width: 100px; height: 35px;" type="button">Üye Ol</button>
            </p>
        </form>
    </div>
</body>

</html>
