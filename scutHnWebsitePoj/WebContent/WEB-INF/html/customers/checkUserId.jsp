<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户名查看id</title>
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
<div class="container">
    <div class="col-md-12">
        <h1 class="margin-bottom-15">用户名查看id</h1>
        <form class="form-horizontal templatemo-forgot-password-form templatemo-container" role="form" action="#" method="post">
            <div class="form-group">
                <div class="col-md-12">
                    为您找到的ID：
                </div>
               <%
                   for(Integer lst:((List<Integer>)session.getAttribute("customer_id_list")))
                	   out.print("<div class=\"col-md-12\">"+lst+"</div>");
               %>
               <div class="col-md-12">
                  <br/><h2>如果出现多个ID，表示该站内有其他同名用户，您可以尝试多个ID</h2>
               </div>
            </div>
            <div class ="copy-right">
            <a href="pfs?pagePath=/WEB-INF/html/customer options/navigationPage.jsp">用户子系统</a>
	        <a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a>
    </div>
        </form>

    </div>

</div>

</body>
</html>