<%@ page language="java" import="com.scuthnweb.domain.*" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<title>修改个人信息</title>
        <link href="css/customers/style.css" rel='stylesheet' type='text/css' />
		<script type="text/javascript" src="js/customers/js0.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		
	</head>
	<body onload="createCode()">	
			
				<div class="main">
					<!--start-Modify-form-->
						<div class="Modify">
						  	<div class="Modify-head">
						    	<h2><span></span>修改信息</h2>
						 	</div>
						<form action="modifyUserInfoAction" method="post">
                                <div>
						  		    <h4>用户名</h4>						  		    
						  		    <%
						  		       out.print("<input type=\"text\" value="+((Customer)session.getAttribute("regCustomer")).getName()
						  		                +" name=\"customer_name\"  onblur=\"if (this.value == '') {this.value = ''; check_customer_name.style.display='block';} else{check_customer_name.style.display='none';}\" >");
						  		    %>
						  		    <h4>用户密码</h4>						  		    
						  		    <%
						  		       out.print("<input type=\"text\" value="+((Customer)session.getAttribute("regCustomer")).getCustomer_password()
						  		                +" name=\"customer_password\"  onblur=\"if (this.value == '') {this.value = ''; check_customer_password.style.display='block';} else{check_customer_password.style.display='none';}\" >");
						  		    %>		  		     
						  		</div>
							    <div>								
						  		    <h4>QQ号码</h4>						  		    
						  		    <%
						  		       out.print("<input type=\"text\" value="+((Customer)session.getAttribute("regCustomer")).getCustomer_qq()
						  		                +" name=\"customer_qq\"  onblur=\"if (this.value == '') {this.value = ''; check_customer_qq.style.display='block';} else{check_customer_qq.style.display='none';}\" >");
						  		    %>
									
								    <h4>电子邮箱</h4>
								    <%
						  		       out.print("<input type=\"text\" value="+((Customer)session.getAttribute("regCustomer")).getCustomer_email()
						  		                +" name=\"customer_email\"  onblur=\"if (this.value == '') {this.value = ''; check_customer_email.style.display='block';} else{check_customer_email.style.display='none';}\" >");
						  		    %>									
							    </div>
							    <div>
						  		     <h4>年级</h4>
									 <%
						  		       out.print("<input type=\"text\" value="+((Customer)session.getAttribute("regCustomer")).getCustomer_grade()
						  		                +" name=\"customer_grade\"  onblur=\"if (this.value == '') {this.value = ''; check_customer_grade.style.display='block';} else{check_customer_grade.style.display='none';}\" >");
						  		    %>
								     <h4>专业</h4>
									 <%
						  		       out.print("<input type=\"text\" value="+((Customer)session.getAttribute("regCustomer")).getCustomer_major()
						  		                +" name=\"customer_major\"  onblur=\"if (this.value == '') {this.value = ''; check_customer_major.style.display='block';} else{check_customer_major.style.display='none';}\" >");
						  		     %>	
						  		 </div>
						  		 <div>						
								     <h4>手机号</h4>
									 <%
						  		       out.print("<input type=\"text\" value="+((Customer)session.getAttribute("regCustomer")).getCustomer_phone()
						  		                +" name=\"customer_phone\"  onblur=\"if (this.value == '') {this.value = ''; check_customer_phone.style.display='block';} else{check_customer_phone.style.display='none';}\" >");
						  		     %>
						             <h4>宿舍号</h4>
								     <%
						  		       out.print("<input type=\"text\" value="+((Customer)session.getAttribute("regCustomer")).getCustomer_room()
						  		                +" name=\"customer_room\"  onblur=\"if (this.value == '') {this.value = ''; check_customer_room.style.display='block';} else{check_customer_room.style.display='none';}\" >");
						  		     %>
						  		</div> 
						  		
							    <div>
									 <h4>性别</h4>
								     <select name="customer_sex" class="sex">  
                                         <option value ="0">男</option>  
                                         <option value ="1">女</option>  
                                     </select> 
								
								    
								         <h4>验证码</h4>
									     <input id="inputCheckCode"  type="text" value="验证码"  onfocus="this.value = '';"  onblur="if (this.value == '') {this.value = '验证码';check_inputCheckCode.style.display='block';} else{validateCode();} ">
				                    
									<div id="checkCode" style="display:inline-block" class="code" onclick="createCode()" >
								    </div>
								    <div  id="checkCode-inform"  onclick="createCode()">
								         点击<br/>换一张
								    </div>
								</div>     
						   
								
							
						    <div class="Remember-me">
							    <div class="submit">
									<input type="submit" onclick="myFunction()" value="提 交 >" >
								</div>
									<div class="clear"> </div>
							</div>
											
						  </form>
					    </div>
						  
			    </div>
			
				<!--//End-Modify-form-->	
						<div class ="copy-right">
							<p><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></p>
						</div>
			  
	</body>
</html>