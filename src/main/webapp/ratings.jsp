<%@ page import="com.example.mybeachspot.BeachReview" %>
<%@ page import="java.util.List" %><%--
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ratings.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
  <style>
    table {
      border-collapse: collapse;
      width: 100%;
      margin-top: 40px;
      font-size: 18px;
    }

    th {
      text-align: left;
      background-color: #f2f2f2;
      padding: 8px;
    }

    td {
      border-bottom: 1px solid #ddd;
      padding: 8px;
      word-wrap: break-word;
      max-width: 300px;
    }

    td:first-child {
      width: 40%;
    }

    td:nth-child(2) {
      width: 20%;
    }

    td:last-child {
      width: 40%;
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
<div class="container">
  <div class="form-container">
    <h1>Ratings</h1>
    <table>
      <thead>
      <tr>
        <th>Beach Name</th>
        <th>Rating</th>
        <th>Review</th>
      </tr>
      </thead>
      <tbody>
      <%
        // Get the list of data from the servlet
        List<BeachReview> beachReviews = (List<BeachReview>) request.getAttribute("beachReviews");
        // Loop through the list and generate a row for each item
        for (BeachReview item : beachReviews) {
      %>
      <tr>
        <td><%= item.getBeachName() %></td>
        <td><%= item.getRating() %></td>
        <td><%= item.getReview() %></td>
      </tr>
      <%
        }
      %>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>

