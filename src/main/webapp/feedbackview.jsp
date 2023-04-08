<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Beach Feedback</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">My Beach Spot</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="feedback.jsp">Feedback</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="feedbackview.jsp">Ratings</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="settings.jsp">Settings</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link text-danger btn btn-danger" href="#">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1>Beach Feedback</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Rating</th>
            <th>Feedback</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="feedback" items="${feedbackList}">
            <tr>
                <td>${feedback.name}</td>
                <td>${feedback.email}</td>
                <td>${feedback.rating}</td>
                <td>${feedback.feedback}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>