package com.vo;

import java.io.Serializable;
import java.util.Date;

public class BoxOfficeVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String movie;
	private Date time;
	private double boxOffice;
	private String img;
	
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getBoxOffice() {
		return boxOffice;
	}
	public void setBoxOffice(double boxOffice) {
		this.boxOffice = boxOffice;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
