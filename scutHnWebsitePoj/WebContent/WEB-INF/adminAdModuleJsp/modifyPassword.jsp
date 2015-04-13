<%@ page language="java" contentType="text/html; charset=GBK"%>

<html>
<head>
<title>登录页面</title>
</head>
<body>
<form action="modifyPasswordAction" method="post">
    <table align="center">
    <caption><h3>管理员修改密码</h3></caption>
        <tr>
            <td>原密码：<input type="text" name="admin_password"/></td>
        </tr>
        <tr>
            <td>修改密&nbsp;&nbsp;码：<input type="text" name="admin_passwordM"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="确认修改"/><input type="reset" value="重填" /></td>
        </tr>
    </table>
</form>
</body>
</html>
