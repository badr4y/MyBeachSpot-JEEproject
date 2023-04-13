<%@ page import="com.example.mybeachspot.Beach" %>
<%@ page import="com.example.mybeachspot.BeachReview" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: hossa
  Date: 4/9/2023
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/beachh.css">
  <style>
.addRating{margin: 25px;
}
    .beach{display: flex;
    gap:10px;}
    .ratings{
        display: flex;
        gap:10px;
        list-style: none ;
        flex-wrap: wrap;
    }
    .info{display:flex;
        flex-direction: column;

    }

  .review{
      border-radius: 15px;
      background-color : aqua;
      border: 1px solid black;
      width: 400px;
      padding: 15px;

  }
#current-temp1{
    margin-top:0;
    font-size:2em;
    font-weight:bold;
}
#current-temp1:after{
    content:"°";
}
#current-temp{
    margin-top:0;
    font-size:2em;
    font-weight:bold;
}


  </style>
</head>
<body>


<%
  // Get the list of data from the servlet
  Beach beach = (Beach) request.getAttribute("beach");
  // Loop through the list and generate a row for each item
    double d = Double.parseDouble(beach.getWeather().getTemp().toString());
 %>
<div class="beach">

    <img src="<%= beach.getBeachinfo().getPhoto_1() %>" alt="<%= beach.getBeachinfo().getName() %>">
   <div class="info">
       <span id="current-temp">
     <h2><%= beach.getBeachinfo().getName() %></h2>
     <p><%= beach.getBeachinfo().getDescription() %></p>
     <p><%= beach.getBeachinfo().getLocation() %></p>
       <p>weather: <%= beach.getWeather().getDescription() %></p>
       <p>wind: <%= beach.getWeather().getWind() %></p>
       </span>
       <p><span id="current-temp1">temp: <%= String.format("%.2f", d-273.15) %><span/><p/>
       <div>
           <% if (beach.getBeachinfo().getParking().toString().equals("Yes")){ %>
           <p><span class="tag tag-cloud-functions tag-lg">Parking<span/><p/>
           <%}%>
           <%if (beach.getBeachinfo().getDisabled_access().toString().equals("Yes")){ %>
           <p><span class="tag tag-cloud-functions tag-lg">Disability access<span/><p/>
           <%}%>
           <%if (Objects.equals(beach.getBeachinfo().getDog_friendly(), "Yes")){ %>
           <p><span class="tag tag-cloud-functions tag-lg">Dog friendly<span/><p/>
           <%}%>
           <%if (Objects.equals(beach.getBeachinfo().getRestrooms(), "Yes")){ %>
           <p><span class="tag tag-cloud-functions tag-lg">Restrooms<span/><p/>
           <%}%>
           <%if (Objects.equals(beach.getBeachinfo().getFishing(), "Yes")){ %>
           <p><span class="tag tag-cloud-functions tag-lg">Fishing<span/><p/>
           <%}%>
           <%if (Objects.equals(beach.getBeachinfo().getBoating(), "Yes")){ %>
           <p><span class="tag tag-cloud-functions tag-lg">Boating<span/><p/>
           <%}%>
       </div>




   </div>


</div>


<div class="addRating">
<form action="/MyBeachSpot_war/beach?id=<%= beach.getId() %>" method="POST">
    <label for="rating">Rating:</label>
    <select id="rating" name="rating" required >
        <option value="">Select a rating</option>
        <option value="1">1 - Poor</option>
        <option value="2">2 - Fair</option>
        <option value="3">3 - Average</option>
        <option value="4">4 - Good</option>
        <option value="5">5 - Excellent</option>
    </select><br><br>
    <label for="review">Review:</label><br>
    <textarea id="review" name="review" rows="4" cols="50" required ></textarea><br><br>
    <input type="submit" value="Submit">
</form>
</div>


<ul class = "ratings">





<%
    // Get the list of data from the servlet
    // Loop through the list and generate a row for each item
    for (BeachReview item : beach.getBeachReviews()) {
%>
<li class="review">
        <h2 class="rating"><%= item.getRating() %></h2>
        <p><%= item.getReview()  %></p>

</li>
<%
    }
%>

</ul>


</body>
</html>
