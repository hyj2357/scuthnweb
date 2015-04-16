<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ page import="java.util.*" %>>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>成功页面</title>
    </head>
    <body>
        活动Action成功!
        <%
          Map map = (Map)session.getAttribute("event_map");
           Set ks = map.keySet();          
           Iterator itr=ks.iterator();
           
           for(;itr.hasNext();){
        	   String key = (String)itr.next();
        	  out.println(key+":"+map.get(key)+"<br/>");                  
          }
         %>
         
         <s:debug/>
        <s:property value="tip"/>
    </body>
</html>
