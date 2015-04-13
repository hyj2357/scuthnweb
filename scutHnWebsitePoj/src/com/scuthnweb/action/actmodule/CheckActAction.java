package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.ActModule;

public class CheckActAction extends ActionSupport{
    
	private ActModule actModule;
	private int event_id;
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("event", this.actModule.checkAct(event_id));
		return SUCCESS;
    }
	
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public ActModule getActModule() {
		return actModule;
	}
	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}
	
	
}
