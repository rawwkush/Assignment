
public class Executive extends Employee{

	
	

	private float touralAllowances;
	private float phoneAllowances;
	
	public Executive() {
		super(1002,"Sam Kens",45000,14500);
		this.setTouralAllowances(super.basicSalary*0.08f);
		this.setPhoneAllowances(1500f);
	}
	
	public float getTouralAllowances() {
		return touralAllowances;
	}
	public void setTouralAllowances(float touralAllowances) {
		this.touralAllowances = touralAllowances;
	}
	public float getPhoneAllowances() {
		return phoneAllowances;
	}
	public void setPhoneAllowances(float phoneAllowances) {
		this.phoneAllowances = phoneAllowances;
	}
	
	public void getEmployeeDetails() {
		System.out.println("Emplaoyee Id : "+this.empId);
		System.out.println("Emplaoyee Name: "+this.empName);
		System.out.println("Basic Salary : "+this.basicSalary);
		System.out.println("HRA: "+this.hra);
		System.out.println("PF : "+this.pf);
		System.out.println("PT : "+this.pt);
		System.out.println("Toural Allowances: "+this.touralAllowances);
		System.out.println("Phone Allowances  : "+this.phoneAllowances);
		System.out.println("Gross Salary \t : "+this.calculateGrossSalary());
		System.out.println("Net Salary \t : "+this.calculateNetSalary());
	}
	
	public float calculateGrossSalary() {
		float grossSalary=0;
		grossSalary=super.calculateGrossSalary()+this.getTouralAllowances()+this.getPhoneAllowances();
		return grossSalary;
	}
	
	public float calculateNetSalary() {
		float netSalary=0;
		netSalary=super.calculateNetSalary()+this.calculateGrossSalary();
		return netSalary;
	}
	
	
}
