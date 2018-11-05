package com.waqar.waqarspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= "com.waqar.waqarspringboot.repositories")
@EntityScan(basePackages="com.waqar.waqarspringboot.entity")
public class WaqarSpringBootApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(WaqarSpringBootApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}
	
	
}
