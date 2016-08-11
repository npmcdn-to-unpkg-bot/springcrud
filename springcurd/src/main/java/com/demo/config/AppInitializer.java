/**
 * 
 */
package com.demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author kalaiselvan.a
 *
 */
public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(servletContext);
		DispatcherServlet dispatcherservlet = new DispatcherServlet(ctx);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherservlet);
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
