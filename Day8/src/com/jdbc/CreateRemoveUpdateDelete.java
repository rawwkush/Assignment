package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
