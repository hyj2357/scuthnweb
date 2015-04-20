package com.scuthnweb.action.reslinkmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.ResLinkModule;

public class CheckLinkAction extends ActionSupport{
    
	private ResLinkModule resLinkModule;	
    private ActionContext ctx;
	private int share_link_id;
    
    public String execute(){
    	ctx.getSession().put("resLink", this.resLinkModule.checkLink(share_link_id));
    	return SUCCESS;
    }

	public ResLinkModule getResLinkModule() {
		return resLinkModule;
	}

	public void setResLinkModule(ResLinkModule resLinkModule) {
		this.resLinkModule = resLinkModule;
	}

	public int getShare_link_id() {
		return share_link_id;
	}

	public void setShare_link_id(int share_link_id) {
		this.share_link_id = share_link_id;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}
}
