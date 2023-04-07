<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/4/2023
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Beach Search - Login</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/signup.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid vh-100 d-flex align-items-center justify-content-center">
  <div class="card shadow-lg p-4 rounded-lg">
    <div class="card-header bg-primary text-white">
      <h3 class="text-center">Create Your Account</h3>
      <p class="text-center">Find the perfect beach for you</p>
    </div>
    <div class="card-body">
      <% if (request.getParameter("error") != null) { %>
      <div class="error">
        <%= request.getParameter("error") %>
        <% } %>
      <form action="signup" method="post">
        <div class="mb-3">
          <label for="Username" class="form-label">Username</label>
          <input type="text" class="form-control" id="username" placeholder="Enter your username" required>
        </div>
        <div class="mb-3">
          <label for="email" class="form-label">Email address</label>
          <input type="email" class="form-control" id="email" placeholder="Enter your email" required>
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" placeholder="Enter your password" required>
        </div>
        <div class="mb-3">
          <label for="confirm-password" class="form-label">Confirm Password</label>
          <input type="password" class="form-control" id="confirm-password" placeholder="Confirm your password" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Create Account</button>
      </form>
    </div>
    <div class="signup-link card-footer text-center">
      <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Log in here</a></p>
    </div>
  </div>
</div>
<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js" integrity="sha512-AZONshwiGucJm96lp+ETxTrwWcK+1vdVdAEJzgP9j0ZQ2kJCUaAOT94klGpKkxw1NOcRpYhB+z1q3Uv9pdKjGg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>