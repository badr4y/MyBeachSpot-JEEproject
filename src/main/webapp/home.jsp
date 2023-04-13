
<%@ page import="com.example.mybeachspot.Beach" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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



    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>

<nav class="navMenu">

    <ul>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nav_bar.css">
        <li><a href="<%=request.getContextPath()%>/home">Home</a></li>
        <li><a href="<%=request.getContextPath()%>/ratings">Ratings</a></li>
        <li><a href="<%=request.getContextPath()%>/settings">Settings</a></li>
        <li style="float:right"><a href="<%=request.getContextPath()%>/login.jsp">Logout</a></li>
    </ul>
</nav>
<h1>Welcome to the Home Page</h1>
<p>Hi <%=session.getAttribute("username")%>, you have successfully logged in!</p>
<h1>List of Items</h1>


<div class="container">

    <%
        // Get the list of data from the servlet
        List<Beach> beaches = (List<Beach>) request.getAttribute("beaches");
        // Loop through the list and generate a row for each item
        for (Beach item : beaches) {
            List<String> img_url = new ArrayList<>();
            if (item.getBeachinfo().getPhoto_1() != null) {
                img_url.add(item.getBeachinfo().getPhoto_1().toString());
            }
            if (item.getBeachinfo().getPhoto_2() != null) {
                img_url.add(item.getBeachinfo().getPhoto_2().toString());
            }
            if (item.getBeachinfo().getPhoto_3() != null) {
                img_url.add(item.getBeachinfo().getPhoto_3().toString());
            }
            if (item.getBeachinfo().getPhoto_4() != null) {
                img_url.add(item.getBeachinfo().getPhoto_4().toString());
            }

            String imageurl = img_url.get(0).toString();

    %>



    <div class="blog-card spring-fever">
      <a href="/MyBeachSpot_war/beach?id=<%=item.getId()%>"><img src="<%=imageurl%>" class="background"></a>
        <div class="title-content">
            <h3><a href="/MyBeachSpot_war/beach?id=<%=item.getId()%>"><%=item.getBeachinfo().getName()%></a></h3>
            <div class="intro"><%=item.getBeachinfo().getDescription()%></div>
        </div>


        <div class="gradient-overlay"></div>
        <div class="color-overlay"></div>
    </div>
    <%
                }
                %><!-- /.blog-card -->

</div>
</body>
</html>