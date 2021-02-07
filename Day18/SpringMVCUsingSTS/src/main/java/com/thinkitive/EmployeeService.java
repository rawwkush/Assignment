package com.thinkitive;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private Configuration cfg;
	private SessionFactory factory;
	private Session session;
	private Transaction tx;
	
	public EmployeeService() {
	}
	
	private void creacteConnection() {
		cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
	}
	
	private void closeConnection() {
		if(session!=null){
		session.close();
		}
		if(factory!=null) {
			factory.close();
		}
	}
	
	public void addEmployee(Employee e) {
		creacteConnection();
		session.save(e);
		tx.commit();
		closeConnection();
	}

	public void deleteEmployee(Employee e) {
		creacteConnection();
		session.delete(e);
		tx.commit();
		closeConnection();
	}

	public void updateEmployee(Employee e) {
		creacteConnection();
		session.update(e);
		tx.commit();
		closeConnection();
	}

	public void getEmployee(int empid) {
		creacteConnection();
		List<Employee> l = session.createQuery("from Employee").list();
		tx.commit();
		closeConnection();
		for(Employee temp:l) {
			if(temp.getEmpid() == empid) {
				System.out.println("Id:"+ temp.getEmpid() +
						           "Name" + temp.getEmpname() +
						           "Salary" + temp.getSalary());
				break;
			}
		}
	}

	public List<Employee> getAll() {
		creacteConnection();
		List<Employee> l = session.createQuery("from Employee").list();
		tx.commit();
		closeConnection();
		return l;
	}
}
