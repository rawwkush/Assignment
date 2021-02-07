package com.thinkitive;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class MyClass {
	public void getEmployees() {
		List l=null;
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Address.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		//Criteria c = session.createCriteria(Address.class);
		//c.add(Restrictions.eqOrIsNull("pincode", 415605));
		//l = c.list();
		l = session.createQuery("From Address").list();
		System.out.println(l);
		t.commit();
		session.close();
		factory.close();
	}
}
