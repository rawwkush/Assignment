
public class EqualArray {

	
	static boolean check(int a[], int b[]) {
		if(a.length!=b.length)
			return false;
		
		boolean flag=false;
		
		for(int i:a) {
			for(int j:b) {
				if(i==j) {
					flag=true;
				}
			}
			if(flag) {
				flag=false;
			}else {
				return false;
			}
		}
		
		return true;
	}

	
	public static void main(String[] args) {

		int b[]= { 97, 59, 88, 45, 90, 89 };
		int c[]= { 97, 59, 88, 45, 89, 90 };
		if(check(c,b))
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		
	}
	
	
}
