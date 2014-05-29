package com.cecj03.papago.controller.crud;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecj03.papago.model.PapaRec;
import com.cecj03.papago.model.ShopType;
import com.cecj03.papago.model.crud.services.PapaRecService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PapaRecAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private PapaRec bean;
	private int shoptypeId;
	private int memId;
	private String papaAction;

	@Override
	public String execute() throws Exception {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());
		PapaRecService service = (PapaRecService) context
				.getBean("PapaRecService");
		if (papaAction != null && papaAction.equals("Insert")) {
			//bean.setShopType(st);
			PapaRec result = service.createRecShop(bean, memId, shoptypeId);
			if (result != null) {
			} else {
				this.addFieldError("action",
						this.getText("papashopForm.insert.fail"));
			}
			return Action.SUCCESS;
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

	public int getShoptypeId() {
		return shoptypeId;
	}

	public void setShoptypeId(int shoptypeId) {
		this.shoptypeId = shoptypeId;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

}
