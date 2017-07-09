package com.vo;

import java.io.Serializable;
import java.util.Date;

public class ReleaseMovieVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String movieName;
	private String director;
	private String duration;
	private String img;
	private String region;
	private String releaseTime;
	private String score;
	private String star;
	private Date time;
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "ReleaseMovieVO [movieName=" + movieName + ", director=" + director + ", duration=" + duration + ", img="
				+ img + ", region=" + region + ", releaseTime=" + releaseTime + ", score=" + score + ", star=" + star
				+ ", time=" + time + "]";
	}
	
	
}
