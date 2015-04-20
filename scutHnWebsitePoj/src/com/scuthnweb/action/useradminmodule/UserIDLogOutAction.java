package com.scuthnweb.action.useradminmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.UserAdminModule;

public class UserIDLogOutAction extends ActionSupport{
    
	private  UserAdminModule userAdminModule;
    
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().remove("customer");
		return SUCCESS;
	}

	public UserAdminModule getUserAdminModule() {
		return userAdminModule;
	}

	public void setUserAdminModule(UserAdminModule userAdminModule) {
		this.userAdminModule = userAdminModule;
	}
    
}
