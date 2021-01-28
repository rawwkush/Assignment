public class Employee {
	int empId;
	String empName;
	float basicSalary;
	float hra;
	float pf;
	float pt;
	float medicalAllowances;
	float netSalary;
	
	public Employee() {
		System.out.println("Constructor Instantiated...");
	}
	
	Employee(int empId,String empName,int basicSalary,float medicalAllowances){
		
		this();
		
		this.empId=empId;
		this.empName=empName;
		this.basicSalary=basicSalary;
		this.hra=this.basicSalary*0.5f;
		this.pf=this.basicSalary*0.12f;
		this.pt=200;
		
	}
	
	public void getEmployeeDetails() {
		System.out.println("Emplaoyee Id : "+this.empId);
		System.out.println("Emplaoyee Name: "+this.empName);
		System.out.println("Basic Salary \t : "+this.basicSalary);
		System.out.println("HRA  : "+this.hra);
		System.out.println("PF  : "+this.pf);
		System.out.println("PT  : "+this.pt);
		System.out.println("Gross Salary  : "+this.calculateGrossSalary());
		System.out.println("Net Salary  : "+this.calculateNetSalary());
	}
	
	public float calculateGrossSalary() {
		float grossSalary=0;
		grossSalary=this.basicSalary+this.hra+this.medicalAllowances;
		return grossSalary;
	}
	
	public float calculateNetSalary() {
		float netSalary=0;
		netSalary=this.calculateGrossSalary()-this.pf+this.pt;
		return netSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", basicSalary=" + basicSalary + ", hra=" + hra
				+ ", pf=" + pf + ", pt=" + pt + ", medicalAllowances=" + medicalAllowances + ", netSalary=" + netSalary
				+ "]";
	}
	
	
	
}