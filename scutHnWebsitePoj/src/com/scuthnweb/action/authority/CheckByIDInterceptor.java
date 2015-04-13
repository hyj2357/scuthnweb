package com.scuthnweb.action.authority;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.scuthnweb.tools.ParamTools;
public class CheckByIDInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	
		HttpServletRequest request = ServletActionContext.getRequest();		
		//获取请求串中对应的请求参数及其对应的值的映射
		Map<String,String> toMap = ParamTools.getParam(request.getQueryString());
		//获得相应的键与值
		//并由此合成对应 action 的相关属性值的 setter 方法
		String setMem_id = "set", value = "", key="";
		for( Iterator<String> i=toMap.keySet().iterator();i.hasNext();){
			key = i.next();
			if( (key.substring(key.length()-2, key.length())).equals("id")){
				setMem_id += key.toUpperCase().charAt(0) + key.toLowerCase().substring(1);
			    value     =  toMap.get(key);
			    break;
			}
		}		
		//获取转发的 action 的 class 类
		//由此获得 action 中的对应 setter 方法的 method 对象
		Class cl = Class.forName(toMap.get("actionClass"));
		 if( cl!=null){
		   Method methods[] = cl.getDeclaredMethods();
		   Method mt = null;
		   for( Method m: methods){
			 if(m.getName().equals(setMem_id)){
				mt = m;
				break;
			 }
		   }		 
		   //获取转发的action实例
		   //调用对应的setter方法设置参数
		   Object mc = null;		  
		   if(mt!=null){
		   	 mc = cl.newInstance();
		     int mem_id = ParamTools.toInteger(value).intValue();
             mt.invoke(mc, mem_id);
		   }		  
	       //替换掉原有初始化好的 action 
	       //换上已经设置好参数的 action
           Object toReplace = invocation.getAction();
	       toReplace = mc;
		 }		 		
		 //执行相关转发的 action 的 execute 方法
		 return invocation.invoke();
	}
}