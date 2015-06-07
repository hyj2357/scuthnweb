<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>公告信息</title>
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
       <div>
        <h1 class="margin-bottom-15">公告信息</h1>       
       <div>
       <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="#" method="post">
             <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                    <%  int type = ((Note)session.getAttribute("note")).getNote_type();  
                        out.print("<input type=\"text\" readonly=\"true\" class=\"form-control\" value="+
                                  "["+(type!=0?(type!=1?"大杂烩":"活动总结"):"事务通知")+"]"+((Note)session.getAttribute("note")).getNote_name()
                                  +"/>");
                    %>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                    <%     out.print("<textarea class=\"form-control\" readonly=\"true\" rows=\"8\" cols=\"50\">"+
                           ((Note)session.getAttribute("note")).getNote_content() +"</textarea>");
                    %>
                    </div>
                </div>
            </div>  
            <div>
                <%
               Admin ad = (Admin)session.getAttribute("admin");
               Note  nt = ((Note)session.getAttribute("note"));
               if(ad!=null&&nt.getNote_publisher().getId()==ad.getId())
            	   if(nt.getNote_state()==1)
		               out.print("<p><a href=\"offlineNoteAction?note_state=0\">上线该公告信息</a></p>");
            	   else
		               out.print("<p><a href=\"offlineNoteAction?note_state=1\">下线该公告信息</a></p>");
%>                 
                       
            </div>
            <hr>
        </form>
    </div>
</div>
<%
               if(ad!=null&&((Note)session.getAttribute("note")).getNote_publisher().getId()==ad.getId())
		          out.print("<p><a href=\"pfs?pagePath=/WEB-INF/html/admin/modifyNote.jsp\">修改公告信息</a></p>");
%>          
<p><a href="pfs?pagePath=/WEB-INF/html/index/index.jsp">返回主页</a></p>
<p><a href="pfs?pagePath=/WEB-INF/html/adminSS/adminSubSystem.jsp">返回管理员子系统</a></p>
</body>
</html>