<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/4/2023
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Sign Up</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">

</head>
<body>
<div class="container">
  <div class="form-container">
    <h1>Sign Up</h1>
    <% if (request.getParameter("error") != null) { %>
    <div class="error">
      <%= request.getParameter("error") %>
    </div>
    <% } %>
    <form action="signup" method="post">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required>
      <label for="confirmPassword">Confirm Password:</label>
      <input type="password" id="confirmPassword" name="confirmPassword" required>
      <input type="submit" value="Sign Up">
    </form>
    <p class="signup-link">Already have an account? <a href="login.jsp">Login here</a>.</p>
  </div>
</div>
</body>
</html>