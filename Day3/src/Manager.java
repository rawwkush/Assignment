
public class Manager extends Employee {
	
	private float foodAllowances;
	private float managerAllowances;
	private float otherAllowances;
	
	public Manager() {
		super(1001,"Max Will",40000,12000);
		this.setFoodAllowances(super.basicSalary*0.08f);
		this.setManagerAllowances(super.basicSalary*0.1f);
		this.setOtherAllowances(super.basicSalary*0.03f);
		
	}

		
	
	public float getFoodAllowances() {
		return foodAllowances;
	}
	public void setFoodAllowances(float foodAllowances) {
		this.foodAllowances = foodAllowances;
	}
	public float getManagerAllowances() {
		return managerAllowances;
	}
	public void setManagerAllowances(float managerAllowances) {
		this.managerAllowances = managerAllowances;
	}
	public float getOtherAllowances() {
		return otherAllowances;
	}
	public void setOtherAllowances(float otherAllowances) {
		this.otherAllowances = otherAllowances;
	}

	public void getEmployeeDetails() {
		System.out.println("Emplaoyee Id : "+this.empId);
		System.out.println("Emplaoyee Name: "+this.empName);
		System.out.println("Basic Salary \t : "+this.basicSalary);
		System.out.println("HRA \t\t : "+this.hra);
		System.out.println("PF \t\t : "+this.pf);
		System.out.println("PT \t\t : "+this.pt);
		System.out.println("Manager Allowances \t : "+this.managerAllowances);
		System.out.println("Food Allowances \t : "+this.foodAllowances);
		System.out.println("Other Allowances \t : "+this.otherAllowances);
		System.out.println("Gross Salary \t : "+this.calculateGrossSalary());
		System.out.println("Net Salary \t : "+this.calculateNetSalary());
	}
	
	public float calculateGrossSalary() {
		float grossSalary=0;
		grossSalary=super.calculateGrossSalary()+this.getManagerAllowances()+this.getFoodAllowances()+this.getOtherAllowances();
		return grossSalary;
	}
	
	public float calculateNetSalary() {
		float netSalary=0;
		netSalary=super.calculateNetSalary()+this.calculateGrossSalary();
		return netSalary;
	}
	
}
