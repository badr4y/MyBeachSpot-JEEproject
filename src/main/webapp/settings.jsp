<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/6/2023
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Settings</title>
</head>
<body>
<h1>Settings</h1>
<form action="${pageContext.request.contextPath}/settings" method="POST">
  <label for="username">Username:</label>
  <input type="text" name="username" value="${user.username}" required><br><br>
  <label for="email">Email:</label>
  <input type="email" name="email" value="${user.email}" required><br><br>
  <label for="password">Password:</label>
  <input type="password" name="password" required><br><br>
  <input type="submit" value="Save">
</form>
</body>
</html>

