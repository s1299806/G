<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/4/2023
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register account</title>
</head>
<body>
<H2>Register account</H2>
<form:form method="POST" modelAttribute="ticketUser">
    <form:label path="username">Username</form:label><br/>
    <form:input type="text" path="username"/><br/><br/>
    <form:label path="password">Password</form:label><br/>
    <form:input type="text" path="password"/><br/><br/>
    <form:label path="emailaddr">Email Address</form:label><br/>
    <form:input type="text" path="emailaddr"/><br/><br/>
    <br/><br/>
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>
