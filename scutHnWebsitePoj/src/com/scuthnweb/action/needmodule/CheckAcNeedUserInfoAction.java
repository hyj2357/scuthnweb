package com.scuthnweb.action.needmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Need;
import com.scuthnweb.service.interf.NeedModule;

public class CheckAcNeedUserInfoAction extends ActionSupport{
    
	private NeedModule needModule;	
    private ActionContext ctx;
	
    public String execute(){  
    	Need need = (Need)ctx.getSession().get("need");
    	BaseCustomer bs = (BaseCustomer)ctx.getSession().get("customer");
    	if(bs==null)
    		bs = (BaseCustomer)ctx.getSession().get("admin");
    	//调用业务逻辑组件
    	ctx.getSession().put("customerMap", this.needModule.checkAcNeedUserInfo(need, bs));
    	return SUCCESS;
    }

}
