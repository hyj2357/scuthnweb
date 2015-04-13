package com.scuthnweb.tools;

import java.util.HashMap;
import java.util.Map;

public class ParamTools {
	
    public static String toOneParamHref(String actionClass,String paramName,String paramValue){
    	//获取 struts中对应的 action 名
    	int i= actionClass.length()-1;
    	for(;i>=0;i--) 	
    	  if(actionClass.charAt(i)=='.') 
    		break;    		
    	String actionName = actionClass.substring(i+1, actionClass.length());
    	actionName = actionName.substring(0, 1).toLowerCase() + actionName.substring(1,actionName.length()-6);
    	return actionName + "?actionClass=" + actionClass + "&" + paramName + "=" + paramValue;
    }
    
    public static Map<String,String>getParam(String url){
    	String params[] = url.split("&");
    	Map paramsMap = new HashMap<String,String>();
    	for( String i:params)
    		paramsMap.put((i.split("="))[0], (i.split("=")[1]));
        return paramsMap;
    }
    
    public static Long toInteger(String num){
    	long sum = 0;
    	for( char i:num.toCharArray()){
    		sum*=10;
    		sum+=i-'0';
    	}
    	
    	return new Long(sum);
    }
}
