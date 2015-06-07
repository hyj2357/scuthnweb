package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.ActModule;

public class CheckUserInfoAction extends ActionSupport{
	
	private ActModule actModule;
	private int id;
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("regCustomer", this.actModule.checkUserInfo(id));
		return SUCCESS;
	}
	public ActModule getActModule() {
		return actModule;
	}
	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
}
