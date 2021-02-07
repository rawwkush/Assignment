package com.Books;

import java.util.Collections;
import java.util.List;

public class SortUtils {
	public SortUtils() {
	
	}
	
	public static List SortByName(List l) {
		CompareBooksByName cn = new CompareBooksByName();
		Collections.sort(l, cn);
		return l;
	}
	
	public static List SortByPrice(List l) {
		CompareBooksByPrice pr = new CompareBooksByPrice();
		Collections.sort(l, pr);
		return l;
	}
}
