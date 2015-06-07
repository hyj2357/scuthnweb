<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>导航</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="css/form%20frame/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/form%20frame/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body>
<body class="templatemo-bg-gray">
	  <nav class="top-nav">
		<ul class="top-nav">
		<!-- 条件判断状态栏 -->
								    <%
								        int i=session.getAttribute("admin")!=null?1:(session.getAttribute("customer")!=null?2:0);
								        switch(i){
								        case 0:{out.print("<li><a href=\"pfs?pagePath=/WEB-INF/html/index/loginIndex.jsp\" >登陆</a></li>");
						                        out.print("<li><a href=\"pfs?pagePath=/WEB-INF/html/customers/findUserPassword.jsp\" >找回密码</a></li>");};break;
						          
								          case 1:{out.print("<li><a href=\"pfs?pagePath=/WEB-INF/html/adminSS/adminSubSystem.jsp\" >"+((BaseCustomer)session.getAttribute("admin")).getName()+"</a></li>");
								                  out.print("<li><a href=\"adminIDLogOutAction\" >"+"退出"+"</a></li>");}break;
								          
								          case 2:{out.print("<li><a href=\"pfs?pagePath=/WEB-INF/html/customer options/navigationPage.jsp\" >"+((BaseCustomer)session.getAttribute("customer")).getName()+"</a></li>");	
						                          out.print("<li><a href=\"userIDLogOutAction\" >"+"退出"+"</a></li>");}
								          }
								    %>
		    <li><a href="pfs?pagePath=/WEB-INF/customers/userRegist.jsp" >注册</a></li>
		</ul>
	</nav>
	<h1>用户子系统</h1>
    <h2></h2>
	<div class="container center-block templatemo-form-list-container templatemo-container">
		<div class="col-md-12">		
		<table class="table table-striped table-hover">
	      <thead>
	        <tr>
	          <th>#</th>
	          <th>操作名称</th>
	          <th class="text-right">GO</th>
	        </tr>
	      </thead>
	      <tbody>	        
	        <tr>
	          <td>1</td>
	          <td>上传链接</td>
	          <td class="text-right"><a href="pfs?pagePath=/WEB-INF/html/link/postResLink.jsp" class="btn btn-info"><i class="fa">=></i></a></td>
	        </tr>
	        <tr>
	          <td>2</td>
	          <td>链接列表</td>
	          <td class="text-right"><a href="checkAllResLinkAction" class="btn btn-info"><i class="fa">=></i></a></td>
	        </tr>
	         <tr>
	          <td>3</td>
	          <td>查看个人上传链接列表</td>
	          <td class="text-right"><a href="checkUploadLinkAction" class="btn btn-info"><i class="fa">=></i></a></td>
	        </tr>	        
	      </tbody>
	    </table>
            <div><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></div>
		    <div><a href="pfs?pagePath=/WEB-INF/html/customer options/navigationPage.jsp">返回用户子系统</a></div>
		</div>
	</div>
</body>
</html>