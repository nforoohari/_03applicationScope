package ir.digixo.app2config;


import ir.digixo.ApplicationScopeClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//vs xml
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "ir.digixo.app2config" })
public class WebConfig2 implements WebMvcConfigurer {


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");


        return bean;
    }
    @Bean
  @Scope(value = WebApplicationContext.SCOPE_APPLICATION)
  //  @Scope("singleton")
    public ApplicationScopeClass pref() {
        return new ApplicationScopeClass();
    }
}
