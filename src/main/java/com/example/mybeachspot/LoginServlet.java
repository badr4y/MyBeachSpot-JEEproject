package com.example.mybeachspot;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("new_login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String error = null;

        if (Authenticator.authenticate(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect(request.getContextPath() + "/home");
            return;
        } else {
            error = "Invalid username or password";
        }

        if (error != null) {
            response.sendRedirect("new_login.jsp?error=" + error);
        }
    }
}