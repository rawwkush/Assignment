package com.thinkitive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.UserRepo;
import com.thinkitive.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	public void addUser(User user) {
		repo.save(user);
	}
	
	public void  updateUser(User user) {
		repo.save(user);
	}
	
	public void deleteUser(User user) {
		repo.delete(user);
	}
	
	public boolean checkCredential(String user, String pass) {
		List<User> l = repo.findByuserName(user);
		if(l.size()>0) {
			if(l.get(0).getUserPassword().equals(pass)) {
				return true;
			}
			else {
				return false;
			}
		}else {
			return false;
		}
	}
}
