package com.thinkitive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	@Scope(scopeName = "prototype")
	public Employee getEmployee() {
		return new Employee(1, "abc",10000, 1000);
	}

}
