<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">
    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">-->
</head>
<body>
<div class="container">
    <div class="form-container">
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
        <p class="signup-link">Don't have an account? <a href="${pageContext.request.contextPath}/signup">Sign up here.</a></p>
    </div>
</div>
</body>
</html>