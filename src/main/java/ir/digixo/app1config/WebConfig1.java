package ir.digixo.app1config;

import ir.digixo.ApplicationScopeClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"ir.digixo.app1config"})
public class WebConfig1 implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        bean.setViewClass(JstlView.class);
        return bean;
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION)
//    @Scope(value = "singleton")
    public ApplicationScopeClass pref() {
        return new ApplicationScopeClass();
    }
}