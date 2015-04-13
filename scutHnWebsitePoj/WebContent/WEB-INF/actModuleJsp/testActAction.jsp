<%@ page language="java" contentType="text/html; charset=GBK"%>

<html>
<head>
<title>登录页面</title>
</head>
<body>
<form action="testActAction" method="post">
    <table align="center">
    <caption><h3>转发测试Action</h3></caption>
        <tr>
            <td>Action名称：<input type="text" name="pageName"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="转发"/><input type="reset" value="重填" /></td>
        </tr>
    </table>
</form>

    private final String  CHECKALLACT = "checkAllAct",
    		              CHECKPUBLISH = "checkPublish",
    		              CHECKTAKEPARTIN = "checkTakePartIn",
    		              CHECKTAKEPARTINUSERINFO = "checkTakePartInUserInfo",
    		              CREATEACT = "createAct",
    		              DELETEACT = "deleteAct",
    		              EXITACT = "exitAct",
    		              MODIFYACT = "modifyAct",
    		              OFFLINEACT="offLineAct",
    		              ONLINEACT = "onLineAct",
    		              TAKEPARTINACT = "takePartInAct";
     
</body>
</html>
