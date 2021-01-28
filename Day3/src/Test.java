
public class Test {
	public static void main(String[] args) {
		
		/*
		 * PRivate Constructor restricts Object Creation
		 */
		
	//	Employee emp = new Employee();
		
		Employee employee = Employee.returnEmployyeObject(); // object created from static method
		System.out.println(employee);
		
		//Calculator cal= new Calculator();
		
		AdvanceCalculator ac=new AdvanceCalculator();
		
		System.out.println("Add 5,7,8 : "+ac.sum(7,8));
		System.out.println("Fact 5 : "+ac.calculatyeFactorial(5));

	}
}
