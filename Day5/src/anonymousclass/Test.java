package anonymousclass;

public class Test {
	public static void main(String[] args) {
		MyInterface add= new MyInterface() {
			
			@Override
			public int performAction(int a, int b) {
				return a+b;
			}
		};
		
		
		//OR 
		
		MyInterface sub = (a,b)-> a-b;   // same as above but more compact
		
		
		
	}
}
