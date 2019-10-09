package com.tuyano.springboot;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manage")
public class Manage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int manageid;

	@Column(name="playerid")
	private int playerid;

	@Column(name="date")
	private Date date;

	@Column(name="class")
	private String class1;


	public int getManageid() {
		return manageid;
	}

	public void setManageid(int manageid) {
		this.manageid = manageid;
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
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



}
