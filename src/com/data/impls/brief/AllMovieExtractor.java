package com.data.impls.brief;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vo.MovieVO;

public class AllMovieExtractor {
	@Autowired
	private SessionFactory sessionFactory;
	private final int PAGE_SIZE = 10;
	
	List<MovieVO> getAllMovies(int page){
		
		return null;
	}
}
