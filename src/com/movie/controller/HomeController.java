package com.movie.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.model.User;
import com.movie.service.MovieManageService;
import com.movie.service.UserManageService;

@Controller
//@RequestMapping("/home")
public class HomeController {
	@Autowired
	private MovieManageService movieService;
	
	@RequestMapping("/Home")
	private String showAll(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws Exception {  
		
//		String username = (String) session.getAttribute("username");
//		System.out.println(username);
//		User user = userService.findByUsername(username);
//		ModelAndView modelAndView = new ModelAndView("movies");
//		modelAndView.addObject(user);
		
		List rlist = movieService.getAllRelease();		
		req.setAttribute("release", rlist);
		System.out.println(rlist.size());
		
//		List alist = movieService.getAllMovies();		
//		req.setAttribute("all", alist);
//		
//		List clist = movieService.getAllComing();		
//		req.setAttribute("coming", clist);
		
		List rank = movieService.getRank();		
		req.setAttribute("rank", rank);
		
		
		return "movies";
	}
	
}
