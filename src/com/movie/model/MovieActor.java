package com.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.movie.model.pk.MovieActorPK;

@Entity
@Table(name = "douban_movie_actor")
@IdClass(MovieActorPK.class)
public class MovieActor {

	private int movieId;
	private int actorId;
	private String actorName;

	
	@Id
	@Column(name="movieId")
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	@Id
	@Column(name="actorId")
	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	@Column(name="actorName")
	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

}
