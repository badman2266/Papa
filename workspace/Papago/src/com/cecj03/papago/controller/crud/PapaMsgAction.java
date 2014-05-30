package com.cecj03.papago.controller.crud;



import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecj03.papago.model.PapaMsg;
import com.cecj03.papago.model.crud.services.benchenService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PapaMsgAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	private PapaMsg bean;
	private String papaAction;
	
	
	
	@Override
	public String execute() throws Exception {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());
		benchenService service = (benchenService) context.getBean("benchenService");
		
		
		if(papaAction != null && papaAction.equals("Insert")){
			PapaMsg result = service.writeMessage(bean);
			
			if (result != null) {
				
				request.setAttribute("insert", result);
				
			} else {
				this.addFieldError("action",
						this.getText("papashopForm.insert.fail"));
			}
			return Action.SUCCESS;
		}else {
			this.addFieldError("action",
					this.getText("papashopForm.action.unknown"));
			return Action.INPUT;
		}
		
		
		
	}
	public PapaMsg getBean() {
		return bean;
	}
	public void setBean(PapaMsg bean) {
		this.bean = bean;
	}
	public String getPapaAction() {
		return papaAction;
	}
	public void setPapaAction(String papaAction) {
		this.papaAction = papaAction;
	}

	
	
	

}
