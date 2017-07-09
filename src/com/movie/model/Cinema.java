package com.movie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "douban_cinema")
public class Cinema {

	private int cinemaId;
	private String cinemaName;
	private String route;
	private String address;
	private String web;

	@Id
	@Column(name = "cinemaId")
	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	@Column(name = "cinemaName")
	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "route")
	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@Column(name = "web")
	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

}
