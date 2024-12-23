package com.maybanktest.springboot_assignment;

import com.maybanktest.springboot_assignment.util.LoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringbootAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAssignmentApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer webMvcConfigurer(LoggingInterceptor loggingInterceptor) {
		return new WebMvcConfigurer() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(loggingInterceptor);
			}
		};
	}

}
