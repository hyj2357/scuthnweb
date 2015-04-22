package com.scuthnweb.action.needmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.interf.NeedModule;

public class CheckAllNeedAction extends ActionSupport{
    
	private NeedModule needModule;	
    private ActionContext ctx;
	
    public String execute(){    	
    	//调用业务逻辑组件
    	ctx.getSession().put("needMap", this.needModule.checkAllNeed(ctx.getSession().get("admin")!=null));
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
