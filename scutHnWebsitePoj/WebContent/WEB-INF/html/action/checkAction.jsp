<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>活动详细信息</title>
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
        <h1 class="margin-bottom-15">活动详细信息</h1>
        <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="op_linkAction" method="post">
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        <input type="text" class="form-control" readonly="true"
                               <%Event evt = (Event)session.getAttribute("event"); 
                               out.print("value=\""+evt.getEvent_name()+"\"");%>
                               id="username" placeholder="标题">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                        <textarea class="form-control"  readonly="true" rows="8" cols="50" placeholder="内容">
                              <% out.print(evt.getEvent_intro());%>
                        </textarea>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        最大参与人数:<input type="text" class="form-control" readonly="true"
                               <%out.print("value=\""+evt.getEvent_maxPeople()+"\"");%>
                               id="username" placeholder="标题">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        活动时间:<input type="text" class="form-control" readonly="true"
                               <%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                               out.print("value=\""+sdf.format(evt.getEvent_time())+"\"");%>
                               id="username" placeholder="标题">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                        活动结束时间:<input type="text" class="form-control" readonly="true"
                               <% out.print("value=\""+sdf.format(evt.getEvent_endtime())+"\"");%>
                               id="username" placeholder="标题">
                    </div>
                </div>
            </div>                                    
            <div class="control-wrapper">
               <%
                    int k=0;
                    Admin ad = (Admin)session.getAttribute("admin"); 
                    if(ad!=null) {
                      k=2;
                      if(evt.getEvent_publisher().getId()==ad.getId())
                        out.print("<a href=\"pfs?pagePath=/WEB-INF/html/action/modifyAction.jsp\" class=\"btn btn-info\">修改活动</a>");                  
                    }
                %>
                <%
                    Customer cs = null;
                    if(k!=2)
                    	cs = (Customer)session.getAttribute("customer");
                    if(cs!=null){
                    	int hasFound = ((Integer)session.getAttribute("event_take_state")).intValue();
                    	switch(hasFound){
                    	case 0:out.print("<a href=\"exitActAction\" class=\"btn btn-info\">退出活动</a>");break;
                    	case 1:out.print("<a href=\"takePartInActAction\" class=\"btn btn-info\">参加活动</a>");
                    }
                    }
                %>
                <a href="checkAllActAction" class="btn btn-info">返回列表</a>
            </div>
            <hr>
        </form>
    </div>
</div>
</body>
</html>