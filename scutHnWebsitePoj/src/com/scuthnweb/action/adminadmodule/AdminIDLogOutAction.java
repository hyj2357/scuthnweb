package com.scuthnweb.action.adminadmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminIDLogOutAction extends ActionSupport{
     public String execute(){
    	 ActionContext ctx = ActionContext.getContext();
    	 ctx.getSession().remove("admin");
    	 return SUCCESS;
     }
}
