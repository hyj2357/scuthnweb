package com.scuthnweb.action.useradminmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.UserAdminModule;

public class UserPasswordChangeAction extends ActionSupport{
    
	private  UserAdminModule userAdminModule;
    private  String customer_password,customer_passwordM;
    private  int customer_id;
    
	public String execute(){
		return this.userAdminModule.userPasswordChange(customer_id, customer_password, customer_passwordM)==true?
				SUCCESS:ERROR;		
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
}
