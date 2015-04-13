package com.scuthnweb.testforward;

import com.opensymphony.xwork2.ActionSupport;

public class ActModuleTestAction extends ActionSupport{
    private String pageName;
    private final String  CHECKALLACT = "checkAllAct",
    		              CHECKPUBLISH = "checkPublish",
    		              CHECKTAKEPARTIN = "checkTakePartIn",
    		              CHECKTAKEPARTINUSERINFO = "checkTakePartInUserInfo",
    		              CREATEACT = "createAct",
    		              DELETEACT = "deleteAct",
    		              EXITACT = "exitAct",
    		              MODIFYACT = "modifyAct",
    		              OFFLINEACT="offLineAct",
    		              ONLINEACT = "onLineAct",
    		              TAKEPARTINACT = "takePartInAct";
     
    public String execute(){
		 return this.pageName;
     }
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
     
                    
}
