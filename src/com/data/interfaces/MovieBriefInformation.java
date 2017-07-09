package com.data.interfaces;

import java.util.List;

import com.vo.BoxOfficeVO;
import com.vo.MovieVO;
import com.vo.ReleaseMovieVO;

import groovy.transform.NotYetImplemented;

public interface MovieBriefInformation {
	public List<ReleaseMovieVO> getAllRelease();
	
	public List<MovieVO> getAllMovies(int page);
	
	@NotYetImplemented
	public List<?> getAllComing();		//֧�ָ÷��������ݿⲻ����
	
	public List<BoxOfficeVO> getRank();
}
