<%@ page language="java" import="com.scuthnweb.domain.*" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<title>注册</title>
        <link href="css/customers/style.css" rel='stylesheet' type='text/css' />
		<script type="text/javascript" src="js/customers/js0.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		
	</head>
	<body onload="createCode()">	
			<!--start-login-form-->
				<div class="main">
					<div  class="wrap">
						  <div class="Regisration">
						  	<div class="Regisration-head">
						    	<h2><span></span>注 册</h2>
						 	 </div>
						  	<form action="userIDRegistAction" method="post">
						  	   
                                <input type="text" value="用户名（真实姓名）" id="customer_name" name="customer_name" onblur="if(this.value.length<2||this.value.length>4){check_customer_name.style.display='block';} else{check_customer_name.style.display='none';}">
								<div id="check_customer_name" class="check">
								    <div style="display:inline-block;">
									  <img src="images/customers/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    用户名为2~4个字
									</div>
								</div>
								<input type="text" value="密码:5~20个字符" id="pwd1" name="customer_password" onfocus="this.setAttribute('type','password');" onblur="if(this.value.length<5||this.value.length>20){check_customer_password.style.display='block';} else{check_customer_password.style.display='none';}">
								
								<div id="check_customer_password" class="check">
								    <div style="display:inline-block;">
									  <img src="images/customers/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    密码为5~20个字符
									</div>
								</div>
								
								
								<li>
								<input type="text" value="确认密码" name="confirm_password" onfocus="this.setAttribute('type','password');" onblur="if (this.value == '') {this.value = '确认密码'; check_confirm_password.style.display='block';} else{check_confirm_password.style.display='none';}" >
								<div id="check_confirm_password" class="check">
								    <div style="display:inline-block;">
									  <img src="images/customers/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    请确认密码
									</div>
								</div>
								</li>
								<li>
						  		<input type="text" value="QQ号码" name="customer_qq"  onblur="if (this.value == '') {this.value = 'QQ号码'; check_customer_qq.style.display='block';} else{check_customer_qq.style.display='none';}" >
								<div id="check_customer_qq" class="check">
								    <div style="display:inline-block;">
									  <img src="images/customers/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    请输入qq号
									</div>
								</div>
								</li>
								<li>
						  		<input type="text" value="电子邮箱"name="customer_email"  onblur="if (this.value == '') {this.value = '电子邮箱'; check_customer_email.style.display='block';} else{check_customer_email.style.display='none';}">
							    <div id="check_customer_email" class="check">
								    <div style="display:inline-block;">
									  <img src="images/customers/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    请输入电子邮箱
									</div>
								</div>
								</li>
								<li>
						  		<input type="text" value="年级：格式如2XXX"name="customer_grade"  onblur="if(this.value.length!=4){check_customer_grade.style.display='block';} else{check_customer_grade.style.display='none';}" >
								<div id="check_customer_grade" class="check">
								    <div style="display:inline-block;">
									  <img src="images/customers/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    年级：格式如2XXX
									</div>
								</div>
								</li>
								
								<li>
								<input type="text" value="专业"name="customer_major" onblur="if (this.value == '') {this.value = '专业'; check_customer_magor.style.display='block';} else{check_customer_magor.style.display='none';}" >
								<div id="check_customer_magor" class="check">
								    <div style="display:inline-block;">
									  <img src="images/customers/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    请输入专业
									</div>
								</div>
								</li>
								
								<li>
								<input type="text" value="宿舍号" name="customer_room"  onblur="if (this.value == '') {this.value = '宿舍号'; check_customer_room.style.display='block';} else{check_customer_room.style.display='none';}" >
								<div id="check_customer_room" class="check">
								    <div style="display:inline-block;">
									  <img src="images/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    请输入宿舍号
								</div>
								</li>
								
								<li>
								<input type="text" value="手机号"name="customer_phone"  onblur="if (this.value == '') {this.value = '手机号'; check_customer_phone.style.display='block';} else{check_customer_phone.style.display='none';}" >
								<div id="check_customer_phone" class="check">
								    <div style="display:inline-block;">
									  <img src="images/customers/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    请输入手机号
									</div>
								</div>
								</li>
								<!--<input type="text" value="邀请码"name="invite_code_Content" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '邀请码'; check_invite_code_Content.style.display='block';} else{check_invite_code_Content.style.display='none';}" >
								<div id="check_invite_code_Content" class="check">
								    <div style="display:inline-block;">
									  <img src="../../images/customers/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    请输入邀请码
									</div>
								</div>
								<input id="inputCheckCode" style="width:35%;" type="text" value="验证码"  onfocus="this.value = '';"  onblur="if (this.value == '') {this.value = '验证码';check_inputCheckCode.style.display='block';} else{validateCode();} ">
								
								<div id="checkCode" style="display:inline-block" class="code" onclick="createCode()" >
								</div>
								<div  id="checkCode-inform"  onclick="createCode()">
								     点击<br/>换一张
								</div>
								<div id="check_inputCheckCode" class="check">
								    <div style="display:inline-block;">
									  <img src="../../images/customers/wrong.png">
									 </div> 
 								    <div style="display:inline-block;">
									    请输入验证码
									</div>
								</div>
								-->
						    <div class="Remember-me">
							    <div class="p-container">
								    <label class="checkbox"><input type="radio" name="customer_sex" value="0" checked><i></i>男</label>
									<label class="checkbox"><input type="radio" name="customer_sex" value="1" ><i></i>女</label>
								</div>
								<div class="p-container">
							        <label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>我同意条款</label>
								    <div class ="clear"></div>
							    </div>
												 
								<div class="submit">
									<input type="submit" onclick="myFunction()" value="提 交 >" >
								</div>
									<div class="clear"> </div>
							</div>
						  </form>
					</div>
					</div>
			</div>
				<!--//End-login-form-->	
						<div class ="copy-right">
							<p><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></p>
						</div>
			  
	</body>
</html>


