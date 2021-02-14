package com.thinkitive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkitive.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
