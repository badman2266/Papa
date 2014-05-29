package com.cecj03.papago.controller.crud;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.cecj03.papago.model.PapaShop;
import com.opensymphony.xwork2.ActionSupport;

public class RecShopAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.request = request;
	}

	
	private PapaShop entity;
	private int memId;
	private String crudAction;

	
	
	
	
	
	
	
	
	
	
	
	
	public PapaShop getEntity() {
		return entity;
	}

	public void setEntity(PapaShop entity) {
		this.entity = entity;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public String getCrudAction() {
		return crudAction;
	}

	public void setCrudAction(String crudAction) {
		this.crudAction = crudAction;
	}
	
}
