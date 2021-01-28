
public class Calculator {


	public int add(int b, int... a) {
		 int sum=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		return sum+b;
	}
	
	public static void main(String[] args) {
		Calculator cal=new Calculator();
		int sum=cal.add(3,4,5,5);
		System.out.println(sum);
		
	}
	
}
