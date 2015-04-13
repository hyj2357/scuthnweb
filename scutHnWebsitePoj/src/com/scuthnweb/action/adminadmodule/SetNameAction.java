package com.scuthnweb.action.adminadmodule;

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