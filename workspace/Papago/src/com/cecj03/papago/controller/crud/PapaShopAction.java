package com.cecj03.papago.controller.crud;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecj03.papago.model.PapaShop;
import com.cecj03.papago.model.PriceType;
import com.cecj03.papago.model.ShopStatusType;
import com.cecj03.papago.model.ShopType;
import com.cecj03.papago.model.crud.services.PapaShopService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PapaShopAction extends ActionSupport implements
		ServletRequestAware {
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

	private PapaShop bean;
	private ShopType st;
	private ShopStatusType sst;
	private PriceType pt;
	private String papaAction;
	
//	
//	@Override
//	public void validate() {
//		if (papaAction != null) {
//			if (papaAction.equals("Insert")) {
//				if (bean.getName() == null) {
//					this.addFieldError("bean.name",
//							this.getText("papashopForm.name.required"));
//				}
//			}
//		}
//	}
	
	@Override
	public String execute() throws Exception {

		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());
		PapaShopService service = (PapaShopService) context
				.getBean("PapaShopService");
		if (papaAction != null && papaAction.equals("Insert")) {
			java.util.Date date = new java.util.Date();
			long temp = date.getTime();
			bean.setShopDate(new java.sql.Timestamp(temp));
			bean.setPriceType(pt);
			bean.setShopStatusType(sst);
			bean.setShopType(st);
			PapaShop result = service.insertShop(bean);
			if (result != null) {
				
				request.setAttribute("insert", result);
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

	public PapaShop getBean() {
		return bean;
	}

	public void setBean(PapaShop bean) {
		this.bean = bean;
	}

	public String getPapaAction() {
		return papaAction;
	}

	public void setPapaAction(String papaAction) {
		this.papaAction = papaAction;
	}
	public ShopType getSt() {
		return st;
	}

	public void setSt(ShopType st) {
		this.st = st;
	}

	public ShopStatusType getSst() {
		return sst;
	}

	public void setSst(ShopStatusType sst) {
		this.sst = sst;
	}

	public PriceType getPt() {
		return pt;
	}

	public void setPt(PriceType pt) {
		this.pt = pt;
	}
}
