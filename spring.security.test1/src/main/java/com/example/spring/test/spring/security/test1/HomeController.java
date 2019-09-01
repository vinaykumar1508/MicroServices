package com.example.spring.test.spring.security.test1;


import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		System.out.println("inside login");
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	
	
	@RequestMapping("/success")
	public ModelAndView successPage() {
		System.out.println("inside login");
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	

	@RequestMapping("/logout-success")
	public ModelAndView logoutPage() {
		System.out.println("inside logout");
		ModelAndView model = new ModelAndView("logout");
		return model;
	}
	
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
		System.out.println("inside userrrrrrrrr");
		return principal;
	}
}
