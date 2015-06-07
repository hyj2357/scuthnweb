<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.scuthnweb.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>登录列表</title>
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
	<h1>用户列表</h1>
    <h2></h2>
	<div class="container center-block templatemo-form-list-container templatemo-container">
		<div class="col-md-12">		
		<table class="table table-striped table-hover">
	      <thead>
	        <tr>
	          <th>申请注册用户列表</th>
	        </tr>
	      </thead>
	      <% 
	      Map<String,String> regMap = (Map<String,String>)session.getAttribute("regMap");
	      Set<String> itrSet = regMap.keySet();
	      for(String itr:itrSet){
	      out.print("<tbody><tr><td><a href=\"#\">"+itr+"</a></td>"+"<td class=\"text-right\"><a href=\""+(String)regMap.get(itr)+"\" class=\"btn btn-info\">点击查看详细注册信息</a></td></tr></tbody><tbody>");
	      }
	      %>	        
	    </table>
		</div>
	</div>
</body>
</html>