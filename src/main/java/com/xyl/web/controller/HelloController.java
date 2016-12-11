package com.xyl.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyl.web.entity.User;

@Controller
@RequestMapping("/Users")
public class HelloController {

	
	@RequestMapping("/hello")
	public String hello(HttpServletRequest request, String username){
		System.out.println("hello,"+username);
		return "hello";
	}
	
	@RequestMapping("/{user}")
	public String getUser(@PathVariable("user") String username,Model model){
		
		User user = new User();
		user.setUsername(username);
		user.setAge(18);
		
		model.addAttribute("user", user);
		
		return "hello";
	}
	
	
}
