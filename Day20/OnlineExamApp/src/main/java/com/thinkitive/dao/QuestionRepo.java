package com.thinkitive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkitive.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {
	
}
