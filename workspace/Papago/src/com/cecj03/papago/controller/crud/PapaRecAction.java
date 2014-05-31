package com.cecj03.papago.controller.crud;

import com.cecj03.papago.model.PapaRec;
import com.cecj03.papago.model.crud.services.PapaRecService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PapaRecAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	
	//需要的表格欄位
	private PapaRec bean; //推薦bean
	private int memId; //推薦會員id
	private int shoptypeId; //推薦店家型別
	private String papaAction; //action
	PapaRecService service; //spring 注入
	
	public void setService(PapaRecService service) {
		this.service = service;
	}

	@Override
	public String execute() throws Exception {
		
		if (papaAction != null && papaAction.equals("Insert")) {
			System.out.println(bean.getName());
			
			PapaRec result = service.createRecShop(bean, memId, shoptypeId);
			if (result != null) {
				
				
				
				return Action.SUCCESS;
				
			} else {
				this.addFieldError("action",
						this.getText("papashopForm.insert.fail"));
			}
			return Action.INPUT;
		} else {
			this.addFieldError("action",
					this.getText("papashopForm.action.unknown"));
			return Action.INPUT;
			
		}
	}

	public PapaRec getBean() {
		return bean;
	}

	public void setBean(PapaRec bean) {
		this.bean = bean;
	}

	public String getPapaAction() {
		return papaAction;
	}

	public void setPapaAction(String papaAction) {
		this.papaAction = papaAction;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public int getShoptypeId() {
		return shoptypeId;
	}

	public void setShoptypeId(int shoptypeId) {
		this.shoptypeId = shoptypeId;
	}
	
}
