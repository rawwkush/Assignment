package com.thinkitive.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thinkitive.dao.EmployeeDAO;
import com.thinkitive.model.Employee;

@Service
public class EmployeeService implements EmployeeDAO{

	private List<Employee> l = new ArrayList<Employee>();
	
	@Override
	public void addEmployee(Employee e) {
		l.add(e);
	}

	@Override
	public void deleteEmployee(Employee e) {
		l.remove(e);
	}

	@Override
	public void updateEmployee(Employee e) {
		l.set(0, e);
	}

	@Override
	public void getEmployee(int empid) {
		for(Employee temp:l) {
			if(temp.getEmpid() == empid) {
				System.out.println("Id:"+ temp.getEmpid() +
						           "Name" + temp.getEmpname() +
						           "Salary" + temp.getSalary());
				break;
			}
		}
	}

	@Override
	public List<Employee> getAll() {
		return l;
	}
	
}
