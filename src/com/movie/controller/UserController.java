package com.movie.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.service.UserManageService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	@Autowired
	private UserManageService userService;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)	
	@ResponseBody
	public Map<String, Object> postLogin(String username,String password,HttpSession session){
		Map<String, Object> map = userService.login(username, password);
		System.out.println("&&&&&&&&&&&&&&");
		System.out.println(map);
		if((boolean)map.get("success")){
			session.setAttribute("username", map.get("userName"));
			System.out.println("^^^^^^^^^^^");
			System.out.println(session.getAttribute("username"));
		}
		return map;
	}
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register(){
		return "register";
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> postRegister(String username,String password,HttpSession session) {
		Map<String, Object> map = userService.register(username, password);
		System.out.println(map);
		if((boolean)map.get("success")){
			session.setAttribute("username", map.get("username"));
		}
		return map;
		
	}
}
