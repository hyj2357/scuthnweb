package com.scuthnweb.action.useradminmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.interf.UserAdminModule;

public class UserIDLoginAction extends ActionSupport{
    
	private  UserAdminModule userAdminModule;
    private  int id;
    private  String customer_password;
    
    public String execute(){
       ActionContext ctx = ActionContext.getContext();
       BaseCustomer cs = (BaseCustomer)this.userAdminModule.userIDLogin(id, customer_password);
       if(cs==null)
    	   return ERROR;
       else {
    	   ctx.getSession().put("customer", cs);
    	   return SUCCESS;
       }
    }

	public UserAdminModule getUserAdminModule() {
		return userAdminModule;
	}

	public void setUserAdminModule(UserAdminModule userAdminModule) {
		this.userAdminModule = userAdminModule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}    
}
