<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<title>登陆</title>
        <link href="css/customers/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript" src="js/customers/js0.js"></script>
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		
	</head>
	<body onload="createCode()">	
			<!--start-login-form-->
				<div class="main">
					<div class="wrap">
					   <div class="Login">
							<div class="Login-head">
						    	<h3>登 陆</h3>
						 	</div>

						<form action="adminLoginAction" method="post">								<div>
									<h4>管理员id</h4>
						  			<input type="text" name="admin_id"  onblur="if(this.value.length>=2&&this.value.length<=4){logname_inform_wrong.style.display='none'; logname_inform_right.style.display='block';} else{logname_inform_right.style.display='none'; logname_inform_wrong.style.display='block';}" >
									<div class="log-inform" id="logname_inform_right"></div>
									<div class="log-inform1" id="logname_inform_wrong"></div>
						  			<div class="clear"> </div>
						  		</div>
						  		<div>
						  		<h4>密码</h4>
								<input  type="password" name="admin_password"  onblur="if(this.value.length>=5&&this.value.length<=20){logpwd_inform_right.style.display='block'; logpwd_inform_wrong.style.display='none';} else{logpwd_inform_right.style.display='none'; logpwd_inform_wrong.style.display='block';}">
								  	<div class="log-inform" id="logpwd_inform_right"></div>
									<div class="log-inform1" id="logpwd_inform_wrong"></div>		
											<div class="clear"> </div>
								</div>
								<div class="ticker">
									<h4>验证码</h4>
						  			<input style="width:30%;" type="text" onblur="if(validateCode()){checkCode_inform.style.display='block';} else{checkCode_inform.style.display='none';} " id="inputCheckCode">
									<div id="checkCode" style="display:inline-block;float:left;width:30%;margin-top:10px;" class="code" onclick="createCode()">
									</div>
									<div class="log-inform" id="checkCode_inform"> </div>
						  			<div class="clear"> </div>
						  		</div>
						  		
								<!--  
								<div class="checkbox-grid">
									 <div class="inline-group green">
									     <label class="radio"><input type="radio" name="radio-inline"><i> </i>用户登录</label>
									     <label class="radio"><input type="radio" name="radio-inline"><i> </i>管理员登陆</label>
								         <div class="clear"> </div>
									</div>
					
								</div>
								-->		 
								<div class="submit-button">
									<input type="submit" onclick="myFunction()" value="登 陆  >" >
								</div>
									<div class="clear"> </div>
					    </div>
											
						  </form>
					</div>
			   </div>
				<!--//End-login-form-->	
						<div class ="copy-right">
							<p><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></p>
						</div>
			  </div>
	</body>
</html>