package com.thinkitive;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
	
}
