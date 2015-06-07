package com.scuthnweb.action.authority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PageInterceptor extends AbstractInterceptor implements ResultType{
    private CsPageAuthority csAuthorityPage;
    private AdPageAuthority adAuthorityPage;
    
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//查看当前在线用户账号类型
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
        int i = session.getAttribute("admin")!=null?1:
        	   (session.getAttribute("customer")!=null?2:0);
        //获取当前用户所请求的界面
        String page = request.getParameter("pagePath");
        //判定是否拥有访问该界面的权限
        switch(i){
          case 0:if(this.csAuthorityPage.isInCsAuthority(page)||this.adAuthorityPage.isInAdAuthority(page))
        	       return BS_ERROR;break;
        	       
          case 1:if(this.csAuthorityPage.isInCsAuthority(page))
        	       return CUSTOMER_AUTHORITY_ERROR;break;
        	       
          case 2:if(this.adAuthorityPage.isInAdAuthority(page))
                   return ADMIN_AUTHORITY_ERROR;
        }
		return invocation.invoke();
	}

	public CsPageAuthority getCsAuthorityPage() {
		return csAuthorityPage;
	}

	public void setCsAuthorityPage(CsPageAuthority csAuthorityPage) {
		this.csAuthorityPage = csAuthorityPage;
	}

	public AdPageAuthority getAdAuthorityPage() {
		return adAuthorityPage;
	}

	public void setAdAuthorityPage(AdPageAuthority adAuthorityPage) {
		this.adAuthorityPage = adAuthorityPage;
	}
    
}
