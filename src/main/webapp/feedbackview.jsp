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