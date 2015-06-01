<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Security Example</title>
</head>
<body>
<h1>Login</h1>
<ul>
    <form action="/logincheck" method="POST">
        <label for="username">Username:</label>
        <input type="text" value="" name="username" placeholder="Username..." id="username"/> <br/>
        <label for="password">Password:</label>
        <input type="password" value="" name="password" placeholder="Password..." id="password"/> <br/>
        <button type="submit">Login</button>
    </form>
</ul>
</body>
</html>
