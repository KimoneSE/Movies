package com.movie.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.ScoreDao;
import com.movie.model.Score;
import com.movie.service.ScoreManageService;

@Service
@Transactional
public class ScoreManageServiceImpl implements ScoreManageService {

	@Autowired
	private ScoreDao scoreDao;
	
	@Override
	public void addScore(Score s) {
		System.out.println("^^^^^service^^^^");
		// TODO Auto-generated method stub
		scoreDao.add(s);
	}

	@Override
	public List getScores(String username) {
		// TODO Auto-generated method stub
		return scoreDao.get(username);
	}

}
