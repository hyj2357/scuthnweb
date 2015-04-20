package com.scuthnweb.action.adminusermodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.AdminUserModule;

public class CheckRegInfoAction extends ActionSupport{
	
	private AdminUserModule adminUserModule;
	private int customer_id;
    
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		ctx.put("regCustomer", this.adminUserModule.checkRegInfo(customer_id));
        return SUCCESS;	
    }
	
	public AdminUserModule getAdminUserModule() {
		return adminUserModule;
	}

	public void setAdminUserModule(AdminUserModule adminUserModule) {
		this.adminUserModule = adminUserModule;
	}
	
	
}
