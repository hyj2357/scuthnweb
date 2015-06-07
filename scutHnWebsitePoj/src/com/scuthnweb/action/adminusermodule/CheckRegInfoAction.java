package com.scuthnweb.action.adminusermodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.AdminUserModule;

public class CheckRegInfoAction extends ActionSupport{
	
	private AdminUserModule adminUserModule;
	private int id;
    
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("regCustomer", this.adminUserModule.checkRegInfo(id));
        return SUCCESS;	
    }
	
	public AdminUserModule getAdminUserModule() {
		return adminUserModule;
	}

	public void setAdminUserModule(AdminUserModule adminUserModule) {
		this.adminUserModule = adminUserModule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
