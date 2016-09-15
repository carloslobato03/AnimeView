<%-- 
    Document   : index
    Created on : 26/08/2016, 09:28:32
    Author     : 1147106
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste Login</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section id="loginsection">
            <form action="Controller" method="POST">
                <input type="hidden" name="command" value="UserAnime.login"/>
                <p>
                    <input type="text" name="username" placeholder="username"/>
                </p>
                <p>
                    <input type="password" name="password" placeholder="password"/>
                </p>
                <p>
                    <input type="checkbox" name="remember" id="remember"/>
                    <label for="remember">Remember passsword</label>
                </p>
                <p>
                    <a href="#">Forgot password?</a>
                    <a href="register.jsp">Register</a>
                </p>
                <p>
                    <input type="submit" value="LOGIN"/>
                </p>
            </form>
        </section>
            
    </body>
</html>
