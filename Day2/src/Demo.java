
public class Demo {

	public static void main(String[] args) {
		/*
		 * if with switch
		 */
		
		float percentage = 60;
		if (percentage >= 70) {
			System.out.println("A Grade");
		} else if (percentage >= 60) {
			System.out.println("B Grade");
		} else if (percentage >= 40) {
			System.out.println("C Greade");
		} else {
			System.out.println("Fail");
		}

		int check=(int)percentage/10;
		switch(check) {
		case 8:
		case 9:
		case 7:
			System.out.println("A Grade");
			break;
		case 6:
		case 5:
			System.out.println("B GRade");
			break;
		
		case 4:
			System.out.println("C grade");
			
		default:
				System.out.println("Fail");
		}
		
		
	}
	
	
}
