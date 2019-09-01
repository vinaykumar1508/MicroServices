package com.example.spring.test.spring.security.test;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView home() {
		System.out.println("inside home");
		ModelAndView model = new ModelAndView("home");
		return model;
	}

}
