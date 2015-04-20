package com.scuthnweb.action.reslinkmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.interf.ResLinkModule;

public class Op_linkAction extends ActionSupport{
    
	private ResLinkModule resLinkModule;	
    private ActionContext ctx;
	private int opCode;
	
    public String execute(){
        boolean accept = (opCode==0)?true:false;
        if(this.resLinkModule.op_link((Share_link)ctx.getSession().get("resLink"), (Admin)ctx.getSession().get("admin"), accept))
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

	public int getOpCode() {
		return opCode;
	}

	public void setOpCode(int opCode) {
		this.opCode = opCode;
	}
}
