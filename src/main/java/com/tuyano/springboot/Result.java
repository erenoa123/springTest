package com.tuyano.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="result")
public class Result {

	@Id
	@Column(name = "playerid")
	private int playerid;

	@Column(name = "trainingid")
	private int trainingid;

	@Column(name = "rank")
	private int rank;

	@Column(name = "point")
	private int point;

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public int getTrainingid() {
		return trainingid;
	}

	public void setTrainingid(int trainingid) {
		this.trainingid = trainingid;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}



}
