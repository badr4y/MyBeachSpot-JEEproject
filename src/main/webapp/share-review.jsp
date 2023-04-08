<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/6/2023
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Share a Review</title>
</head>
<body>
<nav>
  <ul>
    <li><a href="<%=request.getContextPath()%>/home">Home</a></li>
    <li><a href="<%=request.getContextPath()%>/share-review">Share your Experience</a></li>
    <li><a href="<%=request.getContextPath()%>/ratings">Ratings</a></li>
    <li><a href="<%=request.getContextPath()%>/settings">Settings</a></li>
  </ul>
</nav>
<h1>Share your Experience</h1>
<form action="share-review" method="POST">
  <label for="beach-name">Beach Name:</label>
  <input type="text" id="beach-name" name="beachName"><br><br>
  <label for="rating">Rating:</label>
  <select id="rating" name="rating">
    <option value="">Select a rating</option>
    <option value="1">1 - Poor</option>
    <option value="2">2 - Fair</option>
    <option value="3">3 - Average</option>
    <option value="4">4 - Good</option>
    <option value="5">5 - Excellent</option>
  </select><br><br>
  <label for="review">Review:</label><br>
  <textarea id="review" name="review" rows="4" cols="50"></textarea><br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>

