<%@ page language="java" contentType="text/html; charset=GBK"%>

<html>
<head>
<title>登录页面</title>
</head>
<body>
<form action="setNameAction" method="post">
    <table align="center">
    <caption><h3>管理员设置名称</h3></caption>
        <tr>
            <td>新名称：<input type="text" name="admin_nameM"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="确认修改"/><input type="reset" value="重填" /></td>
        </tr>
    </table>
</form>
</body>
</html>
