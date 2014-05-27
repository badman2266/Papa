package com.cecj03.papago.controller.crud;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cecj03.papago.model.PapaMem;
import com.cecj03.papago.model.crud.services.PapaMemCrudService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	private String memAccount;
	private String memPassword;

	private PapaMemCrudService service;

	@Override
	public String execute() throws Exception {
		PapaMem entity = service.login(memAccount, memPassword);

		if (entity == null) {
			this.addFieldError("password", this.getText("loginForm.login.fail"));
			return Action.INPUT;
		} else {
			session.put("user", entity);
			session.put("logined","true");
            session.put("context", new Date());
            
			String dest = (String) session.get("dest");
			if (dest == null || dest.length() == 0) {

				if (entity.getMemType().getMemtypeId() == 1) {
					System.out.println(entity.getMemType().getMemType());
					return Action.SUCCESS;
				} else if (entity.getMemType().getMemtypeId() == 2) {
					System.out.println(entity.getMemType().getMemType());
					return "adminSuccess";
				}

				System.out.println(entity.getMemType().getMemType());
				return Action.SUCCESS;
			} else {
				this.location = dest;
				return "XXX";
			}
		}
	}

	public String logout() throws Exception {
		Map<?, ?> session = ActionContext.getContext().getSession();
		if (session!=null){
			session.remove("logined");
			session.remove("context");
			return Action.SUCCESS;
			
		}else{
			return Action.INPUT;
		}
		
	}

	public void setService(PapaMemCrudService service) {
		this.service = service;
	}

	public String getMemAccount() {
		return memAccount;
	}

	public void setMemAccount(String memAccount) {
		this.memAccount = memAccount;
	}

	public String getMemPassword() {
		return memPassword;
	}

	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}

	private String location;

	public String getLocation() {
		return location;
	}

}
