<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<title>修改密码</title>
        <link href="css/customers/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript" src="js/customers/js0.js"></script>
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		
	</head>
	<body onload="createCode()">	
			<!--start-login-form-->
			<div style="height:25%;width:100%;background-color:#2F4F4F;color:#ffffff;font-size:2.5em;font-weight:600;font-family:cursive;">
		         <img src="images/customers/password.png" style="width:10%;display:inline-block;"/>
				 <div style="display:inline-block;width:15%;">修改密码</div>
			</div>	
					   <div class="FindPwd">
							
						<form action="modifyPasswordAction" method="post">
						        
						        <div>
									<h4>&lowast;原密码</h4>
						  			<input type="password"  name="admin_password" onblur="if(this.value.length>=2&&this.value.length<=4){logname_inform_wrong.style.display='none'; logname_inform_right.style.display='block';FindPwd-rn.style.display='none';} else{logname_inform_right.style.display='none'; logname_inform_wrong.style.display='block';FindPwd-rn.style.display='none';}" >
									
						  			<div class="clear"> </div>
						  		</div>
						  		<div>
						  		<h4>&lowast;新密码</h4>
								<input  type="password"  name="admin_passwordM"  onblur="if(this.value.length>=5&&this.value.length<=20){logpwd_inform_right.style.display='block'; logpwd_inform_wrong.style.display='none';FindPwd-email.style.display='none';} else{logpwd_inform_right.style.display='none'; logpwd_inform_wrong.style.display='block';FindPwd-email.style.display='none';}">
								  									
											<div class="clear"> </div>
								</div>
								<div>
						  		<h4>&lowast;确认密码</h4>
								<input  type="password"  name="confirm_password"  onblur="if(this.value.length>=5&&this.value.length<=20){logpwd_inform_right.style.display='block'; logpwd_inform_wrong.style.display='none';FindPwd-email.style.display='none';} else{logpwd_inform_right.style.display='none'; logpwd_inform_wrong.style.display='block';FindPwd-email.style.display='none';}">
								  								
											<div class="clear"> </div>
								</div>
								
								<div class="ticker">
									<h4>&lowast;验证码</h4>
						  			<input style="width:30%;" type="text" onblur="if(validateCode()){checkCode_inform.style.display='block';} else{checkCode_inform.style.display='none';} " id="inputCheckCode">
									<div id="checkCode" style="display:inline-block;float:left;width:26%;margin-top:10px;" class="code" onclick="createCode()">
									</div>
									<div class="FindPwd-inform" id="checkCode_inform"> </div>
						  			<div class="clear"> </div>
						  		</div>
								
								<br/>
												 
								<div class="submit-button">
									<input type="submit" onclick="myFunction()" value="确认修改 >" >
								</div>
							</form>		<div class="clear"> </div>
					    </div>
			  
				<!--//End-login-form-->	
						<div class ="copy-right">
							<p><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></p>
						</div>
	</body>
</html>