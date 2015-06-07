package com.scuthnweb.action.authority;

public class CsPageAuthority {
     private  final String PREFIX="/WEB-INF/html";
     private  final String[] str = { PREFIX + "/customers/checkUserInfo.jsp",
    		                         PREFIX + "/customers/modifyUserInfo.jsp"};
     
     public  boolean isInCsAuthority(String page){
           	for(String itr:str)
           		if(itr.equals(page)) 
           			return true;
           	return false;
     }
}
