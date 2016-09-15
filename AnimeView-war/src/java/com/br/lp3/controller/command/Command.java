package com.br.lp3.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31517072
 */
public interface Command {
    public void init(HttpServletRequest request, 
            HttpServletResponse response);
    public void execute();
    public String getResponsePage();
}
