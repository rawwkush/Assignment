package com.thinkitive;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.model.User;
import com.thinkitive.service.UserService;

@RestController
@RequestMapping("/AdminLogic")
public class AdminController {
	
	private UserService serv;
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(User user) {
		serv.deleteUser(user);
	}
	
	@GetMapping("/getAllUser")
	public List<User> geUser() {
		return serv.getAllUser();
	}
}
