package com.scuthnweb.action.useradminmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.interf.UserAdminModule;

public class UserInfoCheckAction extends ActionSupport{
    
	private  UserAdminModule userAdminModule;
    
	public String execute(){
		return SUCCESS;
	}

	public UserAdminModule getUserAdminModule() {
		return userAdminModule;
	}

	public void setUserAdminModule(UserAdminModule userAdminModule) {
		this.userAdminModule = userAdminModule;
	}
    
}
