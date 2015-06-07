<%@ page language="java" import="com.scuthnweb.domain.*" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>		
<title>华工海南同乡会</title>
<link href="css/bootstrap/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/index/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/index/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
    addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
</script>
<script type="text/javascript" src="js/index/jquery-1.10.2.min.js"></script>
<!---- start-smoth-scrolling---->
<script type="text/javascript" src="js/index/move-top.js"></script>
<script type="text/javascript" src="js/index/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>

		<script>
			$(function() {
				var pull 		= $('#pull');
					menu 		= $('nav ul');
					menuHeight	= menu.height();
				$(pull).on('click', function(e) {
					e.preventDefault();
					menu.slideToggle();
				});
				$(window).resize(function(){
	        		var w = $(window).width();
	        		if(w > 320 && menu.is(':hidden')) {
	        			menu.removeAttr('style');
	        		}
	    		});
			});
		</script>
<!----//End-top-nav-script---->
</head>
<body>
	<!----- start-header---->
			<div id="home" class="header">
					<div class="top-header">
						<div class="container">
							<div class="logo">
								<a href="#"><img src="images/index/logo.png" alt=""></a>  
							</div>
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
									<li><a href="pfs?pagePath=/WEB-INF/html/customers/changeUserPassword.jsp" >修改密码</a></li>
									<li><a href="#services" class="scroll">应用</a></li>
									<li><a href="#portfolio" class="scroll">头条</a></li>
									<li><a href="#hire" class="scroll">联系我们</a></li>
								</ul>
								<a href="#" id="pull"><img src="images/index/menu-icon.png" title="menu" /></a>
							</nav>
							<div class="clearfix"> </div>
						</div>
						<div class="tittle-head">
				        		<h1><b>华工海南同乡会</b></h1>
				          		<div class="learn-button">
				          			<a class="slide-btn" href="pfs?pagePath=/WEB-INF/html/adminSS/adminSubSystem.jsp">管理员子系统</a>				          		</div>
								<div class="learn-button">
				          			<a class="slide-btn" href="pfs?pagePath=/WEB-INF/html/customer options/navigationPage.jsp">导航界面</a>				          		</div>
				          		<div class="clear"> </div>
				          	</div>
				</div>
			</div>
		<!----- //End-header---->
		<!----- /start-services---->
			 <div id="services" class="Services">
	 			<div class="container">
		 			<div class="service-grides">
			 			<div class="col-md-4 service-grid">
			 				<div class="col-md-3 service-img">
			 					<img src="images/index/Act1.png" alt="">
			 				</div>
			 				<div class="col-md-9 service-text ">
			 					<h3>用户活动</h3>
			 					<p>如果用户想参与站内活动，可以点击当前活动界面上的“参与该活动”，如果当前活动未达到最大人数限制，即可报名参加该活动，系统显示报名成功。</p>
			 					<a href="#">详细信息</a>
			 				</div>
			 					<div class="clearfix"> </div>
			 			</div>
		 				<div class="col-md-4 service-grid">
			 				<div class="col-md-3 service-img">
			 					<img src="images/index/Sha1.png" alt="">
			 				</div>
			 				<div class="col-md-9 service-text ">
			 					<h3>资源共享</h3>
			 					<p>如果用户想上传链接，可进入用户上传链接页面，填写链接名称（20个字符内），及所指向的资源内容（无字符限制），再发送由系统交予管理员审核。</p>
			 					<a href="#">详细信息</a>
			 				</div>
			 					<div class="clearfix"> </div>
			 			</div>
			 			<div class="col-md-4 service-grid">
			 				<div class="col-md-3 service-img">
			 					<img src="images/index/Inf1.png" alt="">
			 				</div>
			 				<div class="col-md-9 service-text ">
			 					<h3>消息通知</h3>
			 					<p>用户注册后账号需要通过管理员审核通过后才能正常使用。管理员审核时需要做到用户信息准确对应正确信息，要遵循一定的规范才可审核通过，否则通知用户自行修改。</p>
			 					<a href="#">详细信息</a>
			 				</div>
			 					<div class="clearfix"> </div>
			 			</div>
		 				<div class="clear"> </div>
		 			</div>
	 			</div>
			 </div>
		 <div id="portfolio" class="main_bg">
    	  <div class="portfolio">
          		<div class="row">
            		<div id="slider1" class="grid-slider">
					<ul class="gs-list" data-title="">            	                  	
                     <li onclick="location.href='index.html';" data-src="images/index/final/top-1.png">
                            <a href="images/index/slider4.jpg"><img src="images/index/spacer.png" alt=""/></a>
                            <div>一些文字</div>
                        </li>
                        <li onclick="location.href='index.html';" data-src="images/index/final/meddile.png" data-colspan="2" data-rowspan="2" >
                            <a href="images/index/slider2.jpg" ><img src="images/index/spacer.png" alt=""/></a>
                        </li>                              
                        <li onclick="location.href='index.html';" data-src="images/index/final/top-3.png">
                            <a href="images/index/grid-pic1.jpg"><img src="images/index/spacer.png" alt=""/></a>
                            <div>一些文字</div>                          
                        </li>
                        <li onclick="location.href='index.html';" data-src="images/index/final/top-2.png">
                            <a href="images/index/grid-pic1.jpg"><img src="images/index/spacer.png" alt=""/></a>
                            <div>一些文字</div>                           
                        </li>
                        <li onclick="location.href='index.html';" data-src="images/index/final/top-4.png">
                            <a href="images/index/slider3.jpg"><img src="images/index/spacer.png" alt=""/></a>
                            <div>一些文字</div>
                        </li>
                      	<li onclick="location.href='index.html';" data-src="images/index/final/meddile.png" data-colspan="2" data-rowspan="2">
                        	<a href="images/index/slider1.jpg"><img src="images/index/spacer.png" alt=""/></a>
                        </li>
                        <li onclick="location.href='index.html';" data-src="images/index/final/bottom.png" data-rowspan="2">
                            <a href="images/index/slider3.jpg"><img src="images/index/spacer.png" alt=""/></a>
                            <div>一些文字</div>
                        </li>
                        <li onclick="location.href='index.html';" data-src="images/index/final/top-3.png">
                            <a href="images/index/slider1.jpg"><img src="images/index/spacer.png" alt=""/></a>
							<div>一些文字</div>
                        </li>
    					<li onclick="location.href='index.html';" data-src="images/index/final/top-4.png">
                            <div>一些文字</div>
                        </li>
                      	 <li onclick="location.href='index.html';" data-src="images/index/final/top-1.png">
                            <a href="images/index/slider4.jpg"><img src="images/index/spacer.png" alt=""/></a>
                            <div>一些文字</div>
                        </li>
                        <li onclick="location.href='index.html';" data-src="images/index/final/meddile.png" data-colspan="2" data-rowspan="2" >
                            <a href="images/index/slider2.jpg" ><img src="images/index/spacer.png" alt=""/></a>
                        </li>                              
                        <li onclick="location.href='index.html';" data-src="images/index/final/top-3.png">
                            <a href="images/index/grid-pic1.jpg"><img src="images/index/spacer.png" alt=""/></a>
                            <div>一些文字</div>                          
                        </li>
                        <li onclick="location.href='index.html';" data-src="images/index/final/top-2.png">
                            <a href="images/index/grid-pic1.jpg"><img src="images/index/spacer.png" alt=""/></a>
                            <div>一些文字</div>                           
                        </li>
                        <li onclick="location.href='index.html';" data-src="images/index/final/top-4.png">
                            <a href="images/index/slider3.jpg"><img src="images/index/spacer.png" alt=""/></a>
                            <div>一些文字</div>
                        </li>
                    </ul>
                    
				</div>
      	</div>
	</div>
    	<div class="clear"></div>
    </div> 
	    <!---start-script-gallery--->
   		  <link rel="stylesheet" href="css/index/grid-slider.css" type="text/css" media="screen" />
	    <script type="text/javascript" src="js/index/jquery.grid-slider.min.js"></script>
	    <script type="text/javascript" src="js/index/jquery.wt-lightbox.min.js"></script>    
	    <script type="text/javascript" src="js/index/demo.js"></script>
	<!---//End-script-gallery--->
	<!------------/start-hear-me---------->
		   	<div id="hire" class="contact">
		   		<div class="container">
		   			<div class="contact-head">
		   				<h3>联系 <span>我们</span></h3>
		   				<p>期待听到你的声音!</p>
		   				<div class="social-icons">
										<ul class="t-social unstyled-list list-inline">
											<li><a class="email" href="#"><span> </span></a></li>
											<li><a class="tel" href="#"><span> </span></a></li>
											<li><a class="qq" href="#"><span> </span></a></li>
											<li><a class="WeChat" href="#"><span> </span></a></li>
											<div class="clearfix"> </div>
										</ul>
									</div>
							</div>

		   			
		   			</div>
		   			
		   		</div>
		   		<div class="footer">
		   			<div class="container">
			   			<div class="copy-right">
			   					<p>&copy; <a href="http://www.scut.edu.cn">华南理工大学</a></p>
						</div>
					</div>
		   		</div>
				<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
					<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>