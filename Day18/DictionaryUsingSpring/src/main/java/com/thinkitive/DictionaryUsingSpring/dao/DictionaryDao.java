package com.thinkitive.DictionaryUsingSpring.dao;

import java.util.List;

import com.thinkitive.DictionaryUsingSpring.model.Dictionary;

public interface DictionaryDao {
	public void addWord(Dictionary d);
	public List<Dictionary> read(); 
	public void readword(String word);
	public void delete(String word);
}
