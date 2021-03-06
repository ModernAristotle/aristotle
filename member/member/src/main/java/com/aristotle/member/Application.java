package com.aristotle.member;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.aristotle.core.config.CoreConfig;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class}, scanBasePackages = { "com.aristotle" })
@ComponentScan(basePackages = { "com.aristotle.member"})
@Import(CoreConfig.class)
public class Application extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(new Object[] { Application.class}, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			// System.out.println(beanName + " , " + ctx.getBean(beanName));
			System.out.println(beanName);
		}
	}

	// BeanFieldGroup.bindFieldsUnbuffered(domain, this);
	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder 
			application) { 
		//This function generate relevant information for Tomcat or other containers 
		return application.sources(Application.class); 
	}

	public static void mainw(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
