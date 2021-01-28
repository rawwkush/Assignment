package jdbc;

public class Test {
	
	/*
	 * static block not a function... It runs first
	 */
	static {
		System.out.println("static");
	}


	public static void main(String[] args) {
		System.out.println("main method");
	}
	
}
