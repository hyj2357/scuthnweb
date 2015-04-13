<%@ page language="java" contentType="text/html; charset=GBK"%>

<html>
<head>
<title>登录页面</title>
</head>
<body>
<form action="adminLoginAction" method="post">
    <table align="center">
    <caption><h3>管理员登录</h3></caption>
        <tr>
            <td>用户ID：<input type="text" name="admin_id"/></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码：<input type="text" name="admin_password"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="登录"/><input type="reset" value="重填" /></td>
        </tr>
    </table>
</form>
</body>
</html>
