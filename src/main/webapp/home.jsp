<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/5/2023
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">
</head>
<body>

<nav>
    <ul>
        <li><a href="<%=request.getContextPath()%>/home">Home</a></li>
        <li><a href="<%=request.getContextPath()%>/share-review">Share your experience</a></li>
        <li><a href="<%=request.getContextPath()%>/ratings">Ratings</a></li>
        <li><a href="<%=request.getContextPath()%>/settings">Settings</a></li>
        <li style="float:right"><a href="<%=request.getContextPath()%>/login.jsp">Logout</a></li>
    </ul>
</nav>
<div class="container">
    <div class="form-container">
        <h1>Welcome to MyBeachSpot</h1>
        <p>Hi <%= session.getAttribute("username") %>, you have successfully logged in!</p>
        <img src="<%=request.getContextPath()%>/logo.png" style="max-width:100%; height:auto;">
    </div>
</div>

</body>
</html>