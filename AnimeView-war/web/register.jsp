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
        <title>Teste Register</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section id="loginsection">
            <form action="Controller" method="POST">
                <h1>Register</h1>
                <input type="hidden" name="command" value="UserAnime.register"/>
                <p>
                    <input type="text" name="username" placeholder="username" required/>
                </p>
                <p>
                    <input type="password" name="password" placeholder="password" required/>
                </p>
                <p>
                    <input type="password" name="password2" placeholder="confirm password" required/>
                </p>
                <p>
                    <input type="text" name="firstname" placeholder="first name" required/>
                </p>
                <p>
                    <input type="email" name="email" placeholder="email" required/>
                </p>
                <p>
                    <input type="date" name="birthday" required/>
                </p>
                <p>
                    <input type="submit" value="REGISTER"/>
                </p>
            </form>
        </section>
            
    </body>
</html>
