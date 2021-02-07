package com.thinkitive;

public class Employee {
	private int empid;
	private String ename;
	private int salary;
	
	public Employee() {
	
	}

	public Employee(int empid, String ename, int salary) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empid != other.empid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[empid=" + empid + ", ename=" + ename + ", salary=" + salary + "]";
	}
	
}
