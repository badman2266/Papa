package com.cecj03.papago.model;

// Generated 2014/5/19 �U�� 03:55:39 by Hibernate Tools 4.0.0

/**
 * FavoritesList generated by hbm2java
 */
public class FavoritesList implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FavoritesListId id;
	private PapaShop papaShop;
	private PapaMem papaMem;

	public FavoritesList() {
	}

	public FavoritesList(FavoritesListId id, PapaShop papaShop, PapaMem papaMem) {
		this.id = id;
		this.papaShop = papaShop;
		this.papaMem = papaMem;
	}

	public FavoritesListId getId() {
		return this.id;
	}

	public void setId(FavoritesListId id) {
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
