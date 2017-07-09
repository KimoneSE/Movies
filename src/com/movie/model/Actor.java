package com.movie.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "douban_actors")
public class Actor {

	@Id
	@Column(name="id")
	private int id;
	@Column(name="actorName")
	private String actorName;
	@Column(name="sex")
	private Sex sex;
	@Column(name="birthday")
	private Date birthday;
	@Column(name="homeLand")
	private String homeLand;
	@Column(name="headPic")
	private String headPic;
	@Column(name="introduce")
	private String introduce;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHomeLand() {
		return homeLand;
	}

	public void setHomeLand(String homeLand) {
		this.homeLand = homeLand;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}
