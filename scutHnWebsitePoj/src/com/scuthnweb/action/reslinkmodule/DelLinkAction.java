package com.scuthnweb.action.reslinkmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.interf.ResLinkModule;

public class DelLinkAction extends ActionSupport{
    
	private ResLinkModule resLinkModule;	
    private ActionContext ctx;
	
    public String execute(){
    	ctx = ActionContext.getContext();
    	BaseCustomer cs = (BaseCustomer)ctx.getSession().get("customer");
    	if(cs==null)
    		cs = (BaseCustomer)ctx.getSession().get("admin");
    	if(this.resLinkModule.delLink((Share_link)ctx.getSession().get("resLink"), cs)){    	    
    		//删除成功
        	//由session中移除resLink
        	ctx.getSession().remove("resLink");
        	return SUCCESS;
    	}
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
}