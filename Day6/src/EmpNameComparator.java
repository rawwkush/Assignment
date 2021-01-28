import java.util.Comparator;

public class EmpNameComparator implements Comparator<Employee> {
	
	/*
	 *  Why better than Comparable?
	 *  Because we can Compare same object with based on any attribute we want..in comparable we have to fix which attribute to use
	 *  but here we can implement this for all and later decide which to use
	 */
	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getEname().compareTo(e2.getEname());
	}

}
