package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDB {
	/*
	 * 
	 * JDBC
	 * 
	 */
	public static void main(String[] args) {
		
		try {	
//			??create Connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbs", "rawkush", "Ankush@123");
			Statement st= con.createStatement();
			//st.execute("insert into employee values(1,'Akash H')");
			
			ResultSet rs= st.executeQuery("select * from think_emp");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ " "+ rs.getString("name")  );
			}
			con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	


}