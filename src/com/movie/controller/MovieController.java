package com.movie.controller;

import java.util.Map;

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
		
		String mname = req.getParameter("mname");
		Map detail = movieService.getDetail(mname);
		
		req.setAttribute("detail", detail);
		
		return "moviedetail";
	}
}
