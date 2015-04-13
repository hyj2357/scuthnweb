package com.scuthnweb.action.actmodule;

import java.util.Date;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.interf.ActModule;

public class CreateActAction extends ActionSupport{
      
	private ActModule actModule;
	private String event_name, event_intro; 
	private Date event_time, event_endtime;
	private int event_maxPeople;
	
    public String execute(){
    	ActionContext ctx = ActionContext.getContext();
    	Admin event_publisher = (Admin)ctx.getSession().get("admin");
    	if(event_publisher==null)
    		return ERROR;
    	if(!this.actModule.createAct(event_name, event_intro, event_time, event_endtime, event_maxPeople, event_publisher, 1))
    		return ERROR;
        return SUCCESS;
    }
    
    public void validate(){
    	String regexName = "^(([\\u4E00-\\u9FA5]|\\w){2,50})$";
	    if( !Pattern.matches(regexName, this.event_name))
			    this.addFieldError("event_name","活动名称应由长度2～50的简体中文，英文字母或数字组成");
	    
	    String regexIntro = "^(([\\u4E00-\\u9FA5]|\\w){10,8000})$";
	    if( !Pattern.matches(regexName, this.event_name))
			    this.addFieldError("event_name","活动介绍应由长度10～8000的简体中文，英文字母或数字组成");
	    
		if(event_maxPeople>1000)
			this.addFieldError("event_maxPeople", "最大参与人数不能超过1000");
		
		if(this.event_time.before(new Date()))
			this.addFieldError("event_time", "活动时间不能处于当前时间之前");
		
		if(this.event_endtime.before(new Date()))
			this.addFieldError("event_endtime", "活动结束时间不能处于当前时间之前");
		
		if(this.event_time.after(event_endtime))
		    this.addFieldError("event_time", "活动时间不能处于结束时间之前");
		    
	}
	public ActModule getActModule() {
		return actModule;
	}

	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_intro() {
		return event_intro;
	}
	public void setEvent_intro(String event_intro) {
		this.event_intro = event_intro;
	}
	public Date getEvent_time() {
		return event_time;
	}
	public void setEvent_time(Date event_time) {
		this.event_time = event_time;
	}
	public Date getEvent_endtime() {
		return event_endtime;
	}
	public void setEvent_endtime(Date event_endtime) {
		this.event_endtime = event_endtime;
	}
	public int getEvent_maxPeople() {
		return event_maxPeople;
	}
	public void setEvent_maxPeople(int event_maxPeople) {
		this.event_maxPeople = event_maxPeople;
	}    
}
