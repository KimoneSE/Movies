package com.vo;

import java.io.Serializable;
import java.util.Date;

public class CommentVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date time;
	private double score;
	private String comment;
	private String username;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "CommentVO [time=" + time + ", score=" + score + ", comment=" + comment + ", username=" + username + "]";
	}
	
	
	
}
