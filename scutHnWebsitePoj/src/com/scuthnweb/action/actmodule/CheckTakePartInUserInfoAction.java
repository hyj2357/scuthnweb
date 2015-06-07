package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Event;
import com.scuthnweb.service.interf.ActModule;

public class CheckTakePartInUserInfoAction extends ActionSupport{
    
	private ActModule actModule;
    
    public String execute(){
    	ActionContext ctx = ActionContext.getContext();
    	BaseCustomer ad = (BaseCustomer)ctx.getSession().get("admin");
    	Event evt = (Event)ctx.getSession().get("event");
        if(ad==null||evt==null) 
        	return ERROR;
    	ctx.getSession().put("regMap",this.actModule.checkTakePartInUserInfo(evt.getEvent_id(), ad.getId()));
        return SUCCESS;
    }

	public ActModule getActModule() {
		return actModule;
	}

	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}    
}
