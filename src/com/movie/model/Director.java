package com.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.movie.model.pk.DirectorPK;

@Entity
@Table(name = "dirctor_list")
@IdClass(DirectorPK.class)
public class Director {

	private String movieName;
	private String directorName;

	@Id
	@Column(name = "movieName")
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Id
	@Column(name = "dirctorName")
	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

}
