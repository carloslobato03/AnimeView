<%-- 
    Document   : home
    Created on : 26/08/2016, 09:55:01
    Author     : 1147106
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Preview Home</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section id="container">
            <aside>
                <div id="logo">
                </div>
                <nav>
                    <ul>
                        <li class="selected"><a href="Controller?command=Page.home"><i class="material-icons">home</i>Home</a></li>
                        <li class=""><a href="Controller?command=Page.profile"><i class="material-icons">account_circle</i>Profile</a></li>
                        <li class=""><a href="Controller?command=Page.menu1"><i class="material-icons">code</i>Menu 1</a></li>
                        <li class=""><a href="Controller?command=Page.menu2"><i class="material-icons">date_range</i>Menu 2</a></li>
                        <li class=""><a href="Controller?command=Page.about"><i class="material-icons">fingerprint</i>About</a></li>
                    </ul>
                </nav>
            </aside>
            <section id="mainsection">
                <nav>
                    <section id="search">
                        <form>
                            <input type="text" name="search" placeholder="Search" id="searchField"/>
                        </form>
                        <label for="searchField"><i class="material-icons">search</i></label>
                    </section>
                    <section id="profile">
                        <img alt="avatar" src="img/avatar_color.png"/>
                        <span>${user.username}</span>
                        <a href="Controller?command=UserAnime.logout"><input type="button" id="logout" value="Log Out"/></a>
                    </section>
                </nav>

                <c:choose>
                    <c:when test="${page.equals('home')}">

                        <section id="home">
                            <h1>Home</h1>
                            <p>Feugiat magna imperdiet phasellus id metus mattis magnis nisl sem at a eu hendrerit eleifend netus imperdiet. Facilisi suspendisse faucibus eu a sagittis mollis hendrerit orci a vehicula nostra vestibulum laoreet est adipiscing placerat non sodales in torquent. Proin a dis urna a pretium suspendisse curae ornare a orci ante tempor nisi tempor erat. Libero condimentum ridiculus mollis vestibulum eros ante iaculis lacinia duis malesuada ridiculus a sapien tortor per litora cum non. Accumsan mus scelerisque potenti faucibus varius lacinia adipiscing scelerisque tempus lacus metus a taciti sit at hac a libero ultricies habitant risus mattis vestibulum condimentum non eget malesuada. Nibh parturient vitae posuere a elit id mus scelerisque ultricies eros at ultrices mollis ad volutpat quam a facilisi tempor scelerisque.</p>
                            <p>Hac venenatis condimentum etiam dignissim consequat ullamcorper mi condimentum parturient hendrerit adipiscing fermentum vestibulum nunc sagittis adipiscing ut quisque adipiscing condimentum parturient augue convallis parturient at in scelerisque blandit. Ullamcorper adipiscing ac netus purus imperdiet torquent a parturient est a imperdiet dictumst ad nullam ultrices parturient nisl consectetur ullamcorper nostra massa rutrum class. Platea ut sem fermentum parturient lacinia elementum elementum penatibus auctor nascetur a imperdiet aliquam adipiscing praesent sem lacus convallis. Eleifend egestas ad ultrices consectetur vestibulum litora volutpat adipiscing eu proin leo cum metus cras luctus dictum bibendum ad a. Vestibulum ut quis scelerisque ad dictum parturient himenaeos eleifend consequat nisl bibendum class curabitur nulla pharetra mauris a velit mi a. Pharetra molestie vulputate ligula viverra lorem curabitur augue morbi consectetur condimentum vestibulum a ad porta facilisis conubia mauris quis adipiscing natoque fermentum condimentum. </p>
                            <p>Ullamcorper inceptos mi mi habitant facilisi id condimentum a in fermentum arcu facilisi fames a nam vitae a ultricies sed. Natoque adipiscing adipiscing conubia eget vestibulum ullamcorper nulla ullamcorper enim nostra per ligula vestibulum inceptos a vestibulum vestibulum. Pharetra ullamcorper fusce non eget a a viverra vestibulum facilisis purus aenean a consectetur ullamcorper mus a facilisis adipiscing vel nec phasellus penatibus fames libero nulla luctus.</p>
                        </section>
                    </c:when>
                    <c:when test="${page.equals('profile')}">
                        <section id="profile">
                            <h1>Profile</h1>

                        </section>

                    </c:when>
                    <c:when test="${page.equals('menu1')}">
                        <section id="menu1">
                            <h1>Menu 1</h1>
                        </section>

                    </c:when>
                    <c:when test="${page.equals('menu2')}">
                        <section id="menu2">
                            <h1>Menu 2</h1>
                        </section>

                    </c:when>
                    <c:when test="${page.equals('about')}">
                        <section id="about">
                            <h1>About</h1>
                            <p>This project was made at the course of Language Programming at Mackenzie Presbyterian University.</p>
                            <p><small>&copy; 2016 Cacique</small></p>
                        </section>

                    </c:when>
                </c:choose>




            </section>
        </section>   
    </body>
</html>
