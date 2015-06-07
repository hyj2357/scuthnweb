package com.scuthnweb.action.adminadmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.interf.AdminAdModule;

public class SetNameAction extends ActionSupport{
   private String admin_nameM;
   private AdminAdModule adminAdModule;
   
   public String execute(){
	  ActionContext ctx = ActionContext.getContext();
	  adminAdModule.setName((Admin)ctx.getSession().get("admin"), admin_nameM);
	  return SUCCESS;
   }
   public void validate(){
	   String regexName = "^([\\u4E00-\\u9FA5]{2,4})$";
	    if( !Pattern.matches(regexName, this.admin_nameM)){
	    	System.out.println(1);
			    this.addFieldError("customer_name","用户姓名必须由2～4个简体中文字符组成");
	    }
   }
   public AdminAdModule getAdminAdModule() {
	 return adminAdModule;
   }
   public void setAdminAdModule(AdminAdModule adminAdModule) {
	 this.adminAdModule = adminAdModule;
   }

   public String getAdmin_nameM() {
	 return admin_nameM;
   }

   public void setAdmin_nameM(String admin_nameM) {
	 this.admin_nameM = admin_nameM;
   }   
}