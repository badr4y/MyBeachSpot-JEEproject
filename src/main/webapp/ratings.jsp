<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/6/2023
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Ratings</title>
</head>
<body>
<h1>Ratings</h1>
<table>
  <thead>
  <tr>
    <th>Beach Name</th>
    <th>Rating</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${beachRatings}" var="beachRating">
    <tr>
      <td>${beachRating.beachName}</td>
      <td>${beachRating.rating}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>

