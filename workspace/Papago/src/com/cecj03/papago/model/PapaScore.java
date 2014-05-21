package com.cecj03.papago.model;

import com.cecj03.papago.model.PapaMem;
import com.cecj03.papago.model.PapaShop;

// Generated 2014-5-20 15:38:07 by Hibernate Tools 3.4.0.CR1

/**
 * PapaScore generated by hbm2java
 */
public class PapaScore implements java.io.Serializable {

	private PapaScoreId id;
	private PapaShop papaShop;
	private PapaMem papaMem;

	public PapaScore() {
	}

	public PapaScore(PapaScoreId id, PapaShop papaShop, PapaMem papaMem) {
		this.id = id;
		this.papaShop = papaShop;
		this.papaMem = papaMem;
	}

	public PapaScoreId getId() {
		return this.id;
	}

	public void setId(PapaScoreId id) {
		this.id = id;
	}

	public PapaShop getPapaShop() {
		return this.papaShop;
	}

	public void setPapaShop(PapaShop papaShop) {
		this.papaShop = papaShop;
	}

	public PapaMem getPapaMem() {
		return this.papaMem;
	}

	public void setPapaMem(PapaMem papaMem) {
		this.papaMem = papaMem;
	}

}
