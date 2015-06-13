package com.addressapp;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Social implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("visitor", 0);
        context.setAttribute("online", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       
    }

    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        int visitor = (int)hse.getSession().getServletContext().getAttribute("visitor");
        int online = (int)hse.getSession().getServletContext().getAttribute("online");
        visitor++;
        online++;
        hse.getSession().getServletContext().setAttribute("online",online);
        hse.getSession().getServletContext().setAttribute("visitor",visitor);
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        int online = (int)hse.getSession().getServletContext().getAttribute("online");
        online--;
        hse.getSession().getServletContext().setAttribute("online",online);
    }

    
}