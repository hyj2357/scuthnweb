package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Event;
import com.scuthnweb.service.interf.ActModule;

public class DeleteActAction extends ActionSupport{
    
	private ActModule actModule;
    
    public String execute(){
    	ActionContext ctx = ActionContext.getContext();
    	Event evt = (Event)ctx.getSession().get("event");
    	Admin ad = (Admin)ctx.getSession().get("admin");
    	if(evt==null||ad==null)
    		return ERROR;
    	if(!this.actModule.deleteAct(evt, ad))
    		return ERROR;
    	//删除成功
    	//由session中移除活动
    	ctx.getSession().remove("act");
    	return SUCCESS;
    }

	public ActModule getActModule() {
		return actModule;
	}

	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}
    
}
