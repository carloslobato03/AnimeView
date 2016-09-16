/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller.command;

import com.br.lp3.model.dao.UserAnimeDAO;
import com.br.lp3.model.entities.Useranime;
import com.br.lp3.model.entities.Userinfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31517072
 */
public class UserAnimeCommand implements Command {

    UserAnimeDAO userAnimeDAO = lookupUserAnimeDAOBean();

    HttpServletRequest request;
    HttpServletResponse response;
    private String responsePage;
    private String username;
    private String password;

    @Override
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public void execute() {
        String action = request.getParameter("command").split("\\.")[1];
        switch (action) {
            case "register":
                username = request.getParameter("username");
                password = request.getParameter("password");
                String password2 = request.getParameter("password2");
                String firstname = request.getParameter("firstname");
                String email = request.getParameter("email");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = new Date();

                try {
                    birthday = sdf.parse(request.getParameter("birthday"));
                } catch (ParseException ex) {
                    Logger.getLogger(Useranime.class.getName()).log(Level.SEVERE, null, ex);
                }

                Useranime temp1 = userAnimeDAO.readByUsername(username);
                Useranime temp2 = userAnimeDAO.readByEmail(email);

                if (temp1 != null) {
                    responsePage = "error.jsp";
                    request.getSession().setAttribute("error", "O usuario ja foi cadastrado!");
                    break;
                } else if (temp2 != null) {
                    responsePage = "error.jsp";
                    request.getSession().setAttribute("error", "Esse EMAIL ja foi cadastrado!");
                    break;
                } else if (!password.equals(password2)) {
                    responsePage = "error.jsp";
                    request.getSession().setAttribute("error", "As senhas digitadas não batem");
                    break;
                } else {
                    Useranime user = new Useranime();
                    user.setUsername(username);
                    user.setPassword(password);

                    Userinfo ui = new Userinfo();
                    ui.setDnascimento(birthday);
                    ui.setEmail(email);
                    ui.setNome(firstname);
                    
                    ui.setUseranime(user);
                    user.setUserinfo(ui);
                    
                    
                    userAnimeDAO.create(user);
                    responsePage = "index.jsp";
                }

                break;
            case "login":
                username = request.getParameter("username");
                password = request.getParameter("password");
                Useranime temp3 = userAnimeDAO.readByUsername(username);
                if (temp3 == null) {
                    responsePage = "error.jsp";
                    request.getSession().setAttribute("error", "Usuario não encontrado!");
                } else if (!password.equals(temp3.getPassword())) {
                    responsePage = "error.jsp";
                    request.getSession().setAttribute("error", "Usuario não encontrado");
                } else {
                    request.getSession().setAttribute("user", temp3);
                    request.getSession().setAttribute("page", "home");
                    responsePage = "home.jsp";
                }
                break;
            case "logout":
                request.getSession().invalidate();
                responsePage = "index.jsp";
                break;
        }
    }

    @Override
    public String getResponsePage() {
        return this.responsePage;
    }

    private UserAnimeDAO lookupUserAnimeDAOBean() {
        try {
            Context c = new InitialContext();
            return (UserAnimeDAO) c.lookup("java:global/AnimeView/AnimeView-ejb/UserAnimeDAO!com.br.lp3.model.dao.UserAnimeDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
