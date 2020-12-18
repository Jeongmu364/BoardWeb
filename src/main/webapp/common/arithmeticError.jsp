<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-12-15 015
  Time: 오후 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>기본 에러 화면</title>
</head>
<body bgcolor="white" text="black">
<table width="100%" border="1" cellpadding="0" cellspacing="0">
    <tr><td align="center" bgcolor="orange"><b>기본 에러 화면입니다.</b></td> </tr>
</table>
<br>
<table width="100%" border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td align="center">
            <br><br><br><br><br>
            Message: ${exception.message}
            <br><br><br><br><br>
        </td>
    </tr>
</table>
</body>
</html>
