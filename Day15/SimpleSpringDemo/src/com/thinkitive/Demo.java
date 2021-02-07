package com.thinkitive;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("anyname.xml");
		
		Employee e =  con.getBean(Employee.class);
	    e.hello();
	    System.out.println(e);
	}
}
