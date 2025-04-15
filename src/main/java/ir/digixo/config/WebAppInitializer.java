package ir.digixo.config;

import ir.digixo.app1config.WebConfig1;
import ir.digixo.app2config.WebConfig2;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(jakarta.servlet.ServletContext servletContext) throws ServletException {
        registerContext(servletContext, WebConfig1.class, "dispatcher1", "/app1/*");
        registerContext(servletContext, WebConfig2.class, "dispatcher2", "/app2/*");
    }

    private void registerContext(ServletContext servletContext, Class<?> configClass, String servletName, String mapping) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(configClass);
        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet(servletName, new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping(mapping);
    }

}
