package com.thinkitive;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.pojoclasses.login;
import com.thinkitive.service.UserService;

@RestController
@RequestMapping("/route")
public class EntryController {
	
	@Autowired
	UserService uservice;
	
	@PostMapping("/login")
	public String CreateSession(@RequestBody login log, HttpServletRequest req) {
		if(uservice.checkCredential(log.getUsername(),log.getPassword())){
			if(req.getSession().getAttribute("username")!=null) {
				return "You Already Logged In";
			}
			else {
				req.getSession().setAttribute("username", log.getUsername());
				return "Successfully Logged In";
			}
		}
		return "Failure";
	}
	
	@PostMapping("/logout")
	public String CloseSession(HttpServletRequest req) {
		req.getSession().invalidate();
		return "Successfully Logged Out";
	}
}
