package com.example.mybeachspot;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the user's information from the database
        User user = new User("johndoe", "johndoe@example.com");

        // Pass the user's information to the JSP page
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/views/settings.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the user's information from the request
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Update the user's information in the database

        // Redirect the user back to the settings page
        response.sendRedirect(request.getContextPath() + "/settings");
    }
}

