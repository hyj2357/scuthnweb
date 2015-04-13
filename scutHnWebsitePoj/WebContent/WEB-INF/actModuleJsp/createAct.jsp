<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<html>
<head>
<title>登录页面</title>
</head>
<body>
<form action="createActAction" method="post">
    <table align="center">
    <caption><h3>创建新活动</h3></caption>
        <tr>
            <td>活动名称：<input type="text" name="event_name"/></td>
        </tr>
        <tr>
            <td>活动介绍：<input type="text" name="event_intro"/></td>
        </tr>                
        <tr>
            <td>活动时间：<input type="text" name="event_time"/></td>
        </tr>
        <tr>
            <td>活动结束时间：<input type="text" name="event_endtime"/></td>
        </tr>
        <tr>
            <td>活动最大参与人数：<input type="text" name="event_maxPeople"/></td>
        </tr>
        
        <tr align="center">
            <td colspan="2"><input type="submit" value="登录"/><input type="reset" value="重填" /></td>
        </tr>
    </table>
</form>
</body>
</html>
