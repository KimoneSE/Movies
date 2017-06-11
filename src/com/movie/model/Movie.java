package com.movie.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

	private String movie;
	private String region;
	private Date releaseTime;
	private String introduce;
	private String during;
	private String img;
	private String score;

	@Id
	@Column(name="movie")
	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	@Column(name="region")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name="releaseTime")
	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Column(name="introduce")
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Column(name="during")
	public String getDuring() {
		return during;
	}

	public void setDuring(String during) {
		this.during = during;
	}

	@Column(name="img")
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column(name="score")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
