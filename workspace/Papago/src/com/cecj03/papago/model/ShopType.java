package com.cecj03.papago.model;

// Generated 2014/5/19 �U�� 03:55:39 by Hibernate Tools 4.0.0


import java.util.HashSet;
import java.util.Set;

/**
 * ShopType generated by hbm2java
 */
public class ShopType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shoptypeId;
	private String shopType;
	private Set papaRecs = new HashSet(0);
	private Set papaShops = new HashSet(0);

	public ShopType() {
	}

	public ShopType(int shoptypeId, String shopType) {
		this.shoptypeId = shoptypeId;
		this.shopType = shopType;
	}

	public ShopType(int shoptypeId, String shopType, Set papaRecs,
			Set papaShops) {
		this.shoptypeId = shoptypeId;
		this.shopType = shopType;
		this.papaRecs = papaRecs;
		this.papaShops = papaShops;
	}

	public int getShoptypeId() {
		return this.shoptypeId;
	}

	public void setShoptypeId(int shoptypeId) {
		this.shoptypeId = shoptypeId;
	}

	public String getShopType() {
		return this.shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public Set getPapaRecs() {
		return this.papaRecs;
	}

	public void setPapaRecs(Set papaRecs) {
		this.papaRecs = papaRecs;
	}

	public Set getPapaShops() {
		return this.papaShops;
	}

	public void setPapaShops(Set papaShops) {
		this.papaShops = papaShops;
	}

}
