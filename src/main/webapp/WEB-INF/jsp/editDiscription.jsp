<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31/3/2023
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit discription</title>
    <h2>Edit discription</h2>
    <p>
        <form:form method="POST" enctype="multipart/form-data" modelAttribute="discriptionForm">
            <form:label path="body">Body</form:label><br/>
            <form:textarea path="body" rows="5" cols="30"/><br/><br/>
            <input type="submit" value="Submit"/>
        </form:form>
    </p>
</head>
<body>

</body>
</html>
