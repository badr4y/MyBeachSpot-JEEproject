<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<h1>Login</h1>
<% if (request.getParameter("error") != null) { %>
<div class="error">
    <%= request.getParameter("error") %>
</div>
<% } %>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <input type="submit" value="Login">
</form>
<div class="signup-link">
    <a href="${pageContext.request.contextPath}/signup">Don't have an account? Sign up here.</a>
</div>
</body>
</html>

