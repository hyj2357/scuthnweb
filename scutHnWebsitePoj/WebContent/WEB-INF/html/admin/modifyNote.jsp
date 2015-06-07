<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ page import="com.scuthnweb.domain.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
			<h1 class="margin-bottom-15">修改公告信息</h1>
       <form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="modifyNoteAction" method="post">
             <div class="form-group">
                <div class="col-xs-12">
                    <div class="control-wrapper">
                    <%  int type = ((Note)session.getAttribute("note")).getNote_type();  
                        out.print("<input type=\"text\" name=\"note_name\" class=\"form-control\" value="+
                                  ((Note)session.getAttribute("note")).getNote_name()
                                  +"/>");
                    %>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12">
                    <div class="control-wrapper">
                    <%     out.print("<textarea name=\"note_content\" class=\"form-control\" rows=\"8\" cols=\"50\">"+
                           ((Note)session.getAttribute("note")).getNote_content() +"</textarea>");
                    %>
                    </div>
                </div>
            </div>  
            <h4>信息类别</h4><select name="note_type" class="sex"> 
                       <option value ="0">事务通知</option>  
                       <option value ="1">活动通知</option> 
                       <option value ="2">大杂烩</option>                                           
              </select><br/><br/>		        
		    <hr>
            <div class="control-wrapper">
                    <input type="submit" value="提交" class="btn btn-info">
            </div>                
         </form>
		</div>
	</div>
</body>
</html>