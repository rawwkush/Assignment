package com.thinkitive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thinkitive.enums.Gender;
import com.thinkitive.enums.UserStatus;
import com.thinkitive.enums.UserType;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userEmail;
	private String userPassword;
	private String userName;
	private Gender userGender;
	private String userAddress;
	private String userMobile;
	private String userCreatedOn;
	private UserType type;
	private UserStatus isApproved;
	
	public User() {
		
	}

	public User(Long userId, String userEmail, String userPassword, String userName, Gender userGender,
			String userAddress, String userMobile, String userCreatedOn, UserType type, UserStatus isApproved) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender = userGender;
		this.userAddress = userAddress;
		this.userMobile = userMobile;
		this.userCreatedOn = userCreatedOn;
		this.type = type;
		this.isApproved = isApproved;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Gender getUserGender() {
		return userGender;
	}

	public void setUserGender(Gender userGender) {
		this.userGender = userGender;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserCreatedOn() {
		return userCreatedOn;
	}

	public void setUserCreatedOn(String userCreatedOn) {
		this.userCreatedOn = userCreatedOn;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public UserStatus getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(UserStatus isApproved) {
		this.isApproved = isApproved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
}
