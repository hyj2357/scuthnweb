<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>上线活动</title>
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
        <h1 class="margin-bottom-15">修改活动</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="modifyActAction" method="post">
              <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        <input type="text" class="form-control" name="event_name"
                               <%Event evt = (Event)session.getAttribute("event"); 
                               out.print("value=\""+evt.getEvent_name()+"\"");%>
                               id="username" placeholder="标题">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <textarea class="form-control"  name="event_intro" rows="8" cols="50" placeholder="内容">
                              <% out.print(evt.getEvent_intro());%>
                        </textarea>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        最大参与人数:<input type="text" class="form-control" name="event_maxPeople"
                               <%out.print("value=\""+evt.getEvent_maxPeople()+"\"");%>
                               id="username" placeholder="标题">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        活动时间:<input type="text" class="form-control" name="event_time"
                               <%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                               out.print("value=\""+sdf.format(evt.getEvent_time())+"\"");%>
                               id="username" placeholder="标题">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        活动结束时间:<input type="text" class="form-control" name="event_endtime"
                               <% out.print("value=\""+sdf.format(evt.getEvent_endtime())+"\"");%>
                               id="username" placeholder="标题">
                    </div>
                </div>
            </div> 
            <div class="control-wrapper">
                    <% 
                        if(evt.getEvent_state()==0){
                            out.print("<a href=\"offLineActAction\" class=\"btn btn-info\">下线该活动</a>");
                            out.print("<a href=\"checkTakePartInUserInfoAction\" class=\"btn btn-info\">查看活动参与人员名单</a>");
                        }
                        else  
                        	out.print("<a href=\"onLineActAction\" class=\"btn btn-info\">上线该活动</a>");
                    %>
                    <a href="deleteActAction" class="btn btn-info">删除活动</a>            
                    <input type="submit" value="修改完毕" class="btn btn-info">            
            </div>          
            <hr>
        </form>
    </div>
</div>
</body>
</html>