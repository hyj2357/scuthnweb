package com.scuthnweb.action.useradminmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.UserAdminModule;

public class UserFindIDAction extends ActionSupport{
     
	 private  UserAdminModule userAdminModule;
     private  String name;
     
     public String execute(){
    	ActionContext ctx = ActionContext.getContext();
    	ctx.getSession().put("customer_id_list", this.userAdminModule.userFindID(name));
        return SUCCESS;
     }

	public UserAdminModule getUserAdminModule() {
		return userAdminModule;
	}

	public void setUserAdminModule(UserAdminModule userAdminModule) {
		this.userAdminModule = userAdminModule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
     
}
