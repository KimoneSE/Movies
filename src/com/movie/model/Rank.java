package com.movie.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.movie.model.pk.RankPK;
import com.movie.model.pk.ReleaseMoviePK;

@Entity
@Table(name="rank")
@IdClass(RankPK.class)
public class Rank {
	private String movie;
	private Date time;
	private double boxOffice;
	private String img;
	
	@Id
	@Column(name="movie")
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	
	@Id
	@Column(name="time")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Column(name="boxOffice")
	public double getBoxOffice() {
		return boxOffice;
	}
	public void setBoxOffice(double boxOffice) {
		this.boxOffice = boxOffice;
	}
	
	@Column(name="img")
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
