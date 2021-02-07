package com.jdbc;

import java.sql.SQLException;

public class Demo {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "ankush", "cpn");
		Employee e2 = new Employee(2, "rawkush", "cpn");
		Employee e3 = new Employee(3, "kush", "pqr");
		
		CreateRemoveUpdateDelete c;
		try {
			c = new CreateRemoveUpdateDelete();
			//c.Create();
			//c.Update("ankush", "kushank");
			c.Delete("kushank");
			c.read();
			c.Close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
