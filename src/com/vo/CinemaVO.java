package com.vo;

import java.util.List;

public class CinemaVO {
	private String name;
	private String city;
	private String address;
	private String web;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	public List<TicketVO> getTicketsByMovieName(String movieName){
		return null;
	}
	
	public List<TicketVO> getTicketsSalesInToday(){
		return null;
	}
	
}
