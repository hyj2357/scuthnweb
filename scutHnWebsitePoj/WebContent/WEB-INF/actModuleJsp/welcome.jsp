<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>成功页面</title>
    </head>
    <body>
        活动Action成功!
        <a href="javascript:window.location.href='/WEB-INF/actModuleJsp/welcome.jsp'">for test</a>
        <s:property value="tip"/>
    </body>
</html>
