package com.thinkitive;

public class Employee {
	private int empid;
	private String ename;
	private int basicSalary;
	private float pf,pt,hra,medical;
	
	public Employee() {
	}

	public Employee(int empid, String ename, int basicSalary,float medical) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.medical = medical;
		this.basicSalary = basicSalary;
	
		this.pf = 0.12f * this.basicSalary;
		this.pt = 200;
		this.hra = 0.5f * this.basicSalary;
	}
	
	public float getGrossSalary() {
		float gs = this.basicSalary + this.hra + this.medical;
		return gs;
	}
	
	public float getNetSalary() {
		float ns = getGrossSalary() - this.pf - this.pt;
		return ns;
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

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public float getPf() {
		return pf;
	}

	public void setPf(float pf) {
		this.pf = pf;
	}

	public float getPt() {
		return pt;
	}

	public void setPt(float pt) {
		this.pt = pt;
	}

	public float getHra() {
		return hra;
	}

	public void setHra(float hra) {
		this.hra = hra;
	}

	public float getMedical() {
		return medical;
	}

	public void setMedical(float medical) {
		this.medical = medical;
	}
	
	@Override
	public String toString() {
		return "grossSalary: " + this.getGrossSalary() + "\n" +
				"netSalary:   " + this.getNetSalary();
	}
	
	
	
}
