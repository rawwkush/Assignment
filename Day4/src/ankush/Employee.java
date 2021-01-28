package ankush;

public class Employee {
	
	private int eId;
	private String eName;
	private String eAdd;
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteAdd() {
		return eAdd;
	}
	public void seteAdd(String eAdd) {
		this.eAdd = eAdd;
	}
	
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eAdd=" + eAdd + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee tmp = (Employee) obj;
		
		if (this.eId== tmp.eId)
			return true;
		
		return false;
	}
	
	
}