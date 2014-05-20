package com.cecj03.papago.model;

// Generated 2014/5/19 �U�� 03:55:39 by Hibernate Tools 4.0.0

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PapaMsg generated by hbm2java
 */
public class PapaMsg implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int msgId;
	private PapaShop papaShop;
	private PapaMem papaMem;
	private Date msgDate;
	private String msgContent;
	private Set reportMsgs = new HashSet(0);

	public PapaMsg() {
	}

	public PapaMsg(int msgId, PapaShop papaShop, PapaMem papaMem, Date msgDate,
			String msgContent) {
		this.msgId = msgId;
		this.papaShop = papaShop;
		this.papaMem = papaMem;
		this.msgDate = msgDate;
		this.msgContent = msgContent;
	}

	public PapaMsg(int msgId, PapaShop papaShop, PapaMem papaMem, Date msgDate,
			String msgContent, Set reportMsgs) {
		this.msgId = msgId;
		this.papaShop = papaShop;
		this.papaMem = papaMem;
		this.msgDate = msgDate;
		this.msgContent = msgContent;
		this.reportMsgs = reportMsgs;
	}

	public int getMsgId() {
		return this.msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
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

	public Date getMsgDate() {
		return this.msgDate;
	}

	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}

	public String getMsgContent() {
		return this.msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Set getReportMsgs() {
		return this.reportMsgs;
	}

	public void setReportMsgs(Set reportMsgs) {
		this.reportMsgs = reportMsgs;
	}

}
