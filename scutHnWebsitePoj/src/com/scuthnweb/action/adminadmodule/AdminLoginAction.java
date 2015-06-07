package com.scuthnweb.action.adminadmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.interf.AdminAdModule;

public class AdminLoginAction extends ActionSupport{
	
	private int admin_id;
	private String admin_password;
    private AdminAdModule adminAdModule;
   
    public String execute(){
    	BaseCustomer admin = adminAdModule.adminLogin(admin_id, admin_password);
        if(admin==null) 
        	return ERROR;
        else{
        	ActionContext ctx = ActionContext.getContext();
        	ctx.getSession().put("admin", admin);
            return SUCCESS;
        }
    }
	public AdminAdModule getAdminAdModule() {
		return adminAdModule;
	}

	public void setAdminAdModule(AdminAdModule adminAdModule) {
		this.adminAdModule = adminAdModule;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
    
}
