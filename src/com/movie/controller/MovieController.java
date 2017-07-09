package com.movie.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.service.MovieManageService;

import net.sf.json.JSONArray;

@Controller
public class MovieController {

	@Autowired
	private MovieManageService movieService;
	
	@RequestMapping("/Movie")
	private String showAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {  
		
		int mid = Integer.parseInt(req.getParameter("id"));
		Map detail = movieService.getDetail(mid);		
		req.setAttribute("detail", detail);
		
		List comments = movieService.getComments(mid);
		req.setAttribute("comments", comments);
		
		JSONArray cnames = movieService.getAllCinemaNames();
		req.setAttribute("cnames", cnames);
			
//		List prices = movieService.getAllPriceInfo(mname);
//		req.setAttribute("prices", prices);
//		System.out.println(cnames);
		String cname = (String) cnames.get(0);
		int cid = movieService.getCinema(cname).getCinemaId();
		List prices = movieService.getMovieTickets(mid, cid);
		req.setAttribute("prices", prices);
		
		return "moviedetail";
	}
}
