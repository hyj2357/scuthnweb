package com.scuthnweb.action.adminadmodule;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.RequestMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.interf.AdminAdModule;
/**
 * 这是用来测试框架整合效果的 action
 * @author mac
 *
 */
public class AddAdmin_testAction extends ActionSupport{
     private String admin_name;
     private String admin_password;
     public AdminAdModule adminAdModule;
     
     public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public void setAdminAdModule(AdminAdModule adminAdModule) {
		this.adminAdModule = adminAdModule;
	}

	public String execute(){
       ActionContext ctx = 	ActionContext.getContext();
       String str = (String)ServletActionContext.getRequest().getAttribute("de");
       System.out.println(ServletActionContext.getRequest().getCharacterEncoding());
       ctx.getSession().put("admin", this.adminAdModule.addAdmin_test(admin_name, admin_password));
       return SUCCESS;
	}
}
