package serialization;

public class Test {

	public static void main(String[] args) {
		Employee e= new Employee(1,"abc",1);
		Employee temp= new Employee();
		
		e.doSerialize();
		System.out.println(e);
		
		temp=temp.doDeserialize();
		System.out.println(temp);
	}
}
