package com.scuthnweb.action.messagemodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.interf.MessageModule;

public class CheckPublisherMessagesAction extends ActionSupport{
    
	private MessageModule messageModule;	
    private ActionContext ctx;
	
    public String execute(){
    	ctx = ActionContext.getContext();
    	BaseCustomer cs = (BaseCustomer)ctx.getSession().get("customer");
    	if(cs==null)
    		cs  = (BaseCustomer)ctx.getSession().get("admin");
    	ctx.getSession().put("messageMap", this.messageModule.checkPublishMessages(cs.getId()));
        return SUCCESS;
    }

	public MessageModule getMessageModule() {
		return messageModule;
	}

	public void setMessageModule(MessageModule messageModule) {
		this.messageModule = messageModule;
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}
}
