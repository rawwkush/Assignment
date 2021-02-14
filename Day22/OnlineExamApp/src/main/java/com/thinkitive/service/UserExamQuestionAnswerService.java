package com.thinkitive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.QuestionRepo;
import com.thinkitive.dao.UserExamQuestionAnswerRepo;
import com.thinkitive.model.Question;
import com.thinkitive.model.userExamQuestionAnswer;

@Service
public class UserExamQuestionAnswerService {
	
	@Autowired
	private UserExamQuestionAnswerRepo repo;
	@Autowired
	private QuestionRepo repo1;
	
	public void addQuestionWithAnswer(userExamQuestionAnswer QA) {
		repo.save(QA);
	}
	
	public int CalculateScore(Long id, Long examid) {
		List<userExamQuestionAnswer> l =repo.findByuserAndExamId(id, examid);
		List<Question> l1 = repo1.findByexamId(examid);
		int score=0;
		for(int i=0;i<l.size();i++) {
			if(l.get(i).getUserAnswerOption() == l1.get(i).getQuestionAnswerOption()) {
				score++;
			}
		}
		return score;
	}
}
