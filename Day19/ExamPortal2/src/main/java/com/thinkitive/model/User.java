package com.thinkitive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(nullable = false, unique = true)
	private String username;
    @Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String role;
	@Column(nullable = false)
	private boolean approve;
	
    public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}


	
	public User() {
		super();
		this.approve=false;
	}
	
	
	public boolean isApprove() {
		return approve;
	}



	public void setApprove(boolean approve) {
		this.approve = approve;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", approve="
				+ approve + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	

}
