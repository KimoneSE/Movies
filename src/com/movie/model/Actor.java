package com.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.movie.model.pk.ActorPK;

@Entity
@Table(name = "actor_list")
@IdClass(ActorPK.class)
public class Actor {

	private String movieName;
	private String actorName;

	@Id
	@Column(name="movieName")
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Id
	@Column(name="actorName")
	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

}
