package com.Books;

import java.util.Comparator;

import com.thinkitive.Book;

public class CompareBooksByPrice implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		
		return (int) (o1.getPrice() - o2.getPrice());
	}

}
