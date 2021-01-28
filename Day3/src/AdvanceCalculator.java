
public class AdvanceCalculator extends Calculator{

	public int calculatyeFactorial(int num) {
		int fact=1;
		if(fact!=0) {
			for(int i=num;i>=1;i--) {
				fact=fact*i;
			}
			return fact;
		}
		return -1;
	}

}
