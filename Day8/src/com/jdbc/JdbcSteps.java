package com.jdbc;

/*
 * 
 * 
 *	 # 7 steps for connecting in jdbc
 *	 1. import package  
 *	 2. Load and Register the Drivers
 *	 3. Establish the connection
 *	 4. Create the statement
 *	 5. Execute the Query
 *	 6. Process result
 *	 7. close the connection
 * 
 */



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
