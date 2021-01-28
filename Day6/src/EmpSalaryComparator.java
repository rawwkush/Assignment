
import java.util.Comparator;

public class EmpSalaryComparator implements Comparator<Employee> {

	/*
	 *  Why better than Comparable?
	 *  Because we can Compare same object with based on any attribute we want..in comparable we have to fix which attribute to use
	 *  but here we can implement this for all and later decide which to use
	 */
	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.getSalary() > e2.getSalary()) {
			return 1;
		} else if (e1.getSalary() < e2.getSalary())
			return -1;
		else
			return 0;
	}

}
