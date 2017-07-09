package com.vo;

import java.io.Serializable;
import java.util.List;

public class MovieDetailVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MovieVO briefIntroduce;
	private List<String> actors;
	private List<String> directors;
	private List<CommentVO> comments;
	
	public MovieVO getBriefIntroduce() {
		return briefIntroduce;
	}
	public void setBriefIntroduce(MovieVO briefIntroduce) {
		this.briefIntroduce = briefIntroduce;
	}
	public List<String> getActors() {
		return actors;
	}
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	public List<String> getDirectors() {
		return directors;
	}
	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}
	public List<CommentVO> getComments() {
		return comments;
	}
	public void setComments(List<CommentVO> comments) {
		this.comments = comments;
	}

	
}
