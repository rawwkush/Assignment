package com.thinkitive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkitive.model.User;
import com.thinkitive.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private UserService uservice;
	/* Registration Section*/
	/*Start*/
	@GetMapping("/add")
	public User addStudent(@RequestBody User user) {
		uservice.addUser(user);
		return user;
	}
	/*End*/
}
