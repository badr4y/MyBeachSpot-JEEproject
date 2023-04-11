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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">
</head>
<body>
<nav>
  <ul>
    <li><a href="<%=request.getContextPath()%>/home">Home</a></li>
    <li><a href="<%=request.getContextPath()%>/share-review">Share a Review</a></li>
    <li><a href="<%=request.getContextPath()%>/ratings">Ratings</a></li>
    <li><a href="<%=request.getContextPath()%>/settings">Settings</a></li>
  </ul>
</nav>
<h1>Settings</h1>
<% if (request.getParameter("error") != null) { %>
<div class="error">
  <%= request.getParameter("error") %>
</div>
<% } %>
<form action="${pageContext.request.contextPath}/settings" method="POST">
  <label for='username'>Username:</label>
  <input type="text" id="username" name="username" value="${username}" required><br><br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>
  <label for="newpwd">New password:</label>
  <input type="password" id="newpwd" name="newpwd" required><br><br>
  <label for="password">Confirm new password:</label>
  <input type="password" id="confirmednewpwd" name="confirmednewpwd" required><br><br>
  <input type="submit" value="Save">
</form>
</body>
</html>

