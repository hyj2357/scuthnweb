package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Event;
import com.scuthnweb.service.interf.ActModule;

public class OffLineActAction extends ActionSupport{
     
	 private ActModule actModule;
     
     public String execute(){
    	 ActionContext ctx = ActionContext.getContext();
    	 Admin ad = (Admin)ctx.getSession().get("admin");
    	 Event evt = (Event)ctx.getSession().get("event");
    	 if(ad==null||evt==null) 
    		 return ERROR;    	
    	 if(!this.actModule.offLineAct(evt, ad))
    		 return ERROR;
    	 return SUCCESS;
     }

	public ActModule getActModule() {
		return actModule;
	}

	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}
     
}
