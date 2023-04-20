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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup.css">
  <style>
body {
  margin: 0;
  padding: 0;
  font-family: Arial, Helvetica, sans-serif;
  background-color: #f2f2f2;
}
h1 {
  text-align: center;
  font-size: 36px;
  margin-top: 50px;
}
form {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: white;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}
label {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 10px;
  display: block;
}
input[type="text"],
select,
textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
  font-size: 16px;
  margin-bottom: 20px;
}
input[type="submit"] {
  background-color: #333;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 18px;
}
input[type="submit"]:hover {
  background-color: #ddd;
  color: black;
}
</style>
</head>
<body>
<nav>
<ul>
<li><a href="<%=request.getContextPath()%>/home">Home</a></li>
<li><a href="<%=request.getContextPath()%>/share-review">Share your experience</a></li>
<li><a href="<%=request.getContextPath()%>/ratings">Ratings</a></li>
<li><a href="<%=request.getContextPath()%>/settings">Settings</a></li>
</ul>
</nav>
<h1>Share your Experience</h1>
<form action="share-review" method="POST">
<label for="beach-name">Beach Name:</label>
<input type="text" id="beach-name" name="beachName">
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

