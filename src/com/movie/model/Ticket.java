package com.movie.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.movie.model.pk.TicketPK;

@Entity
@Table(name = "douban_ticket")
@IdClass(TicketPK.class)
public class Ticket {

	private int movieId;
	private int cinemaId;
	private Date time;
	private BigDecimal price;
	private String orderLink;

	@Id
	@Column(name = "movieId")
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	@Id
	@Column(name = "cinemaId")
	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "price")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "orderLink")
	public String getOrderLink() {
		return orderLink;
	}

	public void setOrderLink(String orderLink) {
		this.orderLink = orderLink;
	}

}
