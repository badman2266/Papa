package com.cecj03.papago.model.entity;

// Generated 2014-5-20 15:38:07 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * PapaScoreId generated by hbm2java
 */
public class PapaScoreId implements java.io.Serializable {

	private int shopId;
	private int memId;
	private int score;
	private Date scoreDate;

	public PapaScoreId() {
	}

	public PapaScoreId(int shopId, int memId, int score, Date scoreDate) {
		this.shopId = shopId;
		this.memId = memId;
		this.score = score;
		this.scoreDate = scoreDate;
	}

	public int getShopId() {
		return this.shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getMemId() {
		return this.memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getScoreDate() {
		return this.scoreDate;
	}

	public void setScoreDate(Date scoreDate) {
		this.scoreDate = scoreDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PapaScoreId))
			return false;
		PapaScoreId castOther = (PapaScoreId) other;

		return (this.getShopId() == castOther.getShopId())
				&& (this.getMemId() == castOther.getMemId())
				&& (this.getScore() == castOther.getScore())
				&& ((this.getScoreDate() == castOther.getScoreDate()) || (this
						.getScoreDate() != null
						&& castOther.getScoreDate() != null && this
						.getScoreDate().equals(castOther.getScoreDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getShopId();
		result = 37 * result + this.getMemId();
		result = 37 * result + this.getScore();
		result = 37 * result
				+ (getScoreDate() == null ? 0 : this.getScoreDate().hashCode());
		return result;
	}

}