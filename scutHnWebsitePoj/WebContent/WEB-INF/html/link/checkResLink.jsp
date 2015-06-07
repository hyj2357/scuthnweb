<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>链接详情</title>
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
			<h1 class="margin-bottom-15">链接详情</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="op_linkAction" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">
		            <div class="control-wrapper">
		            	<input type="text" class="form-control" readonly＝"true" name="share_link_name" 
		            	       <%
		            	          Share_link sl = (Share_link)session.getAttribute("resLink");
		            	          out.print(" value=\""+sl.getShare_link_name()+"\" ");
		            	        %>
		            	       id="username" placeholder="标题">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
                        <textarea class="form-control" readonly＝"true" name="share_link_content" rows="8" cols="50" placeholder="链接">
                        <%
                           out.print(sl.getShare_link_content());
                         %>
                        </textarea>
		            </div>
		          </div>
		        </div>
		        <hr>
		        <%
		         //该界面也做审核链接界面
		         //如果当前为管理员在线
		         //则向管理员显示审核部分
		         if(session.getAttribute("admin")!=null&&sl.getShare_link_state()==2)
		        	 out.print("<h4>操作</h4><select name=\"accept\" class=\"sex\">"+  
                       "<option value =\"0\">同意该链接,同时该链接对所有人可见</option>"+
                       "<option value =\"1\">不同意该链接,同时该链接仅对发布链接者与管理员可见</option>"+
                   "</select>"+
                   "<div class=\"submit\">"+
                   "<input type=\"submit\" onclick=\"myFunction()\" value=\"确认\" >"+
                "</div>");
                %>
                <%
      	        if(((Integer)session.getAttribute("link_pub_state"))==0)
      	    	   out.print("<p><a href=\"pfs?pagePath=/WEB-INF/html/link/updateResLink.jsp\">修改该链接</a></p>");
                %>
		    </form>
		</div>
	</div>
	<div>
	    <p><a href="pfs?pagePath=/WEB-INF/html/adminSS/adminSubSystem.jsp">返回管理员子系统</a></p>	
	    <p><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></p>
	</div>
</body>
</html>