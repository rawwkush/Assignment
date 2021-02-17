package com.thinkitive.test;

import java.util.List;

import com.thinkitive.dao.UserCRUD;
import com.thinkitive.model.User;

public class TestUserCRUD {
	public static void main(String[] args) {
		insert();
		show();
	}
	
	public static void insert() {
		UserCRUD test= new UserCRUD();
		User user= new User();
		user.setUsername("atul");
		user.setPassword("123");
		user.setRole("teacher");
		test.insertUser(user);
	}
	
	public static void delete() {
		UserCRUD test= new UserCRUD();
		test.deleteUser("shyam");
	}
	
	public static void show() {
		UserCRUD crud= new UserCRUD();
		List<User> ls=crud.getAll();
		System.out.println(ls.toString());
	}
	
}
