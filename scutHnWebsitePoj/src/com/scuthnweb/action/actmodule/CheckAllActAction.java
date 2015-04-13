package com.scuthnweb.action.actmodule;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.ActModule;

public class CheckAllActAction extends ActionSupport{
     private ActModule actModule;
     
     public String execute(){
    	 ActionContext ctx =  ActionContext.getContext();
    	 Map event_map = this.actModule.checkAllAct(ctx.getSession().get("admin")!=null);
    	 ctx.getSession().put("event_map",event_map);
    	 return SUCCESS;
     }

	public ActModule getActModule() {
		return actModule;
	}

	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}
}
