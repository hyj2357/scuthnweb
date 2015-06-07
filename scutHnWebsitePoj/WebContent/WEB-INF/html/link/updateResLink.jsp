<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</html>
<head>
    <title>修改链接</title>
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
        <h1 class="margin-bottom-15">修改链接</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="updateLinkAction" method="post">
              <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        <input type="text" class="form-control" name="share_link_name"
                               <%Share_link sl = (Share_link)session.getAttribute("resLink"); 
                               out.print("value=\""+sl.getShare_link_name()+"\"");%>
                               id="username" placeholder="标题">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <textarea class="form-control"  name="share_link_content" rows="8" cols="50" placeholder="内容">
                              <% out.print(sl.getShare_link_content());%>
                        </textarea>
                    </div>
                </div>
            </div>
            <div class="control-wrapper">
                    <a href="delLinkAction" class="btn btn-info">删除链接</a>            
                    <input type="submit" value="修改完毕" class="btn btn-info">            
            </div>          
            <hr>
        </form>
    </div>
</div>
</body>
</html>