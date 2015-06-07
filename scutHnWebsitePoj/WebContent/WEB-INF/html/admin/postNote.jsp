<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
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
			<h1 class="margin-bottom-15">发布公告信息</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="postNoteAction" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">
		            <div class="control-wrapper">
		            	<input type="text" class="form-control" name="note_name" id="note_name" placeholder="公告信息名称">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
                        <textarea class="form-control" rows="8" cols="50" name="note_content" id="note_content" placeholder="公告信息内容"></textarea>
		            </div>
		          </div>
		        </div>
		        <div>
                <h4>信息类别</h4><select name="note_type" class="sex"> 
                       <option value ="0">事务通知</option>  
                       <option value ="1">活动通知</option> 
                       <option value ="2">大杂烩</option>                                           
                  </select><br/><br/>		        
		        </div>
		        <div class="control-wrapper">
                    <input type="submit" value="提交" class="btn btn-info">
                </div>                
		    </form>
		</div>
	</div>

</body>
</html>