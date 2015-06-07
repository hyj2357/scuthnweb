package com.scuthnweb.action.authority;

import com.opensymphony.xwork2.ActionSupport;

public class PageForwardServlet extends ActionSupport{
    private String pagePath;
    
    public String execute(){
    	return pagePath;
    }

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}
    
}
