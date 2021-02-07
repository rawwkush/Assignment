package com.thinkitive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.thinkitive");
		
		Employee emp = ctx.getBean(Employee.class);
		System.out.println(emp);
	}
}
