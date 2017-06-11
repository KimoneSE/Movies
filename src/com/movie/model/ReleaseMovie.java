package com.movie.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.movie.model.pk.ReleaseMoviePK;

@Entity
@Table(name = "release_movie")
// @IdClass(ReleaseMoviePK.class)
public class ReleaseMovie {

	// private String city;
	private String movieName;
	private String director;
	private String duration;
	private String img;
	private String region;
	private String releaseTime;
	private String score;
	private String star;
	private Date time;

	// @Id
	// @Column(name="city")
	// public String getCity() {
	// return city;
	// }
	// public void setCity(String city) {
	// this.city = city;
	// }

	@Id
	@Column(name = "movieName")
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Column(name = "director")
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Column(name = "duration")
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Column(name = "img")
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column(name = "region")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "releaseTime")
	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Column(name = "score")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Column(name = "star")
	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	@Column(name = "time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
