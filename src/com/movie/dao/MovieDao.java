package com.movie.dao;

import java.util.List;

import com.movie.model.ComingMovie;
import com.movie.model.DownloadLink;
import com.movie.model.Movie;
import com.movie.model.ReleaseMovie;

public interface MovieDao {

	public List getAllRelease();
	
	public List getAllMovies();
	
	public List getAllComing();
	
	public List getRank();
	
	public ReleaseMovie getRelease(String mname);
	
	public ComingMovie getComing(String mname);
	
	public Movie getMovie(String mname);
	
	public DownloadLink getDownloadLink(String mname);
	
	public double getBoxoffice(String mname);
	
	public List getComments(String mname);
	
	public List getActors(String mname);
	
	public List getDirectors(String mname);
	
}
