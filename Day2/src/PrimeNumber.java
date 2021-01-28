
public class PrimeNumber {

	
	static void checkPrime(int num) {
		int flag=0;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				flag=1;
				break;
			}
		}
		if(flag==1) {
			System.out.println(num+" is not prime");
		}else {
			System.out.println(num+" is prime");
		}
	}
	
	public static void main(String[] args) {
		int a[] = { 3, 19, 8, 5, 31 };
		for (int j = 0; j < a.length; j++) {
			checkPrime(a[j]);			
		}
	
	}
	
}
