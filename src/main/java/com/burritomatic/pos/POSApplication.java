package com.burritomatic.pos;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@ComponentScan(basePackages={"com.burritomatic.pos"})
@SpringBootApplication
public class POSApplication implements WebApplicationInitializer{

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(POSApplication.class);
		application.run(args);

	}
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}*/

	@Override
	public void onStartup(ServletContext arg0) throws ServletException {

		
	}

}
