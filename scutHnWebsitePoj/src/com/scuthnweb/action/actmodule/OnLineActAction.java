package com.scuthnweb.action.actmodule;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Event;
import com.scuthnweb.service.interf.ActModule;

public class OnLineActAction extends ActionSupport{
     private ActModule actModule;
     
     public String execute(){
    	 ActionContext ctx =  ActionContext.getContext();
    	 Admin ad  = (Admin)ctx.getSession().get("admin");
    	 Event evt = (Event)ctx.getSession().get("event");
    	 
    	 if(ad==null||evt==null)
    		 return ERROR;
    	
    	 if(evt.getEvent_time().before(new Date())||evt.getEvent_endtime().before(new Date())||evt.getEvent_time().after(evt.getEvent_endtime()))
    		return ERROR;
    		    	
    	 if(!this.actModule.onLineAct(evt, ad))
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
