package com.scuthnweb.action.reslinkmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.interf.ResLinkModule;

public class UploadLinkAction extends ActionSupport{
    
	private ResLinkModule resLinkModule;	
    private ActionContext ctx;
    private String share_link_name, share_link_content;
	
    public String execute(){
    	BaseCustomer cs = (BaseCustomer)ctx.getSession().get("customer");
    	if(cs==null)
    		cs = (BaseCustomer)ctx.getSession().get("admin");
    	if(this.resLinkModule.uploadLink( cs, share_link_name, share_link_content))
    		return SUCCESS;
    	return ERROR;
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

	public String getShare_link_name() {
		return share_link_name;
	}

	public void setShare_link_name(String share_link_name) {
		this.share_link_name = share_link_name;
	}

	public String getShare_link_content() {
		return share_link_content;
	}

	public void setShare_link_content(String share_link_content) {
		this.share_link_content = share_link_content;
	}
    
}
