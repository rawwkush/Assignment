package com.thinkitive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.QuestionRepo;
import com.thinkitive.model.Question;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepo repo;
	
	public void addQuestion(Question que) {
		repo.save(que);
	}
	
	public void updateQuestion(Question que) {
		repo.save(que);
	}
	
	public void deleteQuestion(Question que) {
		repo.delete(que);
	}
}
