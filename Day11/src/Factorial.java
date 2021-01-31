
public class Factorial {
	public int calFactorial(int a) {
		if(a<=1)
			return 1;
		else
			return a*calFactorial(a-1);
	}
}
