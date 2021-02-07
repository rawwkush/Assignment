package com.thinkitive;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	
	@Bean
	@Scope(scopeName = "prototype")
	public Employee getEmployee() {
		return new Employee(1, "abc",8777);
	}
	
	@Bean
	public List<Address> getAddress() {
		List a = new ArrayList<Address>();
		a.add(new Address(415605, "CPN")); 
		a.add(new Address(415203, "MND"));
		return a;
	}
}
