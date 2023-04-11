package com.example.mybeachspot;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mybeachspot";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private static final String UPDATE_USER_SQL = "UPDATE users\n" + "SET password_hash = ? WHERE username = ?";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the user's information from the database
        String username = (String) request.getSession().getAttribute("username");

        // Pass the user's information to the JSP page
        request.setAttribute("username", username);
        request.getRequestDispatcher("/settings.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the user's information from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newpwd = request.getParameter("newpwd");
        String confirmednewpwd = request.getParameter("confirmednewpwd");

        String error = null;

        // Check if the password is incorrect
        if (!Authenticator.authenticate(username, password)) {
            error = "Incorrect password or username";
        } else if (!newpwd.equals(confirmednewpwd)) {
            error = "New passwords do not match";
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // Update the user's information in the database
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                PreparedStatement ps = conn.prepareStatement(UPDATE_USER_SQL);
                ps.setString(1, PasswordHash.createHash(newpwd));
                ps.setString(2, username);
                ps.executeUpdate();

                // Redirect the user back to the settings page
                response.sendRedirect(request.getContextPath() + "/settings");
            } catch (SQLException e) {
                e.printStackTrace();
                error = "An error occurred while accessing the database";
            } catch (Exception e) {
                throw new ServletException("Error creating password hash", e);
            }
        }
        if (error != null) {
            response.sendRedirect("settings.jsp?error=" + error);
        }
    }
}

