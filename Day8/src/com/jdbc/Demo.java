package com.jdbc;

public class Demo {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "ankush", "cpn");
		Employee e2 = new Employee(2, "rawkush", "cpn");
		Employee e3 = new Employee(3, "kush", "pqr");
		
		CreateRemoveUpdateDelete c = new CreateRemoveUpdateDelete();
		//c.Create();
		//c.Update("ankush", "kushank");
		c.Delete("kushank");
		c.Read();
		c.Close();
	}
}
