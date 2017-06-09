package com.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.service.MovieManageService;

@Controller
//@RequestMapping("/home")
public class HomeController {
	@Autowired
	private MovieManageService movieService;
	
	@RequestMapping("/Home")
	private String showAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {  
		List list = movieService.getAllRelease();
		
		req.setAttribute("release", list);
		return "index";
	}
}
