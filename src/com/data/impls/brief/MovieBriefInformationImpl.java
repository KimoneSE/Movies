package com.data.impls.brief;

import java.util.Date;
import java.util.List;



import com.data.interfaces.MovieBriefInformation;
import com.vo.BoxOfficeVO;
import com.vo.MovieVO;
import com.vo.ReleaseMovieVO;

public class MovieBriefInformationImpl implements MovieBriefInformation{
	
	@Override
	public List<ReleaseMovieVO> getAllRelease() {		
		return new ReleaseMovieExtractor().getReleaseMovie(new Date());
	}

	@Override
	public List<MovieVO> getAllMovies(int page) {	
		return new AllMovieExtractor().getAllMovies(page);
	}


	@Override
	public List<BoxOfficeVO> getRank() {
		
		return null;
	}
	
	
	@Override
	public List<?> getAllComing() {
		// TODO Auto-generated method stub
		return null;
	}

}
