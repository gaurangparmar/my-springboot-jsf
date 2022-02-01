package com.gaurang.my;

import java.util.ArrayList;
import java.util.List;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.sun.faces.config.ConfigureListener;

@Configuration
public class MyConfiguration {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        ServletRegistrationBean<MessageDispatcherServlet> servletRegistrationBean = new ServletRegistrationBean<>(servlet, "/Services/*");
        servletRegistrationBean.setName("MessageDispatcherServlet");
        return servletRegistrationBean;
    }

    @Bean(name = "my")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("MyDetailsPort");
        wsdl11Definition.setLocationUri("/Services");
        wsdl11Definition.setTargetNamespace("http://www.gaurang.com/my/soap");
        wsdl11Definition.setSchema(countriesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema mySchema() {
        return new SimpleXsdSchema(new ClassPathResource("META-INF/wsdl/my.xsd"));
    }

    @Bean // this is causing JSF deployment issue
    public WsConfigurerAdapter myWsConfigurerAdapter() {
        return new WsConfigurerAdapter() {

            @Override
            public void addInterceptors(List<EndpointInterceptor> interceptors) {
                if (interceptors == null) {
                    interceptors = new ArrayList<>();
                }
                PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
                validatingInterceptor.setValidateRequest(true);
                validatingInterceptor.setValidateResponse(false);
                validatingInterceptor.setXsdSchema(mySchema());
                try {
                    validatingInterceptor.afterPropertiesSet();
                } catch (Exception e) {}
                interceptors.add(validatingInterceptor);
            }
        };
    }

    @Bean
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
        ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(
                new FacesServlet(), "*.jsf", "*.xhtml");
        servletRegistrationBean.setName("FacesServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
    }

}
