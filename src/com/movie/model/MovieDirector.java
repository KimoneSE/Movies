package com.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.movie.model.pk.MovieDirectorPK;

@Entity
@Table(name = "douban_movie_director")
@IdClass(MovieDirectorPK.class)
public class MovieDirector {

	private int moveId;
	private int directorId;
	private String directorName;

	@Id
	@Column(name = "moveId")
	public int getMoveId() {
		return moveId;
	}

	public void setMoveId(int moveId) {
		this.moveId = moveId;
	}

	@Id
	@Column(name = "directorId")
	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	@Column(name = "directorName")
	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

}
