package com.tuyano.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerid;

	@Column(name = "name")
	private String name;

	@Column(name = "gakunen")
	private int gakunen;

	@Column(name = "seibetu")
	private String seibetu;

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGakunen() {
		return gakunen;
	}

	public void setGakunen(int gakunen) {
		this.gakunen = gakunen;
	}

	public String getSeibetu() {
		return seibetu;
	}

	public void setSeibetu(String seibetu) {
		this.seibetu = seibetu;
	}


}
