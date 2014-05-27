package com.cecj03.papago.controller.crud;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecj03.papago.model.PapaRec;
import com.cecj03.papago.model.ShopType;
import com.cecj03.papago.model.crud.services.PapaRecSerivce;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PapaRecAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private PapaRec bean;
	private ShopType st;
	private String papaAction;

	@Override
	public String execute() throws Exception {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());
		PapaRecSerivce service = (PapaRecSerivce) context
				.getBean("PapaRecService");
		if (papaAction != null && papaAction.equals("Insert")) {
			bean.setShopType(st);
			PapaRec result = service.insertRecShop(bean);
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

	public ShopType getSt() {
		return st;
	}

	public void setSt(ShopType st) {
		this.st = st;
	}

	public String getPapaAction() {
		return papaAction;
	}

	public void setPapaAction(String papaAction) {
		this.papaAction = papaAction;
	}

}
