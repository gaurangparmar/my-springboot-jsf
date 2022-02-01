package com.gaurang.my;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MyServletConfigs implements ServletContextAware, WebMvcConfigurer, ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // spring boot only works if this is set
        // Iniciar el contexto de JSF
        // http://stackoverflow.com/a/25509937/1199132
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        if (servletContext != null) {
            System.out.println("init params: " + servletContext.getInitParameterNames());
        }
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/my").setViewName("forward:/my/index.jsf");
    }

}
