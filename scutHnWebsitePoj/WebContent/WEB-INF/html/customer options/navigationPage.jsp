<%@ page language="java" import="com.scuthnweb.domain.*" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	          <td>活动列表</td>
	          <td class="text-right"><a href="pfs?pagePath=/WEB-INF/html/customer options/actionNavigationPage.jsp" class="btn btn-info"><i class="fa">=></i></a></td>
	        </tr>
	        <tr>
	          <td>2</td>
	          <td>需求管理</td>
	          <td class="text-right"><a href="pfs?pagePath=/WEB-INF/html/customer options/needNavigationPage.jsp" class="btn btn-info"><i class="fa">=></i></a></td>
	        </tr>	        
			<tr>
	          <td>3</td>
	          <td>资源链接管理</td>
	          <td class="text-right"><a href="pfs?pagePath=/WEB-INF/html/customer options/resLinkNavigationPage.jsp" class="btn btn-info"><i class="fa">=></i></a></td>
	        </tr>            	        
			<tr>
	          <td>4</td>
	          <td>消息管理</td>
	          <td class="text-right"><a href="pfs?pagePath=/WEB-INF/html/customer options/messageNavigationPage.jsp" class="btn btn-info"><i class="fa">=></i></a></td>
	        </tr>            	        
	        <tr>
	          <td>9</td>
	          <td>个人信息中心</td>
	          <td class="text-right"><a href="pfs?pagePath=/WEB-INF/html/customers/checkUserInfo.jsp" class="btn btn-info"><i class="fa">=></i></a></td>
	        </tr>
	        <tr>
	          <td></td>
	          <td><h3>忘记ID？点击这里</h3></td>
	          <td class="text-right"><a href="pfs?pagePath=/WEB-INF/html/customers/userFindIdByName.jsp" class="btn btn-info"><i class="fa">=></i></a></td>
	        </tr>
	      </tbody>
	    </table>
            <div><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></div>
		</div>
	</div>
</body>
