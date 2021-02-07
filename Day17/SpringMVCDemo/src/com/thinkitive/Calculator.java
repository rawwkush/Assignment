package com.thinkitive;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
	public Calculator() {
	}
	
	public int Add(int a, int b) {
		return a+b;
	}
	
	public int Sub(int a, int b) {
		return a-b;
	}
	
	public int Mul(int a, int b) {
		return a*b;
	}
	
	public int Div(int a, int b) {
		return a/b;
	}
}
