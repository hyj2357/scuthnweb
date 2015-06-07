package com.scuthnweb.action.adminusermodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.AdminUserModule;

public class CheckAllUserInfoAction extends ActionSupport{
	 private AdminUserModule adminUserModule;
	 
	 public String execute(){
		 ActionContext ctx = ActionContext.getContext();
		 ctx.getSession().put("regMap", this.adminUserModule.checkAllUserInfo());
		 return SUCCESS;
	 }

	public AdminUserModule getAdminUserModule() {
		return adminUserModule;
	}

	public void setAdminUserModule(AdminUserModule adminUserModule) {
		this.adminUserModule = adminUserModule;
	}

}
