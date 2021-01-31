package com.thinkitive;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MyDBConnection {
	private Configuration cfg;
	private SessionFactory factory;
	private Session session;
	private Transaction tx;
	
	
	public void Create() {
		cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
	}
	private void Close() {
		if(session!=null) {
			session.close();
		}
		if(factory!=null) {
			factory.close();
		}
	}
	
	public void insert(Employee e) {
		Create();
		session.save(e);
		tx.commit();
		System.out.println("Employee Created");
		Close();
	}
	
	public void Read() {
		Create();
		Query q = session.createQuery("From Employee");
		List l = q.list();
		System.out.println(l);
		tx.commit();
		Close();
	}
	
	public void update(String n1, String n2) {
		Create();
		Query query = session.createQuery("update Employee set ename = :newName" +
				" where ename = :name");
		query.setParameter("name", n1);
		query.setParameter("newName", n2);
		query.executeUpdate();
		tx.commit();
		Close();
	}
	
	public void delete(Employee e) {
		Create();
		session.delete(e);
		tx.commit();
		Close();
	}
}
