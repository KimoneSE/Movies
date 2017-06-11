package com.movie.service;

import java.util.List;
import java.util.Map;

public interface MovieManageService {
	
	public List getAllRelease();
	
	public List getAllMovies();
	
	public List getAllComing();
	
	public List getRank();
	
	public Map getDetail(String mname);

}
