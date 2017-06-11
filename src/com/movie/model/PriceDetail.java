package com.movie.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.movie.model.pk.PriceDetailPK;

@Entity
@Table(name = "price_detail")
@IdClass(PriceDetailPK.class)
public class PriceDetail {

	private String id;
	private String movieName;
	private Date time;
	private String orderLink;

	@Id
	@Column(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name="movieName")
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time")	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name="orderLink")
	public String getOrderLink() {
		return orderLink;
	}

	public void setOrderLink(String orderLink) {
		this.orderLink = orderLink;
	}

}
