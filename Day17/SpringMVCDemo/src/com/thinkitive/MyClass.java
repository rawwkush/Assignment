package com.thinkitive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyClass {
	@Autowired
	private Calculator cal;
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public ModelAndView hello(@RequestParam("txtuser")String user,@RequestParam("txtpass")String pass) {
		System.out.println(user);
		ModelAndView mv = new ModelAndView();
		mv.addObject("message",user);
		mv.setViewName("welcome.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.POST)
	public ModelAndView hello1(@RequestParam("txtuser")String user,@RequestParam("txtpass")String pass) {
		ModelAndView mv = new ModelAndView();
		if(user.equals("admin") && pass.equals("admin")) {
			mv.addObject("message",user);
			mv.setViewName("welcome.jsp");
		}else {
			mv.addObject("message","Username or Password is Wrong");
			mv.setViewName("index.jsp");
		}
		return mv;
	}
	
	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public ModelAndView Add(@RequestParam("firstNum")int a,@RequestParam("secondNum")int b) {
		int ans = cal.Add(a, b);
		ModelAndView mv = new ModelAndView();
		mv.addObject("value", String.valueOf(ans));
		mv.setViewName("index.jsp");
		return mv;
	}
}
