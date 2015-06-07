package com.scuthnweb.action.needmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.interf.NeedModule;

public class CheckPostNeedAction extends ActionSupport{
    
	private NeedModule needModule;	
    private ActionContext ctx;
	
    public String execute(){ 
    	ctx = ActionContext.getContext();
    	BaseCustomer bs = (BaseCustomer)ctx.getSession().get("customer");
    	if(bs==null)
    		bs = (BaseCustomer)ctx.getSession().get("admin");
    	//调用业务逻辑组件
    	ctx.getSession().put("needMap", this.needModule.checkPostNeed(bs));
    	return SUCCESS;
    }

	public NeedModule getNeedModule() {
		return needModule;
	}

	public void setNeedModule(NeedModule needModule) {
		this.needModule = needModule;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}

}
