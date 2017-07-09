package com.movie.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MovieDirectorPK implements Serializable {

	@Column(name = "moveId")
	private int moveId;
	@Column(name = "directorId")
	private int directorId;

	public int getMoveId() {
		return moveId;
	}

	public void setMoveId(int moveId) {
		this.moveId = moveId;
	}

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

}
