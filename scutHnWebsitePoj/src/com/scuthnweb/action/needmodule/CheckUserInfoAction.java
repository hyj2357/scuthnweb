package com.scuthnweb.action.needmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.interf.NeedModule;

public class CheckUserInfoAction extends ActionSupport{
    
	private NeedModule needModule;	
    private ActionContext ctx;
	private int id;
    
	public String execute(){ 
		ctx = ActionContext.getContext();
    	//调用业务逻辑组件
    	ctx.getSession().put("regCustomer", this.needModule.checkUserInfo(id));
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}