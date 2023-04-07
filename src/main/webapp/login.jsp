<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Beach Search - Login</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/login.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid vh-100 d-flex align-items-center justify-content-center">
    <div class="card shadow-lg p-4 rounded-lg">
        <div class="card-header bg-primary text-white">
            <h3 class="text-center">MyBeach Spot</h3>
            <p class="text-center">Please log in to your account</p>
        </div>
        <div class="card-body">
            <% if (request.getParameter("error") != null) { %>
            <div class="error">
                <%= request.getParameter("error") %>
            </div>
            <% } %>
            <form action="${pageContext.request.contextPath}/loginServlet" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" placeholder="Enter username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter password">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="rememberMe">
                    <label class="form-check-label" for="rememberMe">Remember me</label>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Log in</button>
                </div>
            </form>
        </div>
        <div class="signup-link card-footer">
            <p class="text-center mb-0">Don't have an account? <a href="${pageContext.request.contextPath}/signup">Sign up</a></p>
        </div>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js" integrity="sha512-AZONshwiGucJm96lp+ETxTrwWcK+1vdVdAEJzgP9j0ZQ2kJCUaAOT94klGpKkxw1NOcRpYhB+z1q3Uv9pdKjGg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>




