package com.scuthnweb.action.reslinkmodule;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.ResLinkModule;
import com.scuthnweb.service.interf.UserAdminModule;

public class CheckAllResLinkAction extends ActionSupport{
    
	private ResLinkModule resLinkModule;	
    private ActionContext ctx;
	
	public String execute(){
    	Map<String,String> resLinkMap = this.resLinkModule.checkAllResLink(ctx.getSession().get("admin")!=null);
    	ctx.getSession().put("resLinkMap", resLinkMap);
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
