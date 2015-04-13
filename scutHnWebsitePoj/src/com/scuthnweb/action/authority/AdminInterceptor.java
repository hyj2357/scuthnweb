package com.scuthnweb.action.authority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor implements ResultType{  
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//如果当前没有管理员账号在登录状态
		//则返回管理员未登录错误结果
		if(session.getAttribute("admin")==null&&session.getAttribute("customer")==null)
			return ADMINERROR;
		return invocation.invoke();
	}

}
