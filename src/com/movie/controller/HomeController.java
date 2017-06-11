package com.movie.controller;

import java.util.List;
import java.util.Map;

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
		
		List rlist = movieService.getAllRelease();		
		req.setAttribute("release", rlist);
		
		List alist = movieService.getAllMovies();		
		req.setAttribute("all", alist);
		
		List clist = movieService.getAllComing();		
		req.setAttribute("coming", clist);
		
		List rank = movieService.getRank();		
		req.setAttribute("rank", rank);
		
		return "index";
	}
	
}
