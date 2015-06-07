package com.scuthnweb.action.adminadmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.interf.AdminAdModule;

public class ModifyPasswordAction extends ActionSupport{
    private String admin_password,admin_passwordM,confirm_password;
	private AdminAdModule adminAdModule;
    
    public String execute(){
    	ActionContext ctx = ActionContext.getContext();
    	if(adminAdModule.modifyPassword((Admin)ctx.getSession().get("admin"), admin_password, admin_passwordM))
    		 return SUCCESS;
    	else return ERROR;
    }
    
    public void validate(){
    	//校验用户密码
    	String regexPassword = "^\\w{5,20}$";
    	if( !Pattern.matches(regexPassword, String.valueOf( this.admin_passwordM )) ){
    		System.out.println(2);	    
    		    this.addFieldError("admin_passwordM", "密码由5～20个数字或英文字母组成");
    	}	
    	
    	if(!this.confirm_password.equals(this.admin_passwordM))
    		this.addFieldError("confirm_password", "新密码与确认密码不符");
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

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
     
}
