<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<html>
<head>
<title>��¼ҳ��</title>
</head>
<body>
<form action="createActAction" method="post">
    <table align="center">
    <caption><h3>�����»</h3></caption>
        <tr>
            <td>����ƣ�<input type="text" name="event_name"/></td>
        </tr>
        <tr>
            <td>����ܣ�<input type="text" name="event_intro"/></td>
        </tr>                
        <tr>
            <td>�ʱ�䣺<input type="text" name="event_time"/></td>
        </tr>
        <tr>
            <td>�����ʱ�䣺<input type="text" name="event_endtime"/></td>
        </tr>
        <tr>
            <td>�������������<input type="text" name="event_maxPeople"/></td>
        </tr>
        
        <tr align="center">
            <td colspan="2"><input type="submit" value="��¼"/><input type="reset" value="����" /></td>
        </tr>
    </table>
</form>
</body>
</html>
