package com.thinkitive;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("anyname.xml");
		
		Employee e =  con.getBean("emp",Employee.class);
	    
	    System.out.println(e);
	}
}
