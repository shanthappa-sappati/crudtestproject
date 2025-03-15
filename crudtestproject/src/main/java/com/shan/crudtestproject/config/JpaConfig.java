package com.shan.crudtestproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.shan.crudtestproject.repository")
public class JpaConfig {

	
	
}
