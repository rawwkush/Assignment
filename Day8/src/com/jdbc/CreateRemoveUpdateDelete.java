package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateRemoveUpdateDelete {
	private Employee emp;
	private Connection con;
	private Statement st;
	private ResultSet results;
	private PreparedStatement ps;
	
	public CreateRemoveUpdateDelete() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			st = con.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Create() {
		try {
			st.execute("create table Employee1 (eId int, eName varchar(30), eAdd varchar(50))");
			System.out.println("connnection Established.....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Read() {
		try {
			results = st.executeQuery("SELECT * FROM Employee1");
			while (results.next()) {
				  System.out.println(results.getInt("eId") + " " + results.getString("eName") + " " + results.getString("eAdd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Update(String name, String newName) {
		try {
			ps = con.prepareStatement("update Employee1 set eName=? where eName=?");
			ps.setString(1, newName);
			ps.setString(2, name);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Delete(String name){
		 try {
			 ps = con.prepareStatement("DELETE FROM Employee1 WHERE eName=?");
			 ps.setString(1, name);
			 ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Insert(Employee e1) {
		try {
			//System.out.println("insert into Employee1 values (" + e1.geteId() +", " + e1.geteName() +", " + e1.geteAdd()+ ")");
			//st.execute("insert into Employee values (2, 'Employee2')");
			
			ps = con.prepareStatement("insert into Employee1 values(?,?,?)");
			ps.setInt(1, e1.geteId());
			ps.setString(2, e1.geteName());
			ps.setString(3, e1.geteAdd());
			ps.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Close() {
		try {
			System.out.println("connnection Closed.....");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
