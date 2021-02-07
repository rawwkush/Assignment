package com.thinkitive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Autowired
	private EmployeeRepo repo;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		return "Welcome to our Employee Management Software";
	}
	
	@GetMapping(value = "/get/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		return repo.getEmployee(id);
	}
	
	@GetMapping(value = "/getAll")
	public List<Employee> getAllEmployee() {
		return repo.getAllEmployees();
	}
	
	@PostMapping(value = "/post")
	public Employee addEmployee(@RequestBody Employee e) {
		repo.addEmployee(e);
		return e;
	}
	
	@PutMapping(value = "/put/{id}")
	public Employee updateEmployee(@PathVariable("id") Integer id,@RequestBody Employee e) {
		repo.updateEmployee(0, e);
		return e;
	}
	
	@DeleteMapping(value = "/delete")
	public String deleteEmployee(@RequestBody Employee e) {
		repo.deleteEmployee(e);
		return "Employee deleted";
	}
}
