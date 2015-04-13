package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.interf.ActModule;

public class CheckPublishAction extends ActionSupport{
	private ActModule actModule;
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		Admin ad =  (Admin)ctx.getSession().get("admin");
		if(ad==null) 
			return ERROR;
		ctx.getSession().put("event_map", this.actModule.checkPublish(ad.getId()));
		return SUCCESS;
	}

	public ActModule getActModule() {
		return actModule;
	}

	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}
    
}
