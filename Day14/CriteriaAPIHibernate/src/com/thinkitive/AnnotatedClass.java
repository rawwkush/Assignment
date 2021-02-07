package com.thinkitive;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class AnnotatedClass {
	public void getEmployees() {
		List l=null;
		
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		//l = c.list();
		System.out.println(l);
		t.commit();
		session.close();
		factory.close();
	}
}
