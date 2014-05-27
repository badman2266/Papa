package com.cecj03.papago.controller.crud;



import com.cecj03.papago.model.crud.services.PapaMemCrudService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePwdAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String account;
	private String oldPassword;
	private String newPassword;
	private String crudAction;
	
	private PapaMemCrudService service;
	
	
	public String execute() throws Exception {
		
		if(crudAction!=null && crudAction.length()!=0){
			System.out.println(account+" "+oldPassword+" "+newPassword);
			boolean change=service.changePassword(account, oldPassword, newPassword);
			if(change){
				System.out.println("成功");
				return Action.SUCCESS;
			}else{
				this.addFieldError("changepwd", this.getText("account.password.changepwd"));
				return Action.INPUT;
			}
		}else{
			this.addFieldError("changepwd", this.getText("account.password.input"));
			return Action.INPUT;
		}
	}

	public void setService(PapaMemCrudService service) {
		this.service = service;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCrudAction() {
		return crudAction;
	}

	public void setCrudAction(String crudAction) {
		this.crudAction = crudAction;
	}

}
