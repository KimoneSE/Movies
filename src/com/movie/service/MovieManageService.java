package com.movie.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

public interface MovieManageService {
	
	public List getAllRelease();
	
//	public List getAllMovies();
//	
//	public List getAllComing();
	
	public List getRank();
	
	public Map getDetail(int id);
	
	public List getComments(int id);
	
	public JSONArray getAllCinemaNames();
	
//	public List getAllPriceInfo(String mname);
	
	public List getMovieTickets(int mid,int cid);

}
