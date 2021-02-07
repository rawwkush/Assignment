package com.thinkitive.DictionaryUsingSpring.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.thinkitive.DictionaryUsingSpring.dao.DictionaryDao;
import com.thinkitive.DictionaryUsingSpring.model.Dictionary;

@Service
public class DictionaryServices implements DictionaryDao{

	private Configuration cfg;
	private SessionFactory factory;
	private Session session;
	private Transaction tx;
	
	private void createConnection() {
		cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
	}
	
	@Override
	public void addWord(Dictionary d) {
		createConnection();
		session.save(d);
		tx.commit();
		closeConnection();
	}

	@Override
	public List<Dictionary> read() {
		createConnection();
		List<Dictionary> l = session.createQuery("from Dictionary").list();
		tx.commit();
		closeConnection();
		return l;
	}
	
	@Override
	public void readword(String word) {
		createConnection();
		List<Dictionary> l = session.createQuery("from Dictionary").list();
		for(Dictionary temp:l) {
			if(temp.getWord().equals(word)) {
				System.out.println("Word: "+temp.getWord() + " "+ "Meaning: " + temp.getMean());
				break;
			}
		}
		tx.commit();
		closeConnection();
	}
	
	@Override
	public void delete(String word) {
		createConnection();
		Dictionary dict = new Dictionary();
		dict.setWord(word);
		session.delete(dict);
		tx.commit();
		closeConnection();
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
