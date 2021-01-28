
public class Employee implements Comparable<Employee> {
	private int empid;
	private String ename;
	private int salary;
	private Address address;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empid, String ename, int salary) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
	}
	

	public Employee(int empid, String ename, int salary, Address address) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.salary = salary;
		this.address = address;
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

public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}



	@Override
public String toString() {
	return "[empid=" + empid + ", ename=" + ename + ", salary=" + salary + ", address=" + address + "]";
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
	public int compareTo(Employee e) {

		if (this.empid > e.empid) {
			return 1;
		} else if (this.empid < e.empid)
			return -1;
		else
			return 0;
	}

}
