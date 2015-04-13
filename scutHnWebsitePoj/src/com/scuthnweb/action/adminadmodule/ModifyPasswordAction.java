package com.scuthnweb.action.adminadmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.interf.AdminAdModule;

public class ModifyPasswordAction extends ActionSupport{
    private String admin_password,admin_passwordM;
	private AdminAdModule adminAdModule;
    
    public String execute(){
    	ActionContext ctx = ActionContext.getContext();
    	if(adminAdModule.modifyPassword((Admin)ctx.getSession().get("admin"), admin_password, admin_passwordM))
    		 return SUCCESS;
    	else return ERROR;
    }
    
	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_passwordM() {
		return admin_passwordM;
	}

	public void setAdmin_passwordM(String admin_passwordM) {
		this.admin_passwordM = admin_passwordM;
	}

	public AdminAdModule getAdminAdModule() {
		return adminAdModule;
	}

	public void setAdminAdModule(AdminAdModule adminAdModule) {
		this.adminAdModule = adminAdModule;
	}
     
}
