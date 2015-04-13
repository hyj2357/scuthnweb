package com.scuthnweb.action.authority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Customer;

public class BaseCustomerAuthority extends AbstractInterceptor implements ResultType{
    
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = (HttpSession)request.getSession();
		BaseCustomer bs = (BaseCustomer) session.getAttribute("admin");
		
		if(bs==null){
			bs = (BaseCustomer) session.getAttribute("customer");	
		    if(((Customer)bs).getCustomer_state()==1)
		    	return CUSTOMERAUTHORITY;
		}
		else{
			if(((Admin)bs).getAdmin_state()==1)
			   return ADMINAUTHORITY;
		}
		return invocation.invoke();
	}	 
}
