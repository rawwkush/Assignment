package com.Books;

import java.util.List;

import com.thinkitive.Book;

public class PrintUtil {
	public PrintUtil() {
		
	}
	
	public static void PrintRecords(List l) {
		for(Object temp:l) {
			System.out.println((Book)temp);
		}
	}
	
	
}
