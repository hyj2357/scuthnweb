<%@ page language="java" import="com.scuthnweb.domain.*" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<link href="css/bootstrap/bootstrap.css" rel='stylesheet' type='text/css'/>
<link href="css/adminSS/style.css" rel="stylesheet" type="text/css" media="all"/>
<link rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<!--script-->
<script type="text/javascript" src="js/adminSS/move-top.js"></script>
<script type="text/javascript" src="js/adminSS/easing.js"></script>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>
<!---->
</head>
<body>
<!---->
<div class="banner">
	 <div class="container">
							<!----start-top-nav---->
							 <nav class="top-nav">
								<ul class="top-nav"><!-- 条件判断状态栏 -->
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
								    <li><a href="pfs?pagePath=/WEB-INF/html/customers/userRegist.jsp" >注册</a></li>
								</ul>
							</nav>
		<div class="banner-info text-center">
			<h1>WELCOME</h1>
		  <a class="logo" href="#"><img src="images/adminSS/logo1.png" alt=""/></a>
		 <a class="button" href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返 回 主 页</a>
		 </div>
	 </div>
</div>
<!---->
<div class="preparation">
	 <div class="wrap">
			<h2>目 录</h2>
			<div class="top-sec">
				<div class="col-md-4 pre-sec">
                    <img src="images/adminSS/p1.png" alt=""/>
                    <h3>管理用户</h3>
                    <div><a href="checkAllRegInfoAction">审核用户注册信息（批准/注销）</a></div>
                    <div><a href="checkVerifyLinkAction">审核用户上传连接（批准/拒绝）</a></div>
                    <div><a href="checkAllUserInfoAction">查看/修改网站用户信息</a></div>
                </div>
				<div class="col-md-4 pre-sec">
					<img src="images/adminSS/p2.png" alt=""/>
                    <h3>活动及需求管理</h3>
                    <div><a href="checkAllActAction">查看所有活动</a></div>                    
                    <div><a href="checkPublishAction">查看个人发布的活动</a></div>                    
                    <div><a href="pfs?pagePath=/WEB-INF/html/action/createAction.jsp">上线活动</a></div>
                </div>
				<div class="col-md-4 pre-sec">
					<img src="images/adminSS/p3.png" alt=""/>
                    <h3>管理员个人管理</h3>
                    <div><a href="pfs?pagePath=/WEB-INF/html/admin/setName.jsp">设置名称</a></div>
                    <div><a href="pfs?pagePath=/WEB-INF/html/admin/modifyPassword.jsp">修改密码</a></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="botm-sec">
				<div class="col-md-4 pre-sec">
					<img src="images/adminSS/p4.png" alt=""/>
                    <h3>管理员信息发布功能</h3>
                    <div><a href="pfs?pagePath=/WEB-INF/html/admin/postNote.jsp">发布信息</a></div>
                    <div><a href="checkAllNoteAction">查看所有消息</a></div>
                    <div><a href="checkPostNoteAction">查看个人发布消息</a></div>                                    
                </div>
				<div class="col-md-4 pre-sec">
				</div>
                <div class="col-md-4 pre-sec">
                    <img src="images/adminSS/p5.png" alt=""/>
                    <h3>管理员信息发布功能</h3>
                    <div><a href="#">发送站内消息</a></div>
                    <div><a href="checkAllNoteAction">查看站内消息</a></div>
                </div>
				<div class="clearfix"></div>
			</div>
	 </div>
</div>

<div class="trip">
<h3>Administer</h3>
</div>
