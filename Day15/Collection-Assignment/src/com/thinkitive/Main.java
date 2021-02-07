package com.thinkitive;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.Books.CompareBooksByName;
import com.Books.CompareBooksByPrice;
import com.Books.SortUtils;
import com.Books.StoreUtil;

public class Main {
	public static void main(String[] args) {
		Set s;
		s = new HashSet();
		s.add("Jodi Picoult");
		s.add("Van Leer");
		Book b1 = new Book(1, "Between the Line",s , 100);
		
		s = new HashSet();
		s.add("Achyut Godbole");
		s.add("Atul Kahate");
		Book b2 = new Book(2, "Operating Systems",s , 99);
		
		StoreUtil su = new StoreUtil();
		
		su.addRecords(b1);
		su.addRecords(b2);
		
		System.out.println("Number of Records: "+su.getNumOfRecords());	
		System.out.println(su.getRecords());
		
		System.out.println("Sorting By Name:");
		SortUtils.SortByName(su.getRecords());
		System.out.println(su.getRecords());
		
		System.out.println("Sorting By Price:");
		SortUtils.SortByPrice(su.getRecords());
		System.out.println(su.getRecords());
	}
}
