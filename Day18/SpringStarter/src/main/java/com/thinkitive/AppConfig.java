package com.thinkitive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Employee getEmployee() {
		return new Employee();
	}
}
