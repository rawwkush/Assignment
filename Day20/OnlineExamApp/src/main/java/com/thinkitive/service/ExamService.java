package com.thinkitive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.OnlineExamRepo;
import com.thinkitive.model.Online_Exam;

@Service
public class ExamService {
	
	@Autowired
	private OnlineExamRepo repo;
	
	public void addExam(Online_Exam exam) {
		repo.save(exam);
	}
	
	public void updateExam(Online_Exam exam) {
		repo.save(exam);
	}
	
	public void deleteExam(Online_Exam exam) {
		repo.delete(exam);
	}
}
