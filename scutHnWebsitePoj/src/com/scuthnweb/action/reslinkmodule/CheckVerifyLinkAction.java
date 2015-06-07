package com.scuthnweb.action.reslinkmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.ResLinkModule;

public class CheckVerifyLinkAction extends ActionSupport{
    
	private ResLinkModule resLinkModule;
	private ActionContext ctx;
    
    public String execute(){
    	ActionContext ctx = ActionContext.getContext();
        ctx.getSession().put("resLinkMap", this.resLinkModule.checkVerifyLink());	
        return SUCCESS;
    }
      
	public ResLinkModule getResLinkModule() {
		return resLinkModule;
	}
	public void setResLinkModule(ResLinkModule resLinkModule) {
		this.resLinkModule = resLinkModule;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}
      
} 
