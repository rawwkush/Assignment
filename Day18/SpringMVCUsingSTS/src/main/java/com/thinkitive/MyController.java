package com.thinkitive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping(value = "/add")
	public ModelAndView hello(Integer id, String name, Integer salary) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", name);
		service.addEmployee(new Employee(id, name, salary));
		mv.setViewName("welcome.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView update(Integer id, String name, Integer salary) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", name + " updated");
		service.updateEmployee(new Employee(id, name, salary));
		mv.setViewName("welcome.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/delete")
	public ModelAndView delete(Integer id, String name, Integer salary) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", name + " deleted");
		service.deleteEmployee(new Employee(id, name, salary));
		mv.setViewName("welcome.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/read")
	public ModelAndView read() {
		ModelAndView mv = new ModelAndView();
		System.out.println(service.getAll());
		mv.setViewName("welcome.jsp");
		return mv;
	}
}
