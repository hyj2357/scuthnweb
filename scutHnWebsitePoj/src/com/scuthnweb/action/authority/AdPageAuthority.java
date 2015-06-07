package com.scuthnweb.action.authority;

public class AdPageAuthority {
    private  final String PREFIX="/WEB-INF/html";
    private  final String[] str = { PREFIX + "/admin/adminCheckUserInfo.jsp",
   		                            PREFIX + "/admin/checkAllRegCustomer.jsp",
   		                            PREFIX + "/admin/modifyNote.jsp",
   		                            PREFIX + "/admin/modifyPassword.jsp",
   		                            PREFIX + "/admin/postNote.jsp",
   		                            PREFIX + "/admin/setName.jsp",
   		                            PREFIX + "/admin/verifyResLink.jsp",
   		                            PREFIX + "/admin/adminCheckRegUserInfo.jsp",
   		                            
   		                            PREFIX + "/action/createAction.jsp"
   		                           };
    
    public  boolean isInAdAuthority(String page){
          	for(String itr:str)
          		if(itr.equals(page)) 
          			return true;
          	return false;
    }
}
