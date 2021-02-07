package com.Books;

import java.util.ArrayList;
import java.util.List;

import com.thinkitive.Book;

public class StoreUtil <T> {
	private List records = new ArrayList();
	
	public StoreUtil() {
		
	}

	public StoreUtil(List records) {
		super();
		this.records = records;
	}
	
	public void addRecords(Book record) {
		this.records.add(record);
	}
	
	public List getRecords() {
		return this.records;
	}
	
	public int getNumOfRecords() {
		return this.records.size();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((records == null) ? 0 : records.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreUtil other = (StoreUtil) obj;
		if (records == null) {
			if (other.records != null)
				return false;
		} else if (!records.equals(other.records))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "records="+ "\n" + records + "";
	}
	
	
}
