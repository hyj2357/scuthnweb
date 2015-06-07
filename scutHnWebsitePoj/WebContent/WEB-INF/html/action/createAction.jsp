<%@ page language="java" contentType="text/html; charset=GBK"  pageEncoding="UTF-8"%>
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
			<h1 class="margin-bottom-15">上线活动</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="createActAction" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">
		            <div class="control-wrapper">
		            	<input type="text" class="form-control" name="event_name" id="event_name" placeholder="活动名称">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
                        <textarea class="form-control" rows="8" cols="50"  name="event_intro" id="event_intro" placeholder="活动介绍"></textarea>
		            </div>
		          </div>
		        </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="control-wrapper">
                            <textarea class="form-control" rows="1" cols="50"   name="event_time" id="event_time" placeholder="活动开始时间：年-月-日"></textarea>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="control-wrapper">
                            <textarea class="form-control" rows="1" cols="50"   name="event_endtime" id="event_endtime" placeholder="活动结束时间：年-月-日"></textarea>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-12">
                        <div class="control-wrapper">
                            <textarea class="form-control" rows="1" cols="50"   name="event_maxPeople" id="event_maxPeople" placeholder="活动最大人数"></textarea>
                        </div>
                    </div>
                </div>
                <div class="control-wrapper">
                    <input type="submit" value="提交" class="btn btn-info">
                </div>
		        <hr>
		    </form>
		</div>
	</div>
</body>
</html>