<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>需求列表</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="css/form%20frame/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/form%20frame/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-gray">
	<h1>需求列表</h1>
    <h2></h2>
	<div class="container center-block templatemo-form-list-container templatemo-container">
		<div class="col-md-12">		
		<table class="table table-striped table-hover">
	      <thead>
	        <tr>
	          <th>需求标题</th>
	        </tr>
	      </thead>
	
	           <% 
	 	       
		           Map<String,String> needMap = (Map<String,String>)session.getAttribute("needMap");
		           Set<String> itrSet = needMap.keySet();
		           for(String itr:itrSet)
		               out.print("<tbody><tr><td><a href=\"#\">"+itr+"</a></td>"+"<td class=\"text-right\"><a href=\""+(String)needMap.get(itr)+"\" class=\"btn btn-info\">查看需求</a></td></tr></tbody>");		           
	            %>          
	    </table>
		</div>
	</div>
	<div>
	    <p><a href="pfs?pagePath=/WEB-INF/html/adminSS/adminSubSystem.jsp">返回管理员子系统</a></p>	
	    <p><a href="pfs?pagePath=/WEB-INF/html/customer options/navigationPage.jsp">返回用户子系统</a></p>		    
	    <p><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></p>
	</div>	
</body>
</html>