<%@ page import="com.example.mybeachspot.Beach" %>
<%@ page import="java.util.List" %><%--
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
    <style>
        /* navbar styles */
        nav {
            background-color: #333;
            color: #fff;
            display: flex;
            justify-content: space-between;
            padding: 10px 20px;
        }

        nav ul {
            display: flex;
            list-style: none;
            margin: 0;
            padding: 0;
        }

        nav ul li {
            margin-left: 20px;
        }

        nav ul li a {
            color: #fff;
            text-decoration: none;
            transition: color 0.2s ease-in-out;
        }

        nav ul li a:hover {
            color: #a3a3a3;
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
        <li style="float:right"><a href="<%=request.getContextPath()%>/login.jsp">Logout</a></li>
    </ul>
</nav>
<h1>Welcome to the Home Page</h1>
<p>Hi <%= session.getAttribute("username") %>, you have successfully logged in!</p>
<h1>List of Items</h1>


<ul>


    <%
        // Get the list of data from the servlet
        List<Beach> beaches = (List<Beach>) request.getAttribute("beaches");
        // Loop through the list and generate a row for each item
        for (Beach item : beaches) {
    %>
    <li>
        <a href="/MyBeachSpot_war/beach?id=<%= item.getId() %>">
        <h2><%= item.getBeachinfo().getName() %></h2>
        <img src="<%= item.getBeachinfo().getPhoto_1() %>" alt="<%= item.getBeachinfo().getName() %>">
        <p><%= item.getBeachinfo().getDescription() %></p>
        </a>
    </li>
    <%
        }
    %>
</ul>
</body>
</html>