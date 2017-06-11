package com.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.service.MovieManageService;

@Controller
public class MovieController {

	@Autowired
	private MovieManageService movieService;
	
	@RequestMapping("/Movie")
	private String showAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {  
		
	}
}
