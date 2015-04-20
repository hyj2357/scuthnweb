package com.scuthnweb.action.adminusermodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.interf.AdminUserModule;

public class LogoutUserIDAction extends ActionSupport{
	
	private AdminUserModule adminUserModule;
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		Customer regCustomer = (Customer)ctx.get("regCustomer");
		this.adminUserModule.logoutUserID(regCustomer);
	    return SUCCESS;
	}

	public AdminUserModule getAdminUserModule() {
		return adminUserModule;
	}

	public void setAdminUserModule(AdminUserModule adminUserModule) {
		this.adminUserModule = adminUserModule;
	}
}
