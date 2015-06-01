<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Spring Security Example</title>
</head>
<body>
<h1>Hello, world!</h1>
<ul>
    <li><a href="/logout">Logout</a></li>
    <sec:authorize access="hasAnyRole('USER', 'ADMIN')">
        <li><a href="/app/user">User</a></li>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ADMIN')">
        <li><a href="/app/admin">Admin</a></li>
    </sec:authorize>
</ul>
</body>
</html>
