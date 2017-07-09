package com.movie.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.model.Movie;
import com.movie.model.Score;
import com.movie.model.User;
import com.movie.service.MovieManageService;
import com.movie.service.ScoreManageService;
import com.movie.service.UserManageService;
import com.movie.recommend.Starter;

@Controller
//@RequestMapping("/home")
public class HomeController {
	@Autowired
	private MovieManageService movieService;
	@Autowired
	private ScoreManageService scoreService;
	
	@RequestMapping("/Home")
	private String showAll(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws Exception {  
		
		String username = (String) session.getAttribute("username");
		System.out.println(username);
		
		List rlist = movieService.getAllRelease();		
		req.setAttribute("release", rlist);
		
//		List alist = movieService.getAllMovies();		
//		req.setAttribute("all", alist);
//		
//		List clist = movieService.getAllComing();		
//		req.setAttribute("coming", clist);
		
		List rank = movieService.getRank();		
		req.setAttribute("rank", rank);
		
		Starter.initialize();
		
		HashMap<String,Integer> map = new HashMap<>();
		List scores = scoreService.getScores(username);
		
		for(int i = 0;i<scores.size();i++){
			Score s = (Score) scores.get(i);
			int mid = s.getId();
			String mname = movieService.getMovie(mid).getMovieName();
			map.put(mname, (int) s.getScore());
		}
		
		ArrayList<String> arr = Starter.getRec_k(map, 7);
		List recommend = new ArrayList();
		
		for(String str:arr){
			Movie m = movieService.getMovie(str);
			recommend.add(m);
		}
		
		req.setAttribute("recommend", recommend);
		
		return "movies";
	}
	
}
