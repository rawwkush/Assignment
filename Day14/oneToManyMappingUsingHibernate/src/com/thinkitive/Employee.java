package com.thinkitive;

import java.util.Arrays;

public class Employee {
	private int empid;
	private String ename;
	private int salary;
	private Address[] addresses;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empid, String ename, int salary, Address[] addresses) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
		this.addresses = addresses;
	}
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", salary=" + salary + ", addresses="
				+ Arrays.toString(addresses) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(addresses);
		result = prime * result + empid;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + salary;
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
		if (!Arrays.equals(addresses, other.addresses))
			return false;
		if (empid != other.empid)
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address[] getAddresses() {
		return addresses;
	}

	public void setAddresses(Address[] addresses) {
		this.addresses = addresses;
	}
	
}
