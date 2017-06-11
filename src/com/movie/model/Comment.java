package com.movie.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.movie.model.pk.RankPK;

@Entity
@Table(name = "comment")
@IdClass(RankPK.class)
public class Comment {

	private String movie;
	private Date time;
	private double score;
	private String comment;
	private String username;

	@Id
	@Column(name="movie")
	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name="score")
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Column(name="comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
