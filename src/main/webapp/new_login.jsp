<!DOCTYPE html>
<!---Coding By CoderGirl | www.codinglabweb.com--->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--<title>Login & Registration Form | CoderGirl</title>-->
    <!---Custom CSS File--->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/logincss.css">
</head>
<body>
<% if (request.getParameter("error") != null) { %>
<div class="error">
    <%= request.getParameter("error") %>
</div>
<% } %>

<div class="container">
    <input type="checkbox" id="check">
    <div class="login form">
        <header>Login</header>
        <form action="${pageContext.request.contextPath}/loginServlet" method="post">
            <input type="text" placeholder="Enter your username" name="username">
            <input type="password" placeholder="Enter your password" name="password">
            <input type="submit" class="button" value="Login">
        </form>
        <div class="signup">
        <span class="signup">Don't have an account?
         <label for="check">Signup</label>
        </span>
        </div>
    </div>
    <div class="registration form">
        <header>Signup</header>
        <form action="${pageContext.request.contextPath}/signup" method="post">
            <input type="text" placeholder="Enter your username" name="username">
            <input type="password" placeholder="Create a password" name="password">
            <input type="password" placeholder="Confirm your password" name="confirmPassword">
            <input type="submit" class="button" value="Signup">
        </form>
        <div class="signup">
        <span class="signup">Already have an account?
         <label for="check">Login</label>
        </span>
        </div>
    </div>
</div>
</body>
</html>

