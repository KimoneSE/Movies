package com.movie.service;

import java.util.List;

import com.movie.model.Score;

public interface ScoreManageService {
	
	public void addScore(Score s);
	
	public List getScores(String username);

}
