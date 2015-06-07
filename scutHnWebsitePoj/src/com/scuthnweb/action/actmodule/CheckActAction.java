package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.domain.Event;
import com.scuthnweb.domain.Event_summary;
import com.scuthnweb.service.interf.ActModule;

public class CheckActAction extends ActionSupport{
    
	private ActModule actModule;
	private int event_id;
	
	public String execute(){
		ActionContext ctx = ActionContext.getContext();
		Event evt =  this.actModule.checkAct(event_id);
		ctx.getSession().put("event",evt);
		
		Customer cs = (Customer)ctx.getSession().get("customer");
		if(cs==null){
			ctx.getSession().put("event_take_state", new Integer(-1));
			return SUCCESS;
		}
		else{
			boolean hasFound = false;
			for(Event_summary es:evt.getEvent_summary())
				if(es.getEvent_customer().getId()==cs.getId()){
					ctx.getSession().put("event_take_state", new Integer(0));
					hasFound = true;
				}
			if(!hasFound)
				ctx.getSession().put("event_take_state", new Integer(1));
		}		    
		return SUCCESS;
    }
	
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public ActModule getActModule() {
		return actModule;
	}
	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}
	
	
}
