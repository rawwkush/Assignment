package com.thinkitive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thinkitive.model.Employee;
import com.thinkitive.services.EmployeeService;

@Controller
public class HomeController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping(value="/hello")
	public ModelAndView hello(@RequestParam(required=false, defaultValue="World") String name) {
		ModelAndView ret = new ModelAndView("home");
		ret.addObject("name", name);
		return ret;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String hello(int id, String name, int salary) {
		service.addEmployee(new Employee(id, name, salary));
		System.out.println("Employee Added");
		return "index";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(int id, String name, int salary) {
		service.deleteEmployee(new Employee(id, name, salary));
		return "index";
	}
	
	@RequestMapping(value = "/update")
	public String update(int id, String name, int salary) {
		service.updateEmployee(new Employee(id, name, salary));
		return "index";
	}
	
	@RequestMapping(value = "/getemp")
	public String getemp(int id) {
		service.getEmployee(id);
		return "index";
	}
	
	@RequestMapping(value = "/getall")
	public String getall() {
		System.out.println(service.getAll());
		return "index";
	}
}
