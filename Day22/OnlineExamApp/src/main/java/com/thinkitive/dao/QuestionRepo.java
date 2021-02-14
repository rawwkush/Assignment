package com.thinkitive.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkitive.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {
	public List<Question> findByexamId(Long id);
}
