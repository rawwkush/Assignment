package com.thinkitive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.ExamEnrollRepo;
import com.thinkitive.model.ExamEnroll;

@Service
public class ExamEnrollService {
	
	@Autowired
	private ExamEnrollRepo repo;
	
	public void enrollForExam(ExamEnroll enroll){
		repo.save(enroll);
	}
	
	public void unerollFromExam(ExamEnroll enroll){
		repo.delete(enroll);
	}
}
