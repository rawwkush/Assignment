package com.thinkitive;

import java.util.Set;

public class Book {
	private int id;
	private String name;
	private Set<String> authors;
	private float price;
	
	
	public Book() {
	}


	public Book(int id, String name, Set<String> authors, float price) {
		super();
		this.id = id;
		this.name = name;
		this.authors = authors;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<String> getAuthors() {
		return authors;
	}


	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
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
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", authors=" + authors + ", price=" + price + "\n";
	}
	
	
}
