<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>修改需求</title>
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
        <h1 class="margin-bottom-15">修改需求</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="modifyNeedAction" method="post">
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        <input type="text" class="form-control" name="need_name"                                
                        <%Need nd = (Need)session.getAttribute("need"); 
                               out.print("value=\""+nd.getNeed_name()+"\"");%>
                        id="username" placeholder="标题">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <textarea class="form-control" name="need_content" rows="8" cols="50" placeholder="需求">
                            <% 
                               out.print(nd.getNeed_content());%>
                        </textarea>
                    </div>
                </div>
            </div>
            <div class="control-wrapper">
                <input type="submit" value="修改完毕" class="btn btn-info">     
                <a href="delNeedAction" class="btn btn-info">删除需求</a> 
                <%         
                    if(nd.getNeed_state()==0)
                      out.print("<a href=\"setNeedSuccAction\" class=\"btn btn-info\">设置需求为已解决</a>"); 
                 %>
            </div>
            <hr>
        </form>
    </div>
</div>
</body>