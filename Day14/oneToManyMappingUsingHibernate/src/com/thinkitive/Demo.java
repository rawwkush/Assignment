package com.thinkitive;

import java.util.ArrayList;
import java.util.List;

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
		Address b = new Address(411026, "Ratnagiri");
		Address[] l = new Address[20];
		l[0] =a;
		l[1] = b;
		
		Employee e = new Employee(10, "PQR", 89798, l);
		
		session.save(e);
		t.commit();
		session.close();
		factory.close();
	}
}
