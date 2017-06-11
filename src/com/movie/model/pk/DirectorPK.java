package com.movie.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DirectorPK implements Serializable {

	@Column(name = "movieName")
	private String movieName;
	@Column(name = "dirctorName")
	private String dirctorName;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirctorName() {
		return dirctorName;
	}

	public void setDirctorName(String dirctorName) {
		this.dirctorName = dirctorName;
	}
}
