package com.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.movie.model.pk.MovieTagPK;

@Entity
@Table(name = "douban_movie_tag")
@IdClass(MovieTagPK.class)
public class MovieTag {

	@Id
	@Column(name="movieId")
	private int movieId;
	
	@Id
	@Column(name="tag")
	private String tag;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
