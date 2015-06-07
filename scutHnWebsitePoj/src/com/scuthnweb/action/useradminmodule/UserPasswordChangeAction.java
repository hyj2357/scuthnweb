package com.scuthnweb.action.useradminmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.UserAdminModule;

public class UserPasswordChangeAction extends ActionSupport{
    
	private  UserAdminModule userAdminModule;
    private  String customer_password,customer_passwordM,confirm_password;
    private  int customer_id;
    
	public String execute(){
		return this.userAdminModule.userPasswordChange(customer_id, customer_password, customer_passwordM)==true?
				SUCCESS:ERROR;		
	}
	
	public void validate(){
	    if(!this.customer_passwordM.equals(this.confirm_password))
	    	this.addFieldError("confirm_password", "确认密码与新密码不匹配");
	}
	
	public UserAdminModule getUserAdminModule() {
		return userAdminModule;
	}
	public void setUserAdminModule(UserAdminModule userAdminModule) {
		this.userAdminModule = userAdminModule;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	public String getCustomer_passwordM() {
		return customer_passwordM;
	}
	public void setCustomer_passwordM(String customer_passwordM) {
		this.customer_passwordM = customer_passwordM;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
}
