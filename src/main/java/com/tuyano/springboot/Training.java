package com.tuyano.springboot;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="training")
public class Training {

	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int trainingid;

	@Column(name="date")
	private Date date;

	@Column(name="class")
	private String class1;

	@Column(name="koma")
	private String koma;

	@Column(name="menu")
	private String menu;

	@Column(name="strength")
	private int strength;

	@Column(name="count")
	private int count;

	public int getTrainingid() {
		return trainingid;
	}

	public void setTrainingid(int trainingid) {
		this.trainingid = trainingid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	public String getKoma() {
		return koma;
	}

	public void setKoma(String koma) {
		this.koma = koma;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}




}
