package com.scuthnweb.action.messagemodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.MessageModule;

public class CheckMessageAction extends ActionSupport{
    
	private MessageModule messageModule;	
    private ActionContext ctx;
	private int message_id;
    
    public String execute(){
    	ctx.getSession().put("message", this.messageModule.checkMessage(message_id));
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

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
    
}
