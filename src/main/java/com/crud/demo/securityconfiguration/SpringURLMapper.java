/*package com.crud.demo.securityconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class SpringURLMapper extends WebMvcConfigurerAdapter{
	@Override
	public void addViewControllers(ViewControllerRegistry viewControllerRegistory)
	{
		System.out.println("WebMvcConfigurerAdapter::::::::"+2);
		viewControllerRegistory.addViewController("/").setViewName("login");
		viewControllerRegistory.addViewController("/login").setViewName("login");
	}

	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		
	}
	
	
}
*/