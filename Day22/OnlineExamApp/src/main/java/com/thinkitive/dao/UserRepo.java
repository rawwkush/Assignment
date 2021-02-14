package com.thinkitive.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkitive.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	public List<User> findByuserName(String user);
}
