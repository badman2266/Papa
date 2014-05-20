package controller;

import com.opensymphony.xwork2.Action;

public class FormAction implements Action {
	
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("name="+name);
		return Action.SUCCESS;
	}

}
