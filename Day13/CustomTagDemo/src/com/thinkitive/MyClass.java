package com.thinkitive;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class MyClass extends TagSupport {
	private String message;
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String s) {
		this.message = s;
	}
	StringWriter sw = new StringWriter();
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		int ans=1;
		try {
			for(int i=Integer.parseInt(message); i>0; i--) {
				ans= ans*i;
			}
			out.println("Factorial is..."+ ans);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
