package com.scuthnweb.action.authority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.scuthnweb.domain.Admin;

public class AdminAuthority  extends AbstractInterceptor implements ResultType{
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//如果当前管理员账号没有相应权限
		//则返回管理员无权限错误结果
		if(((Admin)session.getAttribute("admin")).getAdmin_state()==1)
			return ADMIN_AUTHORITY_ERROR;
		return invocation.invoke();
	}

}
