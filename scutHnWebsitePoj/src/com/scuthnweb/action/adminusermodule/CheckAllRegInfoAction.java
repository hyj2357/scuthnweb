package com.scuthnweb.action.adminusermodule;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.AdminUserModule;

public class CheckAllRegInfoAction extends ActionSupport{
	
	private AdminUserModule adminUserModule;
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		Map<String,String> regMap = this.adminUserModule.checkAllRegInfo();
		ctx.getSession().put("regMap", regMap);
		return SUCCESS;
	}

	public AdminUserModule getAdminUserModule() {
		return adminUserModule;
	}

	public void setAdminUserModule(AdminUserModule adminUserModule) {
		this.adminUserModule = adminUserModule;
	}
    
}
