package com.movie.dao;

import java.util.List;

import com.movie.model.Score;

public interface ScoreDao {
	
	public void add(Score s);
	
	public Score get(String username,int movieId);
	
	public List get(String username);

}
