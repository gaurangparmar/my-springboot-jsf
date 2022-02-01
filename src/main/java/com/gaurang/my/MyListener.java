package com.gaurang.my;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println("Context initialized with servlets " + servletContext.getServletRegistrations());
        System.out.println("Context initialized with parameters " + servletContext.getInitParameterNames());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context destroyed " + sce.getServletContext().getContextPath());
    }

}
