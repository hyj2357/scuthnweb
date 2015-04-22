package com.scuthnweb.action.needmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Need;
import com.scuthnweb.service.interf.NeedModule;

public class DelNeedAction extends ActionSupport{
    
	private NeedModule needModule;	
    private ActionContext ctx;
	
    public String execute(){
    	Need need = (Need)ctx.getSession().get("need");
    	BaseCustomer bs = (BaseCustomer)ctx.getSession().get("customer");
    	if(bs==null)
    		bs = (BaseCustomer)ctx.getSession().get("admin");
    	if(this.needModule.delNeed(need, bs))
    		return SUCCESS;
    	return ERROR;
    }

}
