<%@ page language="java" contentType="text/html; charset=GBK"%>

<html>
<head>
<title>��¼ҳ��</title>
</head>
<body>
<form action="testActAction" method="post">
    <table align="center">
    <caption><h3>ת������Action</h3></caption>
        <tr>
            <td>Action���ƣ�<input type="text" name="pageName"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="ת��"/><input type="reset" value="����" /></td>
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
