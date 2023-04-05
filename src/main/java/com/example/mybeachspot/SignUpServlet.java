package com.example.mybeachspot;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(value = "/signup")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mybeachspot";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private static final String SELECT_USER_SQL = "SELECT username FROM users WHERE username = ?";
    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password) VALUES (?, ?)";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        String error = null;

        if (!password.equals(confirmPassword)) {
            error = "Passwords do not match";
        } else {
            if (usernameExists(username)) {
                error = "Username already taken";
            } else {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                    PreparedStatement ps = conn.prepareStatement(INSERT_USER_SQL);
                    ps.setString(1, username);
                    ps.setString(2, password);

                    ps.executeUpdate();

                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);

                    response.sendRedirect(request.getContextPath() + "/home.jsp");

                    return;
                } catch (SQLException e) {
                    e.printStackTrace();
                    error = "An error occurred while accessing the database";
                }
            }
        }

        if (error != null) {
            response.sendRedirect("signup.jsp?error=" + error);
        }
    }

    private boolean usernameExists(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement ps = conn.prepareStatement(SELECT_USER_SQL);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
