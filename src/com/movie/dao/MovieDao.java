package com.movie.dao;

import java.util.List;

import com.movie.model.Cinema;
import com.movie.model.Movie;

public interface MovieDao {

	public List getAllRelease();
	
	//public List getAllMovies();
	
	//public List getAllComing();
	
	public List getRank();
	
//	public ReleaseMovie getRelease(String mname);
//	
//	public ComingMovie getComing(String mname);
	
	public Movie getMovie(int id);
	
//	public DownloadLink getDownloadLink(String mname);
	
	public double getBoxoffice(String mname);
	
	public List getComments(int id);
	
	public List getActors(int id);
	
	public List getDirectors(int id);
	
	public List getTags(int id);
	
	public List getAllCinemas();
	
	public List getAllCinemaNames();
	
	public Cinema getCinema(int cid);
	
	public Cinema getCinema(String cname);
	
	public List getMovieTickets(int mid,int cid);
	
//	public List getAllPrice(String mname);
//	
//	public List getAllPriceDetail(String mname,String cid);
	
}
