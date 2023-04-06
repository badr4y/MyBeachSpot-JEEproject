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
<h1>Share a Review</h1>
<form action="share-review" method="POST">
  <label for="beach-name">Beach Name:</label>
  <input type="text" id="beach-name" name="beachName"><br><br>
  <label for="review">Review:</label><br>
  <textarea id="review" name="review" rows="4" cols="50"></textarea><br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>

