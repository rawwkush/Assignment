package com.thinkitive.test;

import com.thinkitive.dao.QuestionCRUD;
import com.thinkitive.model.Question;

public class TestQuestionCrud {
	public static void main(String[] args) {
		//add();
		//delete();
		getQuestion();
	}
	
	public static void getQuestion() {
		QuestionCRUD crud= new QuestionCRUD();
		Question ques=crud.getQuestion(1);
		System.out.println(ques);
	}
	public static void delete() {
		QuestionCRUD crud= new QuestionCRUD();
		crud.deleteQuestion(4);	
	}
	
	public static void add() {
		QuestionCRUD crud= new QuestionCRUD();
		Question ques= new Question();
		ques.setQuestion("Google CEO from which country");
		ques.setOpt1("india");
		ques.setOpt2("england");
		ques.setOpt3("australia");
		ques.setOpt4("america");
		ques.setCorrectoption("1");
		crud.insertQuestion(ques);
	}
	
	public static void addMultiple() {
		QuestionCRUD crud= new QuestionCRUD();
		Question ques= new Question();
		ques.setQuestion("Google CEO from which country");
		ques.setOpt1("india");
		ques.setOpt2("england");
		ques.setOpt3("australia");
		ques.setOpt4("america");
		ques.setCorrectoption("1");
		crud.insertQuestion(ques);
		
		ques.setQuestion("Google CEO from which country");
		crud.insertQuestion(ques);
		
		
		ques.setQuestion("2nd most populated country");
		crud.insertQuestion(ques);
		
		ques.setQuestion("Spices are invented in which country");
		crud.insertQuestion(ques);
		
		ques.setQuestion("MS Dhoni is the caption of which cricket team");
		crud.insertQuestion(ques);
		
		ques.setQuestion("Bharat is the name os which country");
		crud.insertQuestion(ques);
		
		ques.setQuestion("Delhi is the capital of");
		crud.insertQuestion(ques);
		
	}
	
	
	
}
