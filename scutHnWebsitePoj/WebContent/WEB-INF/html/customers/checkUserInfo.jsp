<%@ page language="java" import="com.scuthnweb.domain.*" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<title>查看信息</title>
        <link href="css/customers/style.css" rel='stylesheet' type='text/css' />
		<script type="text/javascript" src="js/customers/js0.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		
	</head>
	<body>	
			
				<div class="main">
					<!--start-ViewPerInfo-form-->
							<div class="ViewPerInfo">
						  	<div class="ViewPerInfo-head">
						    	<h2><span></span>个人信息</h2>
								
								<p style="color:#7E7B7B;"><a href="pfs?pagePath=/WEB-INF/html/customers/modifyUserInfo.jsp">修改信息</a></p>
						 	</div>
						  	<ul>
							    <li>
                             <h4>用户名:</h4>
								     <%
							           out.print("<div >"+((Customer)session.getAttribute("customer")).getName()+
							        		   "</div>");
							         %>		
							         <h4>性别:</h4>
                                     <%
							           out.print("<div >"+(((Customer)session.getAttribute("customer")).getCustomer_sex()==0?"男":"女")+
							        		   "</div>");
							         %>				 
					                 				 
					                 </li>
                                <li>								
								    <h4>年级:</h4>
                                    <%
							           out.print("<div >"+((Customer)session.getAttribute("customer")).getCustomer_grade()+
							        		   "</div>");
							         %>					 
					                <h4>专业:</h4>
                                     <%
							           out.print("<div >"+((Customer)session.getAttribute("customer")).getCustomer_major()+
							        		   "</div>");
							         %>				 
					                 </li> 
							    <li>				 
					                 <h4>手机号:</h4>
                                     <%
							           out.print("<div >"+((Customer)session.getAttribute("customer")).getCustomer_phone()+
							        		   "</div>");
							         %> 
							         <h4>电子邮箱:</h4>
                                    <%
							           out.print("<div >"+((Customer)session.getAttribute("customer")).getCustomer_email()+
							        		   "</div>");
							         %>	
            
                                </li>
                                <li>
                                	<h4>QQ号码:</h4>
								    <%
							           out.print("<div >"+((Customer)session.getAttribute("customer")).getCustomer_qq()+
							        		   "</div>");
							         %>
							        <h4>宿舍:</h4>
								    <%
							           out.print("<div >"+((Customer)session.getAttribute("customer")).getCustomer_room()+
							        		   "</div>");
							         %>	
						  	    </li>						  	
						  	</ul>
						</div>
			
				<!--//End-ViewPerInfo-form-->	
						<div class ="copy-right">
							<p><a href="pfs?pagePath=/WEB-INF/html/customer options/navigationPage.jsp">用户子系统</a></p>
							<p><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></p>						
						</div>
			  
	</body>
</html>			        