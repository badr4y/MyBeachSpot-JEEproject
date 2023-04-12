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
  <title>newhome</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
<head/>


  <div class="container">

    <%
        // Get the list of data from the servlet
        List<Beach> beaches = (List<Beach>) request.getAttribute("beaches");
        // Loop through the list and generate a row for each item
        for (Beach item : beaches) {
    %>



  <div class="blog-card spring-fever">
  <div class="title-content">
    <h3><a href="/MyBeachSpot_war/beach?id=<%= item.getId() %>"><%= item.getBeachinfo().getName() %></a></h3>
    <div class="intro"><%= item.getBeachinfo().getDescription() %></div>
  </div>
  <div class="card-info">
    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim...
    <a href="#">Read Article<span class="licon icon-arr icon-black"></span></a>
  </div>
  <div class="utility-info">
    <ul class="utility-list">
      <li><span class="licon icon-like"></span><a href="#">2</a></li>
      <li><span class="licon icon-com"></span><a href="#">12</a></li>
      <li><span class="licon icon-dat"></span>03 jun 2017</li>
      <li><span class="licon icon-tag"></span><a href="#">Photos</a>, <a href="#">Nice</a></li>
    </ul>
  </div>
  <div class="gradient-overlay"></div>
  <div class="color-overlay"></div>
</div>
  <%
        }
    %><!-- /.blog-card -->

  </div>
  <html/>