<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>消息内容</title>
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
       <div>
        <h1 class="margin-bottom-15">消息内容</h1>       
       <div>
       <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="#" method="post">
             <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                    <%  
                        out.print("<input type=\"text\" readonly=\"true\" class=\"form-control\" value="+
                                   ((Message)session.getAttribute("message")).getMessage_title()
                                  +"/>");
                    %>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                    <%     out.print("<textarea class=\"form-control\" readonly=\"true\" rows=\"8\" cols=\"50\">"+
                           ((Message)session.getAttribute("message")).getMessage_content() +"</textarea>");
                    %>
                    </div>
                </div>
            </div>  
            <hr>
        </form>
    </div>
</div>          
<p><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></p>
<p><a href="pfs?pagePath=/WEB-INF/html/customer options/navigationPage.jsp">返回用户子系统</a></p>
<p><a href="pfs?pagePath=/WEB-INF/html/adminSS/adminSubSystem.jsp">返回管理员子系统</a></p>
</body>
</html>