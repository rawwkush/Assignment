package com.thinkitive;

public class EmployeeFactory {

	public EmployeeFactory() {
		System.out.println("Other class constructor");
	}
	
	public Employee getInstance() {
		return new Employee();
	}
}
