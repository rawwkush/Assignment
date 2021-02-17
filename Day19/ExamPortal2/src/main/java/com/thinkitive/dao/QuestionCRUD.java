package com.thinkitive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.thinkitive.model.Question;

public class QuestionCRUD {
	

	public Question getQuestion(int id) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Question.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Question.class).add(Restrictions.eq("id", id));

		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Object result = criteria.uniqueResult();
		tx.commit();
		session.close();
		factory.close();

		if (result != null) {
			Question question = (Question) result;
			return question;
			// else invalid password
		}
		return null;
	}


	public void deleteQuestion(int id) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Question.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Question.class).add(Restrictions.eq("id", id));

		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Object result = criteria.uniqueResult();
		if (result != null) {
			Question ques = (Question) result;
			session.delete(ques);
		}
		tx.commit();
		session.close();
		factory.close();
	}

	
	
	public void insertQuestion(Question ques) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Question.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ques);
		tx.commit();
		session.close();
		factory.close();
	}

	// use ids of question to make list and send it to Question and allow Question to get question based on id
	public List<Question> getAll() {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Question.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * Question is a class name, not table name here
		 */
		Criteria criteria = session.createCriteria(Question.class);
		List list = criteria.list();
		tx.commit();
		session.close();
		factory.close();
		return list;
	}
	
}
