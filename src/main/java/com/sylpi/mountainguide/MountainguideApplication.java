package com.sylpi.mountainguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MountainguideApplication {

	public static void main(String[] args) {
		SpringApplication.run(MountainguideApplication.class, args);
	}


	@Configuration
	public class WebConfig implements WebMvcConfigurer{
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/**")
					.addResourceLocations("classpath:/static/","classpath:/photos/article")
					.setCachePeriod(0);
		}
	}
}
