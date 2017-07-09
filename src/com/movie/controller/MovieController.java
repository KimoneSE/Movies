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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.dao.MovieDao;
import com.movie.dao.impl.MovieDaoImpl;
import com.movie.model.Movie;
import com.movie.model.Price;
import com.movie.model.Score;
import com.movie.model.Ticket;
import com.movie.service.MovieManageService;
import com.movie.service.ScoreManageService;

import net.sf.json.JSONArray;

@Controller
public class MovieController {

	@Autowired
	private MovieManageService movieService;
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private ScoreManageService scoreService;
	
	@RequestMapping("/Movie")
	private String showAll(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws Exception {  
		
		String username = (String) session.getAttribute("username");
		req.setAttribute("username", username);
		
		String mname = req.getParameter("mname");
		Map detail = movieService.getDetail(mname);		
		req.setAttribute("detail", detail);
		
		req.setAttribute("movieName", mname);
		Movie movie = (Movie) detail.get("movie");
		int mid = movie.getMovieId();
		List comments = movieService.getComments(mid);
		req.setAttribute("comments", comments);
		
		JSONArray cnames = movieService.getAllCinemaNames();
		req.setAttribute("cnames", cnames);
			
//		List prices = movieService.getAllPriceInfo(mname);
//		req.setAttribute("prices", prices);
//		System.out.println(cnames);
//		String cname = (String) cnames.get(0);
//		int cid = movieService.getCinema(cname).getCinemaId();
//		List prices = movieService.getMovieTickets(mid, cid);
//		req.setAttribute("prices", prices);
		
		return "moviedetail";
	}
	
	@RequestMapping(value="/price",method=RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> getPrices(String movieName,String cinema){
		System.out.println(movieName);		
		Movie movie = movieDao.getMovie(movieName);
		int mid = movie.getMovieId();
		int cid = movieService.getCinema(cinema).getCinemaId();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Ticket> list = movieService.getMovieTickets(mid, cid);
		
//		System.out.println(list.get(0).getPrice());
		List<String> date = new ArrayList<String>();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				date.add(list.get(i).getTime().toString());
			}
		}
//			System.out.println(list.size());
		map.put("list", list);
		map.put("date", date);
		return map;
	}
	
	@RequestMapping(value="/score",method=RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> getPrices(String movieName,String username,int score){
		System.out.println(movieName);		
		Movie movie = movieDao.getMovie(movieName);
		int mid = movie.getMovieId();
		Map<String, Object> map = new HashMap<String, Object>();
		Score s = new Score();
		s.setId(19);
		s.setMovieId(mid);
		s.setUsername(username);
		s.setScore((double)score);
		scoreService.addScore(s);
		System.out.println(movieName+username+score);
		return map;
	}
}
