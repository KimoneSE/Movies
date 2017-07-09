package com.data.impls.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "douban_movie")
public class DouBanMovieEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int movieId;
	@Column(name = "movieName")
	private String movieName;
	@Column(name = "region")
	private String region;
	@Column(name = "language")
	private String language;
	@Column(name = "releaseDate")
	private Date releaseDate;
	@Column(name = "during")
	private double during;
	@Column(name = "poster")
	private String poster;
	@Column(name = "score")
	private double score;
	@Column(name = "summary")
	private String summary;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public double getDuring() {
		return during;
	}
	public void setDuring(double during) {
		this.during = during;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
