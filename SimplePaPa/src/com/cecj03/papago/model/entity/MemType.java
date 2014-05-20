package com.cecj03.papago.model.entity;

// Generated 2014-5-20 15:38:07 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * MemType generated by hbm2java
 */
public class MemType implements java.io.Serializable {

	private int memtypeId;
	private String memType;
	private Set papaMems = new HashSet(0);

	public MemType() {
	}

	public MemType(int memtypeId, String memType) {
		this.memtypeId = memtypeId;
		this.memType = memType;
	}

	public MemType(int memtypeId, String memType, Set papaMems) {
		this.memtypeId = memtypeId;
		this.memType = memType;
		this.papaMems = papaMems;
	}

	public int getMemtypeId() {
		return this.memtypeId;
	}

	public void setMemtypeId(int memtypeId) {
		this.memtypeId = memtypeId;
	}

	public String getMemType() {
		return this.memType;
	}

	public void setMemType(String memType) {
		this.memType = memType;
	}

	public Set getPapaMems() {
		return this.papaMems;
	}

	public void setPapaMems(Set papaMems) {
		this.papaMems = papaMems;
	}

}
