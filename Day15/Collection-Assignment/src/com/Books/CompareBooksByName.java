package com.Books;

import java.util.Comparator;

import com.thinkitive.Book;

public class CompareBooksByName implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}
