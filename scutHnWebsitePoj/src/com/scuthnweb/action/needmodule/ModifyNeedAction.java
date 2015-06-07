package com.scuthnweb.action.needmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Need;
import com.scuthnweb.service.interf.NeedModule;

public class ModifyNeedAction extends ActionSupport{
    
	private NeedModule needModule;	
    private ActionContext ctx;
	private String need_name,need_content;
    
    public String execute(){
    	ctx = ActionContext.getContext();
    	Need need = (Need)ctx.getSession().get("need");
    	BaseCustomer bs = (BaseCustomer)ctx.getSession().get("customer");
    	if(bs==null)
    		bs = (BaseCustomer)ctx.getSession().get("admin");
    	if(this.needModule.modifyNeed(need, bs, need_name, need_content))
    		return SUCCESS;
    	return ERROR;
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

	public String getNeed_name() {
		return need_name;
	}

	public void setNeed_name(String need_name) {
		this.need_name = need_name;
	}

	public String getNeed_content() {
		return need_content;
	}

	public void setNeed_content(String need_content) {
		this.need_content = need_content;
	}
}
