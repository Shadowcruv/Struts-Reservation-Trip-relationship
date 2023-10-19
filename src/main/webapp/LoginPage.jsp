<%--
  Created by IntelliJ IDEA.
  User: HP 840 G3
  Date: 17/10/2023
  Time: 02:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<h1>Login Page</h1>

<s:form action="login" method="Post">

    <s:textfield name="userName" label="UserName"></s:textfield>
    <s:textfield name="password" label="Password"></s:textfield>

    <s:submit value="submit" />
</s:form>
</body>
</html>
