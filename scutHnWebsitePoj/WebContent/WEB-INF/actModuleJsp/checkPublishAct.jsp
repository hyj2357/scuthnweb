<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ page import="java.util.*" %>>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>�ɹ�ҳ��</title>
    </head>
    <body>
        �Action�ɹ�!
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
