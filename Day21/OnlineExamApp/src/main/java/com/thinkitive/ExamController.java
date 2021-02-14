package com.thinkitive;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.dao.OnlineExamRepo;
import com.thinkitive.dao.QuestionRepo;
import com.thinkitive.dao.UserRepo;
import com.thinkitive.model.Online_Exam;
import com.thinkitive.model.Question;
import com.thinkitive.model.User;
import com.thinkitive.service.ExamService;
import com.thinkitive.service.QuestionService;
import com.thinkitive.service.UserService;

@RestController
@RequestMapping("/Exam")
public class ExamController {
	
	@Autowired
	private UserService uservice;
	@Autowired
	private QuestionService qservice;
	@Autowired
	private ExamService eservice;
	
	
	/* Registration Section*/
	/*Start*/
	@GetMapping("/add")
	public User addStudent(@RequestBody User user) {
		uservice.addUser(user);
		return user;
	}
	/*End*/
	
	/*Question Section*/
	/*Start*/
	@PostMapping("/queAdd")
	public Question addQuestion(@RequestBody Question que) {
		qservice.addQuestion(que);
		return que;
	}
	
	@PostMapping("/queUpdate")
	public Question updateQuestion(@RequestBody Question que) {
		qservice.updateQuestion(que);
		return que;
	}
	
	@PostMapping("/queDelete")
	public Question deleteQuestion(@RequestBody Question que) {
		qservice.deleteQuestion(que);
		return que;
	}
	/*End*/
	
	/*Question Section*/
	/*Start*/
	@PostMapping("/examAdd")
	public Online_Exam addExam(@RequestBody Online_Exam exam) {
		eservice.addExam(exam);
		return exam;
	}
	
	@PostMapping("/login")
	public String CreateSession(@RequestBody String user,String pass) {
		return user;
	}
	/*End*/
}
