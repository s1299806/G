<!DOCTYPE html>
<html>
<head>
    <title>User profile</title>
</head>
<body>
<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" method="post">
    <input type="submit" value="Logout" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<p>
    <a href="<c:url value="/ticket" />">Return to list tickets</a><br/>
    <a href="<c:url value="/ticket/create" />">Create a Ticket</a><br/>
    <a href="<c:url value="/profile/edit" />">Edit Profile</a>
</p>
<h2>User profile</h2>
<p>
<c:forEach items="${ticketUsers}" var="user">
    Name: ${user.username}<br/>
    Email: ${user.emailaddr}<br/>
    Discription:<c:out value="${user.discription}"/><br/>
</p>
</c:forEach>
<p>
    <c:choose>
        <c:when test="${fn:length(ticketDatabase) == 0}">
            <i>There are no tickets in the system.</i>
        </c:when>
        <c:otherwise>
            <c:forEach items="${ticketDatabase}" var="entry">
                Ticket ${entry.id}:
                <a href="<c:url value="/ticket/view/${entry.id}" />">
                    <c:out value="${entry.subject}"/></a>
                (customer: <c:out value="${entry.customerName}"/>)
                <security:authorize access="hasRole('ADMIN') or
                principal.username=='${entry.customerName}'">
                    [<a href="<c:url value="/ticket/edit/${entry.id}" />">Edit</a>]
                </security:authorize>
                <security:authorize access="hasRole('ADMIN')">
                    [<a href="<c:url value="/ticket/delete/${entry.id}" />">Delete</a>]
                </security:authorize>
                <br/>
                Ticket created: <fmt:formatDate value="${entry.createTime}"
                                                pattern="EEE, d MMM yyyy HH:mm:ss Z"/><br/>
                Ticket updated: <fmt:formatDate value="${entry.updateTime}"
                                                pattern="EEE, d MMM yyyy HH:mm:ss Z"/><br/><br/>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</p>
</body>
</html>