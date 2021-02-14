# 7 steps for connecting in jdbc

1. import package
2. Load and Register the Drivers
3. Establish the connection
4. Create the statement
5. Execute the Query
6. Process result
7. close the connection

**Code**

```
/*
 *
 *Step 1: importing packages
 *
 */

package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




public class JdbcSteps {

	public static void main(String[] args)throws Exception {

		String username="rawkush";
		String password= "Ankush@123";
		String url="\"jdbc:mysql://localhost:3306/mydbs\"";
		/*
		 * Step2: Load and Register steps
		 *
		 * 			Loading is uploading jar into library
		 *			Register is done by Reflection API
		 *
		 */

		Class.forName("com.mysql.jdbc.Driver");

		/*
		 * Step 3: Connection object
		 *
		 */

		Connection con = DriverManager.getConnection(url,username, password);
		/*
		 * step 4: create statement
		 *
		 */

		Statement st= con.createStatement();

		/*
		 *
		 * Step 5: Execute statement
		 *
		 */
		String query="select * from myemp";
		st.execute(query);

		/*
		 * Step 6: process the result\
		 *
		 * In st.execute returns a result.. we can use it for processing
		 *
		 *
		 */

		ResultSet rs = st.executeQuery(query);//step 5

		//processing
		rs.next(); // to move pointer from first coloum which have coloum name to next coloum which is data coloum
		String name= rs.getString("ename");
		Integer id=rs.getInt("eid");

		/*
		 *
		 * Step 7: close connectfion
		 *
		 */

		con.close();


	}


}

```

## CRUD

```

public class CreateRemoveUpdateDelete  {
	private Employee emp;
	private Connection con;
	private Statement st;
	private ResultSet results;
	private PreparedStatement ps;

	public CreateRemoveUpdateDelete() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbs", "rawkush", "Ankush@123");
			st = con.createStatement();
			System.out.println("connection established");
	}

	public void create() throws SQLException {
		st.execute("create table Employee1 (eid int, eName varchar(30), eAdd varchar(50))");
		System.out.println("Table Created.....");

	}

	public void read() throws SQLException {

		results = st.executeQuery("SELECT * FROM Employee1");
		while (results.next()) {
			  System.out.println(results.getInt("eid") + " " + results.getString("eName") + " " + results.getString("eAdd"));
		}

	}

	public void Update(String name, String newName) throws SQLException{

			ps = con.prepareStatement("update Employee1 set eName=? where eName=?");
			ps.setString(1, newName);
			ps.setString(2, name);
			ps.execute();
			System.out.println("updated");
	}

	public void Delete(String name) throws SQLException{
			 ps = con.prepareStatement("DELETE FROM Employee1 WHERE eName=?");
			 ps.setString(1, name);
			 ps.execute();
			 System.out.println("deleted");
	}

	public void Insert(Employee e1) throws Exception {

			ps = con.prepareStatement("insert into Employee1 values(?,?,?)");
			ps.setInt(1, e1.geteId());
			ps.setString(2, e1.geteName());
			ps.setString(3, e1.geteAdd());
			ps.execute();
			System.out.println("inserted");

	}

	public void Close() throws SQLException{
			System.out.println("connnection Closed.....");
			con.close();

	}
}
```
