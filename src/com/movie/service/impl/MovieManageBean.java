package com.movie.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.MovieDao;
import com.movie.model.ComingMovie;
import com.movie.model.Movie;
import com.movie.model.ReleaseMovie;
import com.movie.service.MovieManageService;

@Service
public class MovieManageBean implements MovieManageService{

	@Autowired
	private MovieDao movieDao;
	
	@Override
	public List getAllRelease() {
		// TODO Auto-generated method stub
		return movieDao.getAllRelease();
	}

	@Override
	public List getRank() {
		return movieDao.getRank();
	}

	@Override
	public List getAllMovies() {
		// TODO Auto-generated method stub
		return movieDao.getAllMovies();
	}

	@Override
	public List getAllComing() {
		// TODO Auto-generated method stub
		return movieDao.getAllComing();
	}

	@Override
	public Map getDetail(String mname) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		
		ReleaseMovie rm = movieDao.getRelease(mname);
		ComingMovie cm = movieDao.getComing(mname);
		Movie m = movieDao.getMovie(mname);
		return map;
	}

}
