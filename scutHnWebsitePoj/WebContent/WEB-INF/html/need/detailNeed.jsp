<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>需求详情</title>
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
			<h1 class="margin-bottom-15">需求详情</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="op_linkAction" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">
		            <div class="control-wrapper">
		            	<input type="text" class="form-control" readonly＝"true" name="share_link_name" 
		            	       <%
		            	          Need nd = (Need)session.getAttribute("need");
		            	          out.print(" value=\""+nd.getNeed_name()+"\" ");
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
                           out.print(nd.getNeed_content());
                         %>
                        </textarea>
		            </div>
		          </div>
		        </div>
                <div class="control-wrapper">
                   <%
		           if(session.getAttribute("customer")!=null||session.getAttribute("admin")!=null){
		             if(((Integer)session.getAttribute("need_pub_state"))==0){
		        	    out.print("<a href=\"pfs?pagePath=/WEB-INF/html/need/modifyNeed.jsp\" class=\"btn btn-info\">修改该需求</a>");
		        	    out.print("<a href=\"checkAcNeedUserInfoAction\" class=\"btn btn-info\">查看接受需求用户信息</a>");      
		             }
		             else if(session.getAttribute("need_rec_state")!=null)
		            	switch(((Integer)session.getAttribute("need_rec_state"))){
		            		case 0:out.print("<a href=\"acceptNeedAction\" class=\"btn btn-info\">接受该需求</a>");break;
		            		case -1:out.print("<a href=\"cancelAcNeedAction\" class=\"btn btn-info\">取消接受该需求</a>");		            		
		            	}
		           }
		           
                    %>           
                </div>          		        
		        <hr>
		    </form>
		</div>
	</div>
	<div>
	    <p><a href="pfs?pagePath=/WEB-INF/html/adminSS/adminSubSystem.jsp">返回管理员子系统</a></p>	
	    <p><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></p>
	</div>
</body>
</html>