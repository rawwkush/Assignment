package com.thinkitive.DictionaryUsingSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thinkitive.DictionaryUsingSpring.model.Dictionary;
import com.thinkitive.DictionaryUsingSpring.service.DictionaryServices;

@Controller
public class HomeController {
	
	@Autowired
	private DictionaryServices service;

	@RequestMapping(value="/hello")
	public ModelAndView hello(@RequestParam(required=false, defaultValue="World") String name) {
		ModelAndView ret = new ModelAndView("home");
		ret.addObject("name", name);
		return ret;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(String user, String pass) {
		ModelAndView mv = new ModelAndView();
		if(user.equals("admin") && pass.equals("admin")) {
			mv.setViewName("adminPage");
		}else {
			mv.setViewName("userPage");
		}
		return mv;
	}
	
	@RequestMapping(value = "/add")
	public ModelAndView add(String word, String mean) {
		ModelAndView mv = new ModelAndView();
		System.out.println("add method");
		service.addWord(new Dictionary(word, mean));
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/read")
	public ModelAndView read() {
		ModelAndView mv = new ModelAndView();
		System.out.println("read method");
		System.out.println(service.read());
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/retrieve")
	public ModelAndView readword(String word) {
		ModelAndView mv = new ModelAndView();
		System.out.println("read word");
		service.readword(word);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/delete")
	public ModelAndView deleteword(String deleteword) {
		ModelAndView mv = new ModelAndView();
		System.out.println("deleting word...... "+ deleteword);
		service.delete(deleteword);
		mv.setViewName("home");
		return mv;
	}
}
