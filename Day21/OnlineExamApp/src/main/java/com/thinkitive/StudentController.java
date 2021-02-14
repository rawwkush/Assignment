package com.thinkitive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.model.ExamEnroll;
import com.thinkitive.model.User;
import com.thinkitive.model.userExamQuestionAnswer;
import com.thinkitive.pojoclasses.Score;
import com.thinkitive.service.ExamEnrollService;
import com.thinkitive.service.UserExamQuestionAnswerService;
import com.thinkitive.service.UserService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private UserService uservice;
	@Autowired
	private ExamEnrollService enrollService;
	@Autowired 
	private UserExamQuestionAnswerService qaService; 	
	
	/* Registration Section*/
	/*Start*/
	@GetMapping("/add")
	public User addStudent(@RequestBody User user) {
		uservice.addUser(user);
		return user;
	}
	
	@PostMapping("/enroll")
	public ExamEnroll enrollStudent(@RequestBody ExamEnroll enroll) {
		enrollService.enrollForExam(enroll);
		return enroll;
	}
	
	@DeleteMapping("/unenroll")
	public ExamEnroll unenrollStudent(@RequestBody ExamEnroll enroll) {
		enrollService.unerollFromExam(enroll);
		return enroll;
	}
	
	@PostMapping("/answer")
	public userExamQuestionAnswer answerbystudent(@RequestBody userExamQuestionAnswer QA) {
		qaService.addQuestionWithAnswer(QA);
		return QA;
	}
	
	@GetMapping("/score")
	public String studentScore(@RequestBody Score score) {
		return String.valueOf(qaService.CalculateScore(score.getUserId(), score.getExamId()));
	}
	/*End*/
}
