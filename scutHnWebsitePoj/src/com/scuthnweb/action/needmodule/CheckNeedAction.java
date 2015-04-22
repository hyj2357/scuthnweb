package com.scuthnweb.action.needmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.NeedModule;

public class CheckNeedAction extends ActionSupport{
    
	private NeedModule needModule;	
    private ActionContext ctx;
	private int need_id;
    
	public String execute(){    	
    	//调用业务逻辑组件
    	ctx.getSession().put("need", this.needModule.checkNeed(need_id));
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

	public int getNeed_id() {
		return need_id;
	}

	public void setNeed_id(int need_id) {
		this.need_id = need_id;
	}
}