package com.scuthnweb.action.authority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class EventInterceptor extends AbstractInterceptor implements ResultType{
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();		
		if(session.getAttribute("event")==null)
			return EVENT_ERROR;
		return invocation.invoke();
	}
	

}
