package com.tuyano.springboot;

import java.sql.Date;


public class TrainingResultBean {


	private int trainingid;

	private String name;

	private int playerid;

	private String rank;

	private Date date;

	private String class1;

	private String koma;

	private String menu;

	private int strength;

	private int count;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

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
