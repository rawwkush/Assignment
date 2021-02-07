package com.thinkitive;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Address a = new Address(411027, "Guhagar");

		Employee e = new Employee(10, "PQR", 12345, a);
		
		session.save(e);
		t.commit();
		session.close();
		factory.close();
	}
}
