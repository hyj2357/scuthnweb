package com.scuthnweb.action.useradminmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.UserAdminModule;

public class UserFindPasswordAction extends ActionSupport{
    
	private  UserAdminModule userAdminModule;
    private  String customer_email;
    private  int customer_id;
    
    public String execute(){
       if(this.userAdminModule.userFindPassword(customer_id, customer_email))
    	   return SUCCESS;
       else return ERROR;
    }

	public UserAdminModule getUserAdminModule() {
		return userAdminModule;
	}

	public void setUserAdminModule(UserAdminModule userAdminModule) {
		this.userAdminModule = userAdminModule;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
    
}
