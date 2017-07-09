package com.vo;

import java.util.Date;
import java.util.Map;

public class TicketVO {
	private String movieName;
	private double price;
	private Map<Date, String> timeAndOrderLink;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Map<Date, String> getTimeAndOrderLink() {
		return timeAndOrderLink;
	}
	public void setTimeAndOrderLink(Map<Date, String> timeAndOrderLink) {
		this.timeAndOrderLink = timeAndOrderLink;
	}
	
	

}
