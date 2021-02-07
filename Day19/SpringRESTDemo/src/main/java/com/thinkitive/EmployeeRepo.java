package com.thinkitive;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRepo {
	
	private List<Employee> l;
	private Configuration cfg;
	private SessionFactory factory;
	private Session session;
	private Transaction tx;
	
	public EmployeeRepo() {
		l = new ArrayList<Employee>();
	}

	public EmployeeRepo(List<Employee> l) {
		super();
		this.l = l;
	}
	
	public void setL(List<Employee> l) {
		this.l = l;
	}
	
	public List<Employee> getL() {
		return l;
	}
	
	public void addEmployee(Employee e) {
		creacteConnection();
		session.save(e);
		tx.commit();
		closeConnection();
	}
	
	public void updateEmployee(Integer id,Employee e) {
		l.set(id, e);
	}
	
	public void deleteEmployee(Employee e) {
		l.remove(e);
	}
	
	public Employee getEmployee(Integer id) {
		for(Employee temp:l) {
			if(temp.getEmpid() == id) {
				return temp;
			}
		}
		return l.get(id);
	}
	
	public List<Employee> getAllEmployees() {
		creacteConnection();
		List<Employee> l1 = session.createQuery("from Employee").list();
		tx.commit();
		closeConnection();
		return l1;
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
}
